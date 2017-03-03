package com.adidyk;

public class Constant {

    private static Settings set;

    Constant(Settings setting) {
        set = setting;

    }

    static final int PORT = Integer.parseInt(set.getValue("app.port"));
    static final String ROOT =  set.getValue(set.getValue("app.root"));
    static final String SEPARATOR = System.getProperty(set.getValue("app.separator"));
    static final String FROM = set.getValue(set.getValue("app.from"));
    static final String HELP = set.getValue(set.getValue("app.help"));
    static final int SIZE = Integer.parseInt(set.getValue(set.getValue("app.size")));
}
