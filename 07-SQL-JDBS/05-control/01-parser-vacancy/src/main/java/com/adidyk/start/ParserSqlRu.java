package com.adidyk.start;

import com.adidyk.models.Vacancy;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import static com.adidyk.setup.Constant.*;

/**
 * Class ParserSqlRu used for parses section job-offers (table vacancy) from website sql.ru and
 * adds new vacancy to database base_vacancy to table vacancy.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 23.10.2018.
 * @version 1.0.
 */
class ParserSqlRu {

    /**
     * @param logger - link variable to object of class Logger.
     */
    private static final Logger logger = Logger.getLogger(ParserSqlRu.class);

    /**
     * @param list - list vacancy (link variable to object of class ArrayList).
     */
    private ArrayList<Vacancy> list = new ArrayList<>();

    /**
     * parserDate - link variable to object of class ParserDate.
     */
    private ParserDate parserDate;

    /**
     * ParserDate - constructor.
     * @param parserDate - link variable to object of class ParserDate.
     */
    ParserSqlRu(ParserDate parserDate) {
        this.parserDate = parserDate;
    }

    /**
     * getLastDate - connects to database base_vacancy and searches vacancy with last date in table vacancy
     * and returns it minus one day.
     * @return - returns vacancy with last date from table vacancy minus one day.
     */
    Date getLastDate() {
        Date lastDate = null;
        try (java.sql.Connection connect = DriverManager.getConnection(URL_BASE_VACANCY, USER_NAME, PASSWORD);
             Statement statement = connect.createStatement();
             ResultSet result = statement.executeQuery(MAX_DATE)) {
            while (result.next()) {
                lastDate = result.getDate("date");
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return this.parserDate.getYesterdayDate(lastDate);
    }

    /**
     * checkTableIsEmpty - checks table (query sql) vacancy is empty (first start program).
     * If table vacancy is empty returns true or returns false if table vacancy is not empty.
     * @return - returns true if table vacancy is empty, returns false if table vacancy is not empty.
     */
    boolean checkTableIsEmpty() {
        boolean tableIsEmpty = false;
        try (java.sql.Connection connect = DriverManager.getConnection(URL_BASE_VACANCY, USER_NAME, PASSWORD);
             Statement statement = connect.createStatement();
             ResultSet result = statement.executeQuery(COUNT)) {
            while (result.next()) {
                if (result.getInt(1) == ZERO) {
                    tableIsEmpty = true;
                }
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return tableIsEmpty;
    }

    /**
     * searchPageByDate - purses html page used Jsoup and searches number of page
     * in section job-offers to website sql.ru by input date and returns it.
     * @param targetDate - target date.
     * @return - returns number of page by input date.
     */
    int searchPageByDate(Date targetDate)  {
        int page = 1;
        boolean search = true;
        try {
            while (search) {
                Connection connection = Jsoup.connect(URL_SQL_RU + page);
                Document document = connection.get();
                Elements posts = document.getElementsByAttributeValue(CLASS, POSTS_LIST_TOPIC);
                search = this.searchDateInPage(posts, targetDate);
                page++;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return --page;
    }

    /**
     * searchDateInPage - skips the first three topics (SKIP_ROW) from the moderators ans beginning searches
     * for date in the elements by input date and returns true if search result is true.
     * @param posts - all post from page job-offers from sql.ru.
     * @param targetDate - target date.
     * @return - returns true if search result is true.
     */
    private boolean searchDateInPage(Elements posts, Date targetDate) {
        boolean searchResult = false;
        int row = 1;
        for (Element post : posts) {
            Date currentDate = this.parserDate.parse(post.nextElementSibling().nextElementSibling().nextElementSibling()
                    .nextElementSibling().text());
            if (row > SKIP_ROW) {
                if (this.compareDate(currentDate, targetDate) >= ZERO) {
                    searchResult = true;
                    break;
                }
            }
            row++;
        }
        return !searchResult;
    }

    /**
     * compareDate - compares current date with target date.
     * @param currentDate - current date.
     * @param targetDate - target date.
     * @return - returns int result: -1 or 0 or 1.
     */
    private int compareDate(Date currentDate, Date targetDate) {
        return targetDate.compareTo(currentDate);
    }

    /**
     * parse - parses html page used Jsoup (section job-offers website sql.ru), searches all
     * vacancies by pattern java and adds vacancies to list.
     */
    void parse(String url)  {
        Connection connection = Jsoup.connect(url);
        Document document;
        try {
            document = connection.get();
            Elements posts = document.getElementsByAttributeValue(CLASS, POSTS_LIST_TOPIC);
            for (Element post : posts) {
                if (PATTERN_JAVA.matcher(post.child(ZERO).text()).find()) {
                    String theme  = post.child(ZERO).text();
                    String author = post.nextElementSibling().text();
                    int answers = Integer.parseInt(post.nextElementSibling().nextElementSibling().text());
                    int viewers = Integer.parseInt(post.nextElementSibling().nextElementSibling().nextElementSibling().text());
                    Date date = this.parserDate.parse(post.nextElementSibling().nextElementSibling().
                            nextElementSibling().nextElementSibling().text());
                    Vacancy vacancy = new Vacancy(theme, author, answers, viewers, date);
                    this.list.add(vacancy);
                }
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * addVacancy - adds all vacancies from list to database base_vacancy to table vacancy and
     * clears list.
     */
    void addVacancy() {
        try (java.sql.Connection connect = DriverManager.getConnection(URL_BASE_VACANCY, USER_NAME, PASSWORD)) {
            connect.setAutoCommit(false);
            try (PreparedStatement statement = connect.prepareStatement(ADD_VACANCY)) {
                for (Vacancy vacancy : this.list) {
                    statement.setString(1, vacancy.getTheme());
                    statement.setString(2, vacancy.getAuthor());
                    statement.setInt(3, vacancy.getAnswers());
                    statement.setInt(4, vacancy.getViewers());
                    statement.setTimestamp(5, new Timestamp(vacancy.getDate().getTime()));
                    statement.executeUpdate();
                }
            } catch (SQLException ex) {
                connect.rollback();
            }
            connect.commit();
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        }
        this.list.clear();
    }

}