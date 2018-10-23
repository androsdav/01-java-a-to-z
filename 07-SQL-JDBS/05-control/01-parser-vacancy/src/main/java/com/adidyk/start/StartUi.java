package com.adidyk.start;

import com.adidyk.models.Vacancy;
import com.adidyk.setup.ConfigDataBase;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.adidyk.setup.Constant;
import com.adidyk.setup.Settings;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 19.10.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * @param log - link variable to object of class Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(StartUi.class);

    /**
     * start - starts program.
     */
    private void start() {
        this.loadSetting();
        this.configDataBase();
    }

    /**
     * loadSetting - loads params from file app.properties to class Constant.
     */
    private void loadSetting() {
        Settings setting = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream is = loader.getResourceAsStream("app.properties")) {
            setting.load(is);
            new Constant(setting);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * configDataBase - checks if there is database and checks if there is table item.
     */
    private void configDataBase() {
        this.checkDataBase();
    }

    /**
     * checkDataBase - checks if there is database.
     */
    private void checkDataBase() {
        ConfigDataBase config = new ConfigDataBase();
        if (!config.searchDataBase()) {
            System.out.println("false");
            config.createDataBase();
        } else {
            System.out.println("true");
        }
    }

    /**
     * main - creates jar file and runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) throws IOException {
        System.out.println("hello world !!!");
        new StartUi().start();

        /*
        String url  = "http://www.sql.ru/forum/job-offers/2";
        Test test = new Test();
        test.parserJsoup(url);
        for (Vacancy item : test.getList()) {
            System.out.println(item);

        }
        */
    }
}

        /*
        String string = "zczczxc java dasdkjavadsd JaVaScript aaaaaa aajava JAVAa dsJAVAJAVA JAVA JavaScript jAVa";
        Pattern pattern = Pattern.compile("(?i)(\\bjava\\b)");
        Matcher matcher = pattern.matcher(string);
        /*
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        if (matcher.find()) {
            System.out.println("Is good");
        } else {
            System.out.println("Is bad");
        }
    }

        /*
        Pattern pattern = Pattern.compile("(?i)\\bjava\\b");
        Connection connection = Jsoup.connect("http://www.sql.ru/forum/job-offers");
        Document document = connection.get();
        Elements posts = document.getElementsByAttributeValue("class", "postslisttopic");
        for (Element post : posts) {
            if (pattern.matcher(post.child(0).text()).find()) {
                System.out.println(post.child(0).text());
                System.out.println(post.nextElementSibling().text());
                System.out.println(post.nextElementSibling().nextElementSibling().text());
                System.out.println(post.nextElementSibling().nextElementSibling().nextElementSibling().text());
                System.out.println(post.nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text());
                System.out.println();
            }
        }

    }

        /*
        List<Element> elements = document.select("tr");
        for (Element element : elements) {
            //System.out.println(element.child(0).text());
            System.out.println(element.select("td.postslisttopic").select("a[href]").text());
            //System.out.println();
        }
    }

        /*
        Elements forumTable = document.getElementsByAttributeValue("class", "forumTable");
        Elements topic = document.getElementsByAttributeValue("class", "postslisttopic");
        Elements author = document.getElementsByAttributeValue("class", "altCol");

        System.out.println(topic.size());
        for (Element element : topic) {
            System.out.println(element.child(0).text());
            System.out.println(element.child(1).text());
            System.out.println(element.child(2).text());
            System.out.println();
        }

        //for (int index = 0; index < topic.size(); index++) {
            //System.out.println(topic.text());
            //System.out.println();
            //System.out.println(author.text());
            //System.out.println(author.next().text());
        //}

            //System.out.println(topic.child(0).text());
            //Element author = doc


            //System.out.println(element.before("td"));
            //System.out.println();
        }
        /*
        elements.forEach(element -> {
            System.out.println(element.attributes());
        });
        */

        //System.out.println(document.title());
        //System.out.println(document.head());
        //new StartUi().start();