package com.adidyk.setup;

/**
 * Class Constant for create all constants.
 * All constants are created when reading from the configuration file app.properties.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 18.10.2018.
 * @version 1.0.
 */
public class Constant {

    /**
     * @param URl - url database -> magnet.sqlite (from app.properties).
     */
    public static String URL;

    /**
     * @param QUANTITY - number of fields in table entry (from app.properties).
     */
    public static int QUANTITY;

    /**
     * @param SEARCH_TABLE - query sql: search table -> entry (from app.properties).
     */
    public static String SEARCH_TABLE_ENTRY;

    /**
     * @param CREATE_TABLE_ENTRY - query sql: create table entry (from app.properties).
     */
    public static String CREATE_TABLE_ENTRY;

    /**
     * @param ADD_FIELD - query sql: insert into field to entry (from app.properties).
     */
    public static String ADD_FIELD;

    /**
     * @param CLEAR_TABLE_ENTRY - query sql: clear table entry (from app.properties).
     */
    public static String CLEAR_TABLE_ENTRY;

    /**
     * @param GET_ALL_FIELD - query sql: selects all field from table entry (from app. properties)
     */
    public static String GET_ALL_FIELD;

    /**
     * @param FIELD - field (from app.properties)
     */
    public static String FIELD;

    /**
     * @param ENTRY - entry (from app.properties).
     */
    public static String ENTRY;

    /**
     * @param TABLE_NAME - name of table where the user tables are located (from app.properties).
     */
    public static String TABLE_NAME;

    /**
     * @param SOURCE - name file where saves all fields from database.
     */
    public static String SOURCE;

    /**
     * @param DEST - name file where saves all data from source.xml (from app.properties).
     */
    public static String DEST;

    /**
     * @param SCHEME - scheme XSLT (from app.properties).
     */
    public static String SCHEME;

    /**
     * @param HREF - attribute entry.
     */
    public static String HREF;


    //*********************************************************
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
     * Constant - constructor (reads all parameters from file app.properties).
     * @param set - link to object of class Setting.
     */
    public Constant(Settings set) {
        this.setJDBC(set);
        this.setQuerySQL(set);
        this.setOtherName(set);

        //*********************************************************
        //URL_BASE_POSTGRES = set.getValue("jdbc.urlBasePostgres");
        //USER_NAME = set.getValue("jdbc.userName");
        //PASSWORD = set.getValue("jdbc.password");
        //NAME_DATA_BASE = set.getValue("app.nameDataBase");
        //DAT_NAME = set.getValue("app.datName");

        //SEARCH_DATA_BASE = set.getValue("sql.searchDataBase");
        //CREATE_DATA_BASE = set.getValue("sql.createDataBase");
        //*********************************************************
        URL = set.getValue("app.url");
        QUANTITY = Integer.parseInt(set.getValue("app.quantity"));
        SEARCH_TABLE_ENTRY = set.getValue("app.searchTableEntry");
        CREATE_TABLE_ENTRY = set.getValue("app.createTableEntry");
        ADD_FIELD = set.getValue("app.addField");
        CLEAR_TABLE_ENTRY = set.getValue("app.clearTableEntry");
        GET_ALL_FIELD = set.getValue("app.getAllField");
        FIELD = set.getValue("app.field");
        ENTRY = set.getValue("app.entry");
        TABLE_NAME = set.getValue("app.tableName");
        SOURCE = set.getValue("app.source");
        DEST = set.getValue("app.dest");
        SCHEME = set.getValue("app.scheme");
        HREF = set.getValue("app.href");
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
    }

    /**
     *
     * @param set - set.
     */
    private void setOtherName(Settings set) {
        NAME_DATA_BASE = set.getValue("app.nameDataBase");
        DAT_NAME = set.getValue("app.datName");
    }

}