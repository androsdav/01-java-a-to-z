package com.adidyk.start;

import com.adidyk.models.Vacancy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
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
public class ParserSqlRu {

    /**
     * @param list - list vacancy.
     */
    private ArrayList<Vacancy> list = new ArrayList<>();

    /**
     * @param pattern - pattern.
     */
    private final Pattern pattern = Pattern.compile("(?i)\\bjava\\b");

    private ParserDate parserDate = new ParserDate();

    private final String stringTarget = "31 дек 17, 13:28";
    private final Date dateTarget = this.parserDate.parse(stringTarget);
    private final int ZERRO = 0;

    public boolean checkFirstStart() throws SQLException {
        boolean tableIsEmpty = false;
        java.sql.Connection connect = DriverManager.getConnection(URL_BASE_VACANCY, USER_NAME, PASSWORD);
        Statement statement = connect.createStatement();
        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM vacancy LIMIT 1");
        while (result.next()) {
            if (result.getInt(1) == 0) {
                System.out.println("count: " + result.getInt(1));
                tableIsEmpty = true;
            }
        }
        return tableIsEmpty;
    }

    public int searchPage() throws IOException {
        int page = 1;
        boolean andros = true;
        String url = "http://www.sql.ru/forum/job-offers/";
        while (andros) {
            Connection connection = Jsoup.connect(url + page);
            Document document = connection.get();
            Elements posts = document.getElementsByAttributeValue("class", "postslisttopic");
            andros = this.searchInPage(posts);
            page++;
            System.out.println();
        }
        page--;
        return page;
    }

    public boolean searchInPage(Elements posts) {
        boolean searchResult = false;
        int number = 1;
        for (Element post : posts) {
            Date date = this.parserDate.parse(post.nextElementSibling().nextElementSibling().
                    nextElementSibling().nextElementSibling().text());
            System.out.println(date);
            if (number > 3) {
                if (this.compareDate(date) >= ZERRO) {
                    searchResult = true;
                    break;
                }
            }
            number++;
        }
        return !searchResult;
    }

    /**
     *
     * @param date - date.
     */
    public int compareDate(Date date) {
        return this.dateTarget.compareTo(date);
    }


    /*
    public void test() throws IOException {
        String stringTarget = "31 дек 17, 13:28";
        String string1 = "30 дек 17, 13:28";
        Date dateTarget = this.parserDate.parse(stringTarget);
        Date date1 = this.parserDate.parse(string1);
        System.out.println(dateTarget);
        System.out.println(date1);
        System.out.println(dateTarget.compareTo(date1));
*/

        //Date dateToday = new Date();
        //System.out.println(dateToday);
        //Date dateOther = new Date();

        //Timestamp timestamp = new Timestamp(1502041448453l);
// System.out.println(timestamp); выведет "2017-08-06 20:44:08.453"
        //LocalDate localDateTime = timestamp.toLocalDateTime().toLocalDate();

        //LocalDate now = LocalDate.now();
// System.out.println(now); выведет "2017-08-06"

// Выведет 0;
        //S/ystem.out.println("test");
        //System.out.println(now.compareTo(localDateTime));
        ///поделитьсяулучшить этот ответ


        /*
        Connection connect = Jsoup.connect(url);
        Document document = connect.get();T
        Elements posts = document.getElementsByAttributeValue("class", "postslisttopic");
        */

    //}

    /**
     *
     * @return
     */
    public int searchPageNumber () {
       return -1;
    }



    /**
     * parserJsoup - parser jsoup.
     */
    void parse(String url) throws IOException {
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        Elements posts = document.getElementsByAttributeValue("class", "postslisttopic");
        for (Element post : posts) {
            if (this.pattern.matcher(post.child(0).text()).find()) {
                String theme  = post.child(0).text();
                String author = post.nextElementSibling().text();
                int answers = Integer.parseInt(post.nextElementSibling().nextElementSibling().text());
                int viewers = Integer.parseInt(post.nextElementSibling().nextElementSibling().nextElementSibling().text());
                Date date = this.parserDate.parse(post.nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text());
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