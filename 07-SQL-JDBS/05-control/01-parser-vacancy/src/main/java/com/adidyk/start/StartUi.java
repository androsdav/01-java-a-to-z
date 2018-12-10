package com.adidyk.start;

import com.adidyk.setup.ConfigDataBase;
import com.adidyk.setup.Constant;
import com.adidyk.setup.Settings;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import static com.adidyk.setup.Constant.*;
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
     * @param logger - link variable to object of class Logger.
     */
    private static final Logger logger = Logger.getLogger(StartUi.class);

    /**
     * @param - link variable to object of class ParserDate.
     */
    private ParserDate parserDate = new ParserDate();

    /**
     * @param parserSqlRu - link variable to object of class ParserSqlRu.
     */
    private ParserSqlRu parserSqlRu = new ParserSqlRu(this.parserDate);

    /**
     * start - starts program.
     */
    private synchronized void start()  {
        this.loadSetting();
        this.configDataBase();
        this.parser(this.searchLastPageParse());
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
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * configDataBase - checks if there is database base_vacancy and checks if there is table vacancy.
     */
    private void configDataBase() {
        try (ConfigDataBase config = new ConfigDataBase()) {
            logger.info("config connect stat ...");
            this.checkDataBase(config);
            this.checkTable(config);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * checkDataBase - checks if there is database base_vacancy.
     * @param config - link variable to object of class ConfigDataBase.
     */
    private void checkDataBase(ConfigDataBase config) {
        if (!config.searchDataBase()) {
            logger.warn("database base_vacancy does not exist ...");
            logger.debug("creates database base_vacancy now ...");
            config.createDataBase();
            logger.info("database base_vacancy created ...");
        } else {
            logger.info("database base_vacancy already exists ...");
        }
    }

    /**
     * checkTable - checks if there is table vacancy.
     * @param config - link variable to object of class ConfigDataBase.
     */
    private void checkTable(ConfigDataBase config) {
        if (!config.searchTable()) {
            logger.warn("table vacancy does not exist ...");
            logger.debug("creates table vacancy ...");
            config.createTableVacancy();
            logger.info("table vacancy created ...");
        } else {
            logger.info("table vacancy already exists ...");
        }
    }

    /**
     * searchLastPageParse - searches last page parsing in section job-offers in website sql.ru.
     * If table vacancy is empty then method searches number of page from beginning year.
     * If table vacancy isn`t empty then method searches number of page by last date from
     * table vacancy from database base_vacancy. Also method returns page number found.
     * @return - method returns page number found.
     */
    private int searchLastPageParse() {
        logger.debug("search last page parsing ...");
        int page;
        if (this.parserSqlRu.checkTableIsEmpty()) {
            page = this.parserSqlRu.searchPageByDate(this.parserDate.parse(LAST_YEAR));
            logger.warn("table vacancy is empty or first program start, page = " + page);
        } else {
            page = this.parserSqlRu.searchPageByDate(this.parserSqlRu.getLastDate());
            logger.warn("table vacancy isn`t empty, last page parsing, page = " + page);
        }
        return page;
    }

    /**
     * parser - parses all page from section job-offers from website sql.ru beginning from first page to input page.
     * Also method adds all found vacancies to table vacancy to database base_vacancy.
     * @param page - page number.
     */
    private void parser(int page) {
        for (int index = 1; index <= page; index++) {
            this.parserSqlRu.parse(URL_SQL_RU + index);
            logger.info("page parsing, url = " + URL_SQL_RU + index);
            this.parserSqlRu.addVacancy();
            logger.info("add all found vacancies to table vacancy ...");
        }
    }

    /**
     * runner - creates job, creates two triggers and starts to works triggers: triggerStartNow, triggerCron.
     */
    private void runner() {
        this.loadSetting();
        final Set<Trigger> triggers = new HashSet<>();
        JobDetail job = newJob(StartUi.class).build();
        Trigger triggerStartNow = newTrigger().withIdentity("TriggerStartNow").startNow().build();
        Trigger triggerCron = newTrigger().withIdentity("CronTrigger").withSchedule(cronSchedule(CRON_TIME)).build();
        triggers.add(triggerStartNow);
        triggers.add(triggerCron);
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler;
        try {
            scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(job, triggers, false);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * execute - overrides method execute of class Job.
     * @param context - link variable to object of class JobExecutionContext.
     */
    @Override
    public void execute(JobExecutionContext context)  {
        logger.warn(context.getTrigger().getKey().getName());
        this.start();
    }

    /**
     * main - creates jar file and runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        logger.info(" start program parser sql.ru");
        new StartUi().runner();
    }

}