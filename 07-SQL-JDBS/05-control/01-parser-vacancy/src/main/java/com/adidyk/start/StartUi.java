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
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 19.10.2018.
 * @version 1.0.
 */
public class StartUi implements Job {

    /**
     * @param log - link variable to object of class Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(StartUi.class);

    /**
     *
     */
    private final ConfigDataBase config = new ConfigDataBase();

    /**
     *
     */
    private ParserDate parserDate = new ParserDate();

    /**
     *
     */
    private ParserSqlRu parserSqlRu = new ParserSqlRu(this.parserDate);

    /**
     *
     */
    private String url = "http://www.sql.ru/forum/job-offers/";

    private String lastYear = "31 дек 17, 00:00";

    private String cronTime = "10 58 21 * * ?";

    /**
     * start - starts program.
     */
    private synchronized void start() throws IOException {
        this.loadSetting();
        this.configDataBase();
        this.parser(this.searchLastPageUpdate());
    }

    /**
     * loadSetting - loads params from file app.properties to class Constant.
     */
    private void loadSetting() {
        final Settings setting = new Settings();
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
        this.checkTable();
    }

    /**
     * checkDataBase - checks if there is database.
     */
    private void checkDataBase() {
        if (!this.config.searchDataBase()) {
            this.config.createDataBase();
        }
    }

    /**
     * checkTable - is.
     */
    private void checkTable() {
        if (!this.config.searchTable()) {
            this.config.createTableVacancy();
        }
    }

    /**
     *
     * @return - is.
     * @throws IOException - is.
     */
    private int searchLastPageUpdate() throws IOException {
        int page;
        if (this.parserSqlRu.checkTableIsEmpty()) {
            System.out.println(this.parserSqlRu.checkTableIsEmpty());
            page = this.parserSqlRu.searchPageByDate(this.parserDate.parse(lastYear));
            System.out.println(" [info]: " + " first start number page " + page);
        } else {
            Date date = this.parserSqlRu.getLastDate();
            page = this.parserSqlRu.searchPageByDate(date);
            System.out.println(" [info]: " + "last update number page " + page);
        }
        return page;
    }

    /**
     *
     */
    private void parser(int page) throws IOException {
        System.out.println(" [info]: run cron  ....");
        for (int index = 1; index <= page; index++) {
            this.parserSqlRu.parse(url + index);
            System.out.println(" [info] url: " + url + index);
            this.parserSqlRu.addVacancy();
        }
    }

    /**
     *
     * @throws SchedulerException - is.
     */
    private void runner() throws SchedulerException {

        Set<Trigger> triggers = new HashSet<>();
        //System.out.println("hello world !!!");
        JobDetail job = newJob(StartUi.class).build();
        Trigger triggerStartNow = newTrigger()
                .withIdentity("TriggerStartNow")
                .startNow()
                .build();
        Trigger cronTrigger = newTrigger()
                .withIdentity("CronTrigger")
                .withSchedule(cronSchedule(cronTime))
                .build();
        triggers.add(triggerStartNow);
        triggers.add(cronTrigger);
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, triggers, false);
    }

    /**
     *
     * @param context - is.
     * @throws JobExecutionException - is.
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(" [info]: START EXECUTE " + new Date() + "  " + context.getTrigger().getKey());
        try {
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * main - creates jar file and runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) throws IOException, SQLException, SchedulerException, InterruptedException {
        new StartUi().runner();
    }

}