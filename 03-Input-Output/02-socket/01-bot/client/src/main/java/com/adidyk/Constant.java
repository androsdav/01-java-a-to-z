package com.adidyk;

public class Constant {
    static String IP;
    static int PORT;
    static String CLIENT;
    static String QUIT;
    static String HELP;
    static String NOT;

    Constant(Settings set) {
        PORT = Integer.parseInt(set.getValue("app.port"));
        IP = set.getValue("app.ip");
        CLIENT = set.getValue("app.client");
        QUIT = set.getValue("app.quit");
        HELP = set.getValue("app.help");
        NOT = set.getValue("app.not");
    }
}
