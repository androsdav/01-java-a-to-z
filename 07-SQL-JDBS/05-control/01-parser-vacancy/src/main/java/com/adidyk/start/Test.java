package com.adidyk.start;

import com.adidyk.models.Vacancy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.adidyk.setup.Constant.*;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 23.10.2018.
 * @version 1.0.
 */
public class Test {

    /**
     * @param list - list vacancy.
     */
    private ArrayList<Vacancy> list = new ArrayList<>();

    /**
     * @param pattern - pattern.
     */
    private final Pattern pattern = Pattern.compile("(?i)\\bjava\\b");

    /**
     * parserJsoup - parser jsoup.
     */
    void parserJsoup(String url) throws IOException {
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        Elements posts = document.getElementsByAttributeValue("class", "postslisttopic");
        for (Element post : posts) {
            if (this.pattern.matcher(post.child(0).text()).find()) {
                String theme  = post.child(0).text();
                String author = post.nextElementSibling().text();
                int answers = Integer.parseInt(post.nextElementSibling().nextElementSibling().text());
                int viewers = Integer.parseInt(post.nextElementSibling().nextElementSibling().nextElementSibling().text());
                String date = post.nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text();
                Vacancy vacancy = new Vacancy(theme, author, answers, viewers, date);
                this.list.add(vacancy);
            }
        }
    }

    /**
     *
     */
    void addVacancy() throws SQLException {

        java.sql.Connection connect = null;

        try {
            connect = DriverManager.getConnection(URL_BASE_VACANCY, USER_NAME, PASSWORD);
            //connect.setAutoCommit(false);  ON CONFLICT DO NOTHING

            for (Vacancy vacancy : this.list) {
                PreparedStatement statement = connect.prepareStatement(ADD_VACANCY);
                statement.setString(1, vacancy.getTheme());
                statement.setString(2, vacancy.getAuthor());
                statement.setInt(3, vacancy.getAnswers());
                statement.setInt(4, vacancy.getViewers());
                statement.setString(5, vacancy.getDate());
                statement.executeUpdate();
                statement.close();
            }
            //connect.commit();
            //statement.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println("duplicate");
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }




        /*
        try (Connection connect = DriverManager.getConnection(URL_BASE_VACANCY, USER_NAME, PASSWORD);
             PreparedStatement statement = connect.prepareStatement(ADD_VACANCY)) {
            //connect.setAutoCommit(false);
            for (Vacancy vacancy : this.list) {
                statement.setString(1, vacancy.getTheme());
                statement.setString(2, vacancy.getAuthor());
                statement.setInt(3, vacancy.getAnswers());
                statement.setInt(4, vacancy.getViewers());
                statement.setString(5, vacancy.getDate());
                statement.executeUpdate();
            }
            //connect.commit();
        } catch (SQLException ex) {
            //ex.printStackTrace();
//            System.out.println("dublicate");
        }
        */
    }

    /**
     * getList - get list.
     */
    ArrayList<Vacancy> getList() {
        return this.list;
    }

}