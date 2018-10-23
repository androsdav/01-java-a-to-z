package com.adidyk.start;

import com.adidyk.models.Vacancy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
     * getList - get list.
     */
    ArrayList<Vacancy> getList() {
        return this.list;
    }


}
