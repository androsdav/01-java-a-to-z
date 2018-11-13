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

    public boolean checkFirstStart() throws SQLException {
        boolean tabeIsEmpty = true;
        java.sql.Connection connect = DriverManager.getConnection(URL_BASE_VACANCY, USER_NAME, PASSWORD);
        Statement statement = connect.createStatement();
        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM vacancy");
        while (result.next()) {
            if (result.getInt(1) > 0) {
                table
                System.out.println("table is not empty");
                System.out.println(result.getInt(1));
            } else {
                System.out.println("table is empty");
                System.out.println(result.getInt(1));
            }

            //System.out.println(result.getInt(1));
        }
        return true;
    }

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
    }

    /**
     * getList - get list.
     */
    ArrayList<Vacancy> getList() {
        return this.list;
    }

}