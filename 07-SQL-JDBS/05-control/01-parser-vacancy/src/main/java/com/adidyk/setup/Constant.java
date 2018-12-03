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
     * @param NAME - name user (from app.properties).
     */
    public static String USER_NAME;

    /**
     * @param PASSWORD - password user-postgres (from app.properties).
     */
    public static String PASSWORD;

    /**
     * @param NAME_DATA_BASE - name database -> base_tracker (from app.properties).
     */
    static String NAME_DATA_BASE;

    /**
     * @param SEARCH_DATA_BASE - query sql: search database -> base_tracker (from app.properties).
     */
    static String SEARCH_DATA_BASE;

    /**
     * @param DAT_NAME - column name (datname) in table pg_postgres.
     */
    static String DAT_NAME;

    /**
     * @param CREATE_DATA_BASE - query sql: create database -> base_tracker (from app.properties).
     */
    static String CREATE_DATA_BASE;

    /**
     * @param URL_BASE_TRACKER - url database -> base_tracker (from app.properties).
     */
    public static String URL_BASE_VACANCY;

    /**
     * @param SEARCH_TABLE - query sql.
     */
    static String SEARCH_TABLE_VACANCY;

    /**
     * @param VACANCY - vacancy.
     */
    static String VACANCY;

    /**
     * @param CREATE_TABLE_VACANCY - is.
     */
    static String CREATE_TABLE_VACANCY;

    /**
     * @param TABLE_NAME - name of table where the user tables are located (from app.properties).
     */
    static String TABLE_NAME;

    /**
     *
     */
    public static String ADD_VACANCY;

    /**
     *
     */
    public static String COUNT;

    /**
     *
     */
    public static String MAX_DATE;

    /**
     *
     */
    public static String URL_SQL_RU;

    /**
     *
     */
    public static int ZERO;

    /**
     *
     */
    public static int SKIP_ROW;

    /**
     *
     */
    public static String CLASS;

    /**
     *
     */
    public static String POSTS_LIST_TOPIC;

    /**
     *
     */
    public static String LAST_YEAR;

    /**
     *
     */
    public static String CRON_TIME;

    /**
     *
     */
    public static Pattern PATTERN_TODAY;

    /**
     *
     */
    public static Pattern PATTERN_YESTERDAY;

    /**
     *
     */
    public static Pattern PATTERN_JAVA;


    /**
     * Constant - constructor (reads all parameters from file app.properties).
     * @param set - link to object of class Setting.
     */
    public Constant(Settings set) {
        this.setJDBC(set);
        this.setQuerySQL(set);
        this.setPattern(set);
        this.setCronTime(set);
        this.setOtherName(set);
    }

    /**
     * @param set - set.
     */
    private void setJDBC(Settings set) {
        URL_BASE_POSTGRES = set.getValue("jdbc.urlBasePostgres");
        URL_BASE_VACANCY = set.getValue("jdbc.urlBaseVacancy");
        USER_NAME = set.getValue("jdbc.userName");
        PASSWORD = set.getValue("jdbc.password");
    }

    /**
     * @param set - set.
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

    private void setPattern(Settings set) {
        PATTERN_JAVA = Pattern.compile(set.getValue("pattern.java"));
        PATTERN_TODAY = Pattern.compile(set.getValue("pattern.today"));
        PATTERN_YESTERDAY = Pattern.compile(set.getValue("pattern.yesterday"));
    }

    private void setCronTime(Settings set) {
        CRON_TIME = set.getValue("cron.time");
    }

    /**
     *
     * @param set - set.
     */
    private void setOtherName(Settings set) {
        NAME_DATA_BASE = set.getValue("app.nameDataBase");
        DAT_NAME = set.getValue("app.datName");
        VACANCY = set.getValue("app.vacancy");
        TABLE_NAME = set.getValue("app.tableName");
        URL_SQL_RU = set.getValue("app.urlSqlRu");
        ZERO = Integer.parseInt(set.getValue("app.zero"));
        SKIP_ROW = Integer.parseInt(set.getValue("app.skipRow"));
        CLASS = set.getValue("app.class");
        POSTS_LIST_TOPIC = set.getValue("app.postsListTopic");
        LAST_YEAR = set.getValue("app.lastYear");
    }

}