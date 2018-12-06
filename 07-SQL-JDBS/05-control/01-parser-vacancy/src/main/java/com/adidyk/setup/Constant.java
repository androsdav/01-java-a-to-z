package com.adidyk.setup;

import java.util.regex.Pattern;

/**
 * Class Constant for create all constants.
 * All constants are created when reading from the configuration file app.properties.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 18.10.2018.
 * @version 1.0.
 */
public class Constant {

    /**
     * @param URL_BASE_POSTGRES - url database -> postgres (from app.properties).
     */
    static String URL_BASE_POSTGRES;

    /**
     * @param URL_BASE_VACANCY - url database -> base_vacancy (from app.properties).
     */
    public static String URL_BASE_VACANCY;

    /**
     * @param USER_NAME - name user -> postgres (from app.properties).
     */
    public static String USER_NAME;

    /**
     * @param PASSWORD - password user-postgres -> admin (from app.properties).
     */
    public static String PASSWORD;

    /**
     * @param SEARCH_DATA_BASE - query sql: search database base_vacancy (from app.properties).
     */
    static String SEARCH_DATA_BASE;

    /**
     * @param CREATE_DATA_BASE - query sql: create database base_vacancy (from app.properties).
     */
    static String CREATE_DATA_BASE;

    /**
     * @param SEARCH_TABLE_VACANCY - query sql: search table vacancy (from app.properties).
     */
    static String SEARCH_TABLE_VACANCY;

    /**
     * @param CREATE_TABLE_VACANCY - query sql: create table vacancy (from app.properties).
     */
    static String CREATE_TABLE_VACANCY;

    /**
     * @param ADD_VACANCY - query sql: add vacancy to table vacancy to base_vacancy (from app.properties).
     */
    public static String ADD_VACANCY;

    /**
     * @param COUNT - query sql: counts number of row in table vacancy (from app.properties).
     */
    public static String COUNT;

    /**
     * @param MAX_DATE - query sql: searches vacancy with last date in table vacancy (from app.properties).
     */
    public static String MAX_DATE;

    /**
     * @param PATTERN_JAVA - pattern for searches only word java (fromm app.properties).
     */
    public static Pattern PATTERN_JAVA;

    /**
     * @param PATTERN_TODAY - pattern for searches only word today in russian (from app.properties).
     */
    public static Pattern PATTERN_TODAY;

    /**
     * @param PATTERN_YESTERDAY - pattern for searches only word yesterday in russian (from app.properties).
     */
    public static Pattern PATTERN_YESTERDAY;

    /**
     * @param CRON_TIME - Cron-Expressions are used to configure instances of CronTrigger (from app.properties).
     */
    public static String CRON_TIME;

    /**
     * @param NAME_DATA_BASE - name database -> base_vacancy (from app.properties).
     */
    static String NAME_DATA_BASE;

    /**
     * @param DAT_NAME - column name (datname) in table pg_postgres (from app.properties).
     */
    static String DAT_NAME;

    /**
     * @param VACANCY - vacancy (from app.properties).
     */
    static String VACANCY;

    /**
     * @param TABLE_NAME - name of table where the user tables are located (from app.properties).
     */
    static String TABLE_NAME;


    /**
     * @param URL_SQL_RU - website sql.ru section job-offers http://www.sql.ru/forum/job-offers/.
     */
    public static String URL_SQL_RU;

    /**
     * @param ZERO - just zero.
     */
    public static int ZERO;

    /**
     * @param SKIP_ROW - number of skip rows at beginning table vacancy when searching for the
     * date on the page sql.ru section job-offers.
     */
    public static int SKIP_ROW;

    /**
     * @param CLASS - just class.
     */
    public static String CLASS;

    /**
     * @param POST_LIST_TOPIC - cell class name where located theme of vacancy in html page.
     */
    public static String POSTS_LIST_TOPIC;

    /**
     * @param LAST_YEAR - date format last year.
     */
    public static String LAST_YEAR;

    /**
     * Constant - constructor (reads all parameters from file app.properties).
     * @param set - link to object of class Setting.
     */
    public Constant(Settings set) {
        this.setDataBase(set);
        this.setQuerySQL(set);
        this.setPattern(set);
        this.setCronTime(set);
        this.setOtherParam(set);
    }

    /**
     * setDataBase - sets params for connect database.
     * @param set - link variable to object of class Setting.
     */
    private void setDataBase(Settings set) {
        URL_BASE_POSTGRES = set.getValue("jdbc.urlBasePostgres");
        URL_BASE_VACANCY = set.getValue("jdbc.urlBaseVacancy");
        USER_NAME = set.getValue("jdbc.userName");
        PASSWORD = set.getValue("jdbc.password");
    }

    /**
     * setQuerySQL - sets query sql.
     * @param set - link variable to object of class Setting.
     */
    private void setQuerySQL(Settings set) {
        SEARCH_DATA_BASE = set.getValue("sql.searchDataBase");
        CREATE_DATA_BASE = set.getValue("sql.createDataBase");
        SEARCH_TABLE_VACANCY = set.getValue("sql.searchTableVacancy");
        CREATE_TABLE_VACANCY = set.getValue("sql.createTableVacancy");
        ADD_VACANCY = set.getValue("sql.addVacancy");
        COUNT = set.getValue("sql.count");
        MAX_DATE = set.getValue("sql.maxDate");
    }

    /**
     * setPattern - sets all patterns.
     * @param set - link variable to object of class Setting.
     */
    private void setPattern(Settings set) {
        PATTERN_JAVA = Pattern.compile(set.getValue("pattern.java"));
        PATTERN_TODAY = Pattern.compile(set.getValue("pattern.today"));
        PATTERN_YESTERDAY = Pattern.compile(set.getValue("pattern.yesterday"));
    }

    /**
     * setCronTime - sets Cron-Expressions for to configure instances of CronTrigger.
     * @param set - link variable to object of class Setting.
     */
    private void setCronTime(Settings set) {
        CRON_TIME = set.getValue("cron.time");
    }

    /**
     * setOtherParam - sets other params.
     * @param set - link variable to object of class Setting.
     */
    private void setOtherParam(Settings set) {
        URL_SQL_RU = set.getValue("app.urlSqlRu");
        NAME_DATA_BASE = set.getValue("app.nameDataBase");
        DAT_NAME = set.getValue("app.datName");
        VACANCY = set.getValue("app.vacancy");
        TABLE_NAME = set.getValue("app.tableName");
        ZERO = Integer.parseInt(set.getValue("app.zero"));
        SKIP_ROW = Integer.parseInt(set.getValue("app.skipRow"));
        CLASS = set.getValue("app.class");
        POSTS_LIST_TOPIC = set.getValue("app.postsListTopic");
        LAST_YEAR = set.getValue("app.lastYear");
    }

}