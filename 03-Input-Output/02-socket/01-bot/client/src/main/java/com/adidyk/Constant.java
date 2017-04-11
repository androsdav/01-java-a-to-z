package com.adidyk;

public class Constant {
    static String IP;
    static int PORT;
    static String CLIENT;
    static String QUIT;

    Constant(Settings set) {
        PORT = Integer.parseInt(set.getValue("app.port"));
        IP = set.getValue("app.ip");
        CLIENT = set.getValue("app.client");
        QUIT = set.getValue("app.quit");
    }
}
