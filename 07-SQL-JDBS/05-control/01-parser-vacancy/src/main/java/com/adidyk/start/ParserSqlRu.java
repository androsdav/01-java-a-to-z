package com.adidyk.start;

import com.adidyk.models.Vacancy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import static com.adidyk.setup.Constant.*;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 23.10.2018.
 * @version 1.0.
 */
class ParserSqlRu {

    /**
     * @param list - list vacancy.
     */
    private ArrayList<Vacancy> list = new ArrayList<>();

    /**
     * @param pattern - pattern.
     */
    private final Pattern pattern = Pattern.compile("(?i)\\bjava\\b");

    /**
     * parserDate - parserDate.
     */
    private ParserDate parserDate;

    //private final Date dateTarget = this.parserDate.parse("31 дек 17, 13:28");
    private static int ZERO = 0;
    private final static String COUNT = "SELECT COUNT(*) FROM vacancy LIMIT 1";
    private static String URL_SQL_RU = "http://www.sql.ru/forum/job-offers/";
    private static String CLASS = "class";
    private static String POSTS_LIST_TOPIC = "postslisttopic";
    private static int SKIP_ROW = 3;
    private static String MAX_DATE = "SELECT vacancy.date FROM vacancy WHERE vacancy.date IN (SELECT MAX(vacancy.date) FROM vacancy)";

    /**
     * ParserDate - constructor.
     * @param parserDate - link variable to object of class ParserDate.
     */
    ParserSqlRu(ParserDate parserDate) {
        this.parserDate = parserDate;
    }

    /**
     *
     * @return - true.
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
            ex.printStackTrace();
        }
        return this.parserDate.getYesterdayDate(lastDate);
    }

//    SELECT vacancy.date FROM vacancy WHERE vacancy.date IN (SELECT MAX(vacancy.date) FROM vacancy);


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
            ex.printStackTrace();
        }
        return tableIsEmpty;
    }

    /**
     * searchPageByDate - is.
     * @param dateTarget - is.
     * @return - is.
     */
    int searchPageByDate(Date dateTarget) throws IOException {
        int page = 1;
        boolean search = true;
        while (search) {
            Connection connection = Jsoup.connect(URL_SQL_RU + page);
            Document document = connection.get();
            Elements posts = document.getElementsByAttributeValue(CLASS, POSTS_LIST_TOPIC);
            search = this.searchDateInPage(posts, dateTarget);
            page++;
        }
        return --page;
    }

    /**
     * searchDateInPage - search date in page.
     * @param posts - is posts.
     * @param dateTarget - date target.
     * @return - returns date target.
     */
    private boolean searchDateInPage(Elements posts, Date dateTarget) {
        boolean searchResult = false;
        int row = 1;
        for (Element post : posts) {
            Date currentDate = this.parserDate.parse(post.nextElementSibling().nextElementSibling().nextElementSibling()
                    .nextElementSibling().text());
            if (row > SKIP_ROW) {
                System.out.println(currentDate);
                if (this.compareDate(currentDate, dateTarget) >= ZERO) {
                    searchResult = true;
                    break;
                }
            }
            row++;
        }
        return !searchResult;
    }

    /**
     * compareDate - compare date.
     * @param currentDate - is date.
     * @param targetDate - is date.
     * @return - is.
     */
    private int compareDate(Date currentDate, Date targetDate) {
        return targetDate.compareTo(currentDate);
    }

    /**
     * parserJsoup - parser jsoup.
     */
    void parse(String url) throws IOException {
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        Elements posts = document.getElementsByAttributeValue(CLASS, POSTS_LIST_TOPIC);
        for (Element post : posts) {
            if (this.pattern.matcher(post.child(0).text()).find()) {
                String theme  = post.child(0).text();
                String author = post.nextElementSibling().text();
                int answers = Integer.parseInt(post.nextElementSibling().nextElementSibling().text());
                int viewers = Integer.parseInt(post.nextElementSibling().nextElementSibling().nextElementSibling().text());
                Date date = this.parserDate.parse(post.nextElementSibling().nextElementSibling().
                        nextElementSibling().nextElementSibling().text());
                Vacancy vacancy = new Vacancy(theme, author, answers, viewers, date);
                this.list.add(vacancy);
            }
        }
    }

    /**
     *
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
            ex.printStackTrace();
        }
        this.list.clear();
    }

    /**
     * getList - get list.
     */
    ArrayList<Vacancy> getList() {
        return this.list;
    }

}