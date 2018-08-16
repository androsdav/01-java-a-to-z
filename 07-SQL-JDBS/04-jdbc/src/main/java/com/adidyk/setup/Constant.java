package com.adidyk.setup;

public class Constant {
    static String IP;
    static int PORT;
    static String ROOT;
    static String SEPARATOR;
    static String FROM;
    static String HELP;
    static int SIZE;

    public static String URL;
    public static String NAME;
    public static String PASSWORD;
    public static String SEARCH_ITEM_BY_ID;
    public static String UPDATE_ITEM_BY_ID;
    public static String ADD_ITEM;
    public static String REMOVE_ITEM_BY_ID;
    public static String GET_ALL_ITEM;


    public Constant(Settings set) {
        URL = set.getValue("app.url");
        NAME = set.getValue("app.name");
        PASSWORD = set.getValue("app.password");
        ADD_ITEM = set.getValue("app.addItem");
        SEARCH_ITEM_BY_ID = set.getValue("app.searchItemById");
        UPDATE_ITEM_BY_ID = set.getValue("app.updateItemById");
        REMOVE_ITEM_BY_ID = set.getValue("app.removeItemById");
        GET_ALL_ITEM = set.getValue("app.getAllItem");


        IP = set.getValue("app.ip");
        PORT = Integer.parseInt(set.getValue("app.port"));
        ROOT = set.getValue("app.root");
        SEPARATOR = System.getProperty(set.getValue("app.separator"));
        FROM = set.getValue("app.from");
        HELP = set.getValue("app.help");
        SIZE = Integer.parseInt(set.getValue("app.size"));
    }
}
