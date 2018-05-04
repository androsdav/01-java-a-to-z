package com.adidyk;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Constant contains constant.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.01.2018.
 * @version 1.0.
 */
class Constant {

    /**
     * @param ROOT - root.
     */
    static final String ROOT = "root";

    /**
     * @param TEXT - root.
     */
    static final String TEXT = "hulk";

    /**
     * @param JAVA - java.
     */
    private static final String JAVA = "java";

    /**
     * @param XML - xml.
     */
    private static final String XML = "xml";

    /**
     * @param EXTENSIONS - extensions.
     */
    static final List<String> EXTENSIONS = new ArrayList<>();

    /**
     * @param PATTERN - extensions.
     */
    static final String PATTERN = "glob:*.";

    /**
     * @param LINE - is line.
     */
    static final String LINE = " -----------------------------------------------------------------\n";

    /**
     * @param ALL_FOUND_FILE - is line.
     */
    static final String ALL_FOUND_FILE = " ------------------------ ALL FOUND FILES ------------------------";


    /**
     * Constant - constructor.
     */
    static void initialization() {
        EXTENSIONS.add(JAVA);
        EXTENSIONS.add(XML);
        System.out.println();
        System.out.println(" ------------------- INITIAL SEARCH PARAMETERS -------------------");
        System.out.println(" root - " + ROOT);
        System.out.println(" text - " + TEXT);
        System.out.print(" exts -");
        for (String item : EXTENSIONS) {
            System.out.print(" " + item);
        }
        System.out.println("\n -----------------------------------------------------------------\n");
        System.out.println(" -------- ALL FOUND FILES, AS WELL ASS LINE WITH A MATCH ---------");
    }

}