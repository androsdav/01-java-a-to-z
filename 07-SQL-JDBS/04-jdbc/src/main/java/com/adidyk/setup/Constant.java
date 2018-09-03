package com.adidyk.setup;

public class Constant {

    /**
     * @param URL_BASE_TRACKER - url to database base_tracker.
     */
    public static String URL_BASE_TRACKER;

    /**
     * @param URL_BASE_POSTGRES - url to database postgres.
     */
    static String URL_BASE_POSTGRES;

    /**
     * @param NAME - user name.
     */
    public static String NAME;

    /**
     * @param NAME_DATA_BASE - is name database.
     */
    static String NAME_DATA_BASE;

    /**
     *
     */
    public static String PASSWORD;

    /**
     *
     */
    public static String SEARCH_ITEM_BY_ID;

    /**
     *
     */
    public static String UPDATE_ITEM_BY_ID;

    /**
     *
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
    public static String SEARCH_DATA_BASE;

    /**
     *
     */
    public static String SEARCH_TABLE;

    /**
     *
     */
    public static String CREATE_DATA_BASE;

    /**
     *
     */
    public static String CREATE_TABLE_ITEM;

    /**
     *
     */
    public static String CREATE_TABLE_COMMENTS;

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