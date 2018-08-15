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

    public Constant(Settings set) {
        URL = set.getValue("app.url");
        NAME = set.getValue("app.name");
        PASSWORD = set.getValue("app.password");
        SEARCH_ITEM_BY_ID = set.getValue("app.searchItemById");

        IP = set.getValue("app.ip");
        PORT = Integer.parseInt(set.getValue("app.port"));
        ROOT = set.getValue("app.root");
        SEPARATOR = System.getProperty(set.getValue("app.separator"));
        FROM = set.getValue("app.from");
        HELP = set.getValue("app.help");
        SIZE = Integer.parseInt(set.getValue("app.size"));
    }
}
