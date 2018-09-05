package com.adidyk.setup;

/**
 * Class Constant for create all constants.
 * All constants are created when reading from the configuration file app.properties.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public class Constant {

    /**
     * @param URL_BASE_TRACKER - url database -> base_tracker (from app.properties).
     */
    public static String URL_BASE_TRACKER;

    /**
     * @param URL_BASE_POSTGRES - url database -> postgres (from app.properties).
     */
    static String URL_BASE_POSTGRES;

    /**
     * @param NAME - name user (from app.properties).
     */
    public static String NAME;

    /**
     * @param NAME_DATA_BASE - name database -> base_tracker (from app.properties).
     */
    static String NAME_DATA_BASE;

    /**
     * @param PASSWORD - password user-postgres (from app.properties).
     */
    public static String PASSWORD;

    /**
     * @param ADD_ITEM - query sql: add item (from app.properties).
     */
    public static String ADD_ITEM;

    /**
     * @param SEARCH_ITEM_BY_ID - query sql: search item by id (from app.properties).
     */
    public static String SEARCH_ITEM_BY_ID;

    /**
     * @param UPDATE_ITEM_BY_ID - query sql: update item by id (from app.properties).
     */
    public static String UPDATE_ITEM_BY_ID;

    /**
     * @param REMOVE_ITEM_BY_ID - query sql: remove item by id (from app.properties).
     */
    public static String REMOVE_ITEM_BY_ID;

    /**
     * @param GET_ALL_ITEM - query sql: get all item (from app.properties).
     */
    public static String GET_ALL_ITEM;

    /**
     * @param ADD_COMMENT_BY_ID - query sql: add comment by id (from app.properties).
     */
    public static String ADD_COMMENT_BY_ID;

    /**
     * @param SEARCH_COMMENT_BY_ITEM_ID - query sql: search comment by item id (from app.properties).
     */
    public static String SEARCH_COMMENT_BY_ITEM_ID;

    /**
     * @param SEARCH_DATA_BASE - query sql: search database -> base_tracker (from app.properties).
     */
    static String SEARCH_DATA_BASE;

    /**
     * @param SEARCH_TABLE - query sql: search table -> item (from app.properties).
     */
    static String SEARCH_TABLE;

    /**
     * @param CREATE_DATA_BASE - query sql: create database -> base_tracker (from app.properties).
     */
    static String CREATE_DATA_BASE;

    /**
     * @param CREATE_TABLE_ITEM - query sql: create table item (from app.properties).
     */
    static String CREATE_TABLE_ITEM;

    /**
     * @param CREATE_TABLE_COMMENTS - query sql: create table comments (from app.properties).
     */
    static String CREATE_TABLE_COMMENTS;

    /**
     * @param ITEM - name main table in database -> base_tracker (from app.properties).
     */
    static String ITEM;


    /**
     * Constant - constructor (reads all parameters from file app.properties).
     * @param set - link to object of class Setting.
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
        ADD_COMMENT_BY_ID = set.getValue("app.addCommentById");
        SEARCH_COMMENT_BY_ITEM_ID = set.getValue("app.searchCommentByItemId");
        SEARCH_DATA_BASE = set.getValue("app.searchDataBase");
        SEARCH_TABLE = set.getValue("app.searchTable");
        CREATE_DATA_BASE = set.getValue("app.createDataBase");
        CREATE_TABLE_ITEM = set.getValue("app.createTableItem");
        CREATE_TABLE_COMMENTS = set.getValue("app.createTableComments");
        ITEM = set.getValue("app.item");
    }

    /**
     * menuTable - displays menu table.
     */
    public static void menuTable() {
        System.out.println("\n -----------TRACKER-MENU-------------");
    }

    /**
     * menuSeparator - displays menu separator.
     */
    public static void menuSeparator() {
        System.out.println(" ------------------------------------");
    }

    /**
     * itemTable - displays table item.
     */
    public static void itemTable() {
        System.out.println(String.format("\n %s%6s%3s %12s%8s %32s%17s %13s%3s",
                "|", "ID", "|", "ITEM", "|", "DESCRIPTION", "|", "DATA_CREATE", "|"));
        System.out.println(" |--------|--------------------|-------------------------------------------------|" +
                "----------------|");
    }

    /**
     * commentTable - displays table comment.
     */
    public static void commentTable() {
        System.out.println(String.format("\n %10s%6s%3s %12s%8s %26s%14s %13s%3s",
                "|", "ID", "|", "COMMENT", "|", "DESCRIPTION", "|", "DATA_CREATE", "|"));
        System.out.println("          |--------|--------------------|----------------------------------------|" +
                "----------------|");
    }

    /**
     * itemSeparator - displays item separator.
     */
    public static void itemSeparator() {
        System.out.println(" |--------|--------------------|-------------------------------------------------|" +
                "----------------|");
    }

    /**
     * commentSeparator - displays comment separator.
     */
    public static void commentSeparator() {
        System.out.println("          |--------|--------------------|----------------------------------------|" +
                "----------------|");
    }

}