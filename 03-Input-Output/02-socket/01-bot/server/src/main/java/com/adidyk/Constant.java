package com.adidyk;

public class Constant {

    static int PORT;
    static String SERVER;
    static String HELP;
    static String QUIT;

    Constant(Settings set) {
        PORT = Integer.parseInt(set.getValue("app.port"));
        SERVER = set.getValue("app.server");
        QUIT = set.getValue("app.quit");
        HELP = set.getValue("app.help");
    }

}
