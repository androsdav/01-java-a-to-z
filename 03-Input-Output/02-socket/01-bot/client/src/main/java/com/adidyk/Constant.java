package com.adidyk;

public class Constant {
    static String IP;
    static int PORT;
    static String ROOT;
    static String SEPARATOR;
    static String FROM;
    static String HELP;
    static int SIZE;

    Constant(Settings set) {
        IP = set.getValue("app.ip");
        PORT = Integer.parseInt(set.getValue("app.port"));
        //ROOT = set.getValue("app.root");
        //SEPARATOR = System.getProperty(set.getValue("app.separator"));
        //FROM = set.getValue("app.from");
        //HELP = set.getValue("app.help");
        //SIZE = Integer.parseInt(set.getValue("app.size"));
    }
}
