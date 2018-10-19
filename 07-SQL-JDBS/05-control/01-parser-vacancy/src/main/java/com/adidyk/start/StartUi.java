package com.adidyk.start;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.adidyk.setup.Constant;
import com.adidyk.setup.Settings;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

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
     * configDataBase - checks if there is table entry and generates number of fields in table entry.
     */
    private void configDataBase() {
    }

    /**
     * main - creates jar file and runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) throws IOException {
        System.out.println("hello world !!!");
        Connection connection = Jsoup.connect("http://www.sql.ru/forum/job-offers");
        Document document = connection.get();
        Elements elements = document.getElementsByAttributeValue("class", "postslisttopic");
        for (Element theme : elements) {
            System.out.println(theme.child(0).text());
            Element author = doc


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
    }

}