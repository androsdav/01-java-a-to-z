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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
    private void start() throws IOException, SQLException {
        this.loadSetting();
        this.configDataBase();
        this.parser();
        this.dateParser();
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
        this.checkTables();
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
     * checkTable - is.
     */
    private void checkTables() {
        ConfigDataBase config = new ConfigDataBase();
        if (!config.searchTable()) {
            System.out.println("false");
            config.createTableVacancy();
        } else {
            System.out.println("true");
        }
    }

    /**
     *
     */
    private void parser() throws IOException, SQLException {
        Test test = new Test();
        test.parserJsoup("http://www.sql.ru/forum/job-offers/1");
        test.addVacancy();
        /*
        for (Vacancy vacancy : test.getList()) {
            System.out.println(vacancy);
        }
        */
    }

    /**
     *
     */
    private void dateParser() {
        ParserDate parserDate = new ParserDate();
        Date date = parserDate.parseDate("10 ноя 09, 23:12");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(sdf.format(date));
        /*
        //***************** parser string to date
        System.out.println();
        String string = "24 янв 18, 13:28";
        Locale locale = new Locale("ru", "RU");
        //DateFormat format = new SimpleDateFormat("d MMM yy, HH:mm", locale);
        DateFormat format = new SimpleDateFormat("dd MMM yy, HH:mm", locale);
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        //***************** may format date
        System.out.println();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(sdf.format(date));
        //***************** search substring in string use RU
        String string1 = "24 сегодня 18, 13:28";
        Pattern today = Pattern.compile("(?i)\\bсегодня\\b");
        Matcher matcher = today.matcher(string1);
        //Pattern yesterday = Pattern.compile("вчера");
        /*
        if (today.matcher(string).find()) {
            System.out.println("вывод русс");
        }
        */
        /*
        System.out.println(matcher.find());
        System.out.println(matcher.group());
        */





    }
/*

    public class GetLocalInformation {

        private static String getSymbols(Locale locale){
            DateFormatSymbols symbols = new DateFormatSymbols(locale);
            return Arrays.toString(symbols.getMonths());
        }

        public static void main(String[] args) {
            System.out.println(getSymbols( new Locale("RU","ru")));
            System.out.println(getSymbols( new Locale("EN","en")));
            System.out.println(getSymbols( Locale.GERMANY ));
            System.out.println(getSymbols( Locale.CHINA ));
        } http://www.sbp-program.ru/java/sbp-datetime.htm
        http://www.seostella.com/ru/article/2012/02/05/formatirovanie-daty-v-java.html
        */

    /**
     * main - creates jar file and runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) throws IOException, SQLException {
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