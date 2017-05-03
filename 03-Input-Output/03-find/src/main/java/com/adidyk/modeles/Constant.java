package com.adidyk.modeles;

public class Constant {

    public static String HELP;
    public static String QUIT;
    public static String SEPARATOR;
    public static String LINE_SEPARATOR;
    public static String LOG;

    public Constant() {
        HELP = "help";
        QUIT = "quit";
        SEPARATOR = System.getProperty("file.separator");
        LINE_SEPARATOR = System.lineSeparator();
        LOG = "log.txt";
    }

}
