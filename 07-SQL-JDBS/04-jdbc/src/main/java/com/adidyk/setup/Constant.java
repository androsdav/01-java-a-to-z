package com.adidyk.setup;

/**
 * Class Constant for create all constants from whited all information from file app.properties.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public class Constant {

    /**
     * @param URL_BASE_TRACKER - url to database base_tracker (from app.properties).
     */
    public static String URL_BASE_TRACKER;

    /**
     * @param URL_BASE_POSTGRES - url to database postgres (from app.properties).
     */
    static String URL_BASE_POSTGRES;

    /**
     * @param NAME - user name (from app.properties).
     */
    public static String NAME;

    /**
     * @param NAME_DATA_BASE - is name database (from app.properties).
     */
    static String NAME_DATA_BASE;

    /**
     * @param PASSWORD - password user (from app.properties).
     */
    public static String PASSWORD;

    /**
     * @param SEARCH_ITEM_BY_ID - sql format: search item by id (from app.properties).
     */
    public static String SEARCH_ITEM_BY_ID;

    /**
     * @param UPDATE_ITEM_BY_ID - sql format: update item by id (from app.properties).
     */
    public static String UPDATE_ITEM_BY_ID;

    /**
     * @param ADD_ITEM - sql constant: add item (from app.properties).
     */
    public static String ADD_ITEM;

    /**
     *
     */
    public static String REMOVE_ITEM_BY_ID;

    /**
     *
     */
    public static String GET_ALL_ITEM;

    /**
     *
     */
    static String SEARCH_DATA_BASE;

    /**
     *
     */
    static String SEARCH_TABLE;

    /**
     *
     */
    static String CREATE_DATA_BASE;

    /**
     *
     */
    static String CREATE_TABLE_ITEM;

    /**
     *
     */
    static String CREATE_TABLE_COMMENTS;

    /**
     * Constant - constructor (create all constants).
     * @param set - link to object of class Setting (reads all information from file app.properties).
     */
    public Constant(Settings set) {
        URL_BASE_TRACKER = set.getValue("app.urlBaseTracker");
        URL_BASE_POSTGRES = set.getValue("app.urlBasePostgres");
        NAME = set.getValue("app.name");
        NAME_DATA_BASE = set.getValue("app.nameDataBase");
        PASSWORD = set.getValue("app.password");
        ADD_ITEM = set.getValue("app.addItem");
        SEARCH_ITEM_BY_ID = set.getValue("app.searchItemById");
        UPDATE_ITEM_BY_ID = set.getValue("app.updateItemById");
        REMOVE_ITEM_BY_ID = set.getValue("app.removeItemById");
        GET_ALL_ITEM = set.getValue("app.getAllItem");
        SEARCH_DATA_BASE = set.getValue("app.searchDataBase");
        SEARCH_TABLE = set.getValue("app.searchTable");
        CREATE_DATA_BASE = set.getValue("app.createDataBase");
        CREATE_TABLE_ITEM = set.getValue("app.createTableItem");
        CREATE_TABLE_COMMENTS = set.getValue("app.createTableComments");
    }

    /**
     * menuTable - is menu table.
     */
    public static void menuTable() {
        System.out.println("\n -----------TRACKER-MENU-------------");
    }

    /**
     * menuSeparator - is menu separator.
     */
    public static void menuSeparator() {
        System.out.println(" ------------------------------------");
    }

    /**
     * itemTable - is table item.
     */
    public static void itemTable() {
        System.out.println(String.format("\n %s%6s%3s %12s%8s %32s%17s %13s%3s",
                "|", "ID", "|", "ITEM", "|", "DESCRIPTION", "|", "DATA_CREATE", "|"));
        System.out.println(" |--------|--------------------|-------------------------------------------------|----------------|");
    }

    /**
     * commentTable - is comment table.
     */
    public static void commentTable() {
        System.out.println(String.format("\n %10s%6s%3s %12s%8s %26s%14s %13s%3s",
                "|", "ID", "|", "COMMENT", "|", "DESCRIPTION", "|", "DATA_CREATE", "|"));
        System.out.println("          |--------|--------------------|----------------------------------------|----------------|");
    }

    /**
     * itemSeparator - is item separator.
     */
    public static void itemSeparator() {
        System.out.println(" |--------|--------------------|-------------------------------------------------|----------------|");
    }

    /**
     * commentSeparator - is comment separator.
     */
    public static void commentSeparator() {
        System.out.println("          |--------|--------------------|----------------------------------------|----------------|");
    }

}