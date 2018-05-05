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
     * @param ROOT - path to folder from which needs to search.
     */
    static final String ROOT = "root";

    /**
     * @param TEXT - search text.
     */
    static final String TEXT = "marvel";

    /**
     * @param JAVA - extensions of file.
     */
    private static final String JAVA = "java";

    /**
     * @param XML - extensions of file.
     */
    private static final String XML = "xml";

    /**
     * @param EXTENSIONS - extensions of files in which needs to do a search.
     */
    static final List<String> EXTENSIONS = new ArrayList<>();

    /**
     * @param PATTERN - glob pattern.
     */
    static final String PATTERN = "glob:*.";

    /**
     * @param LINE - is decor.
     */
    static final String LINE = " -----------------------------------------------------------------\n";

    /**
     * @param ALL_FOUND_FILE - is decor.
     */
    static final String ALL_FOUND_FILE = " ------------------------ ALL FOUND FILES ------------------------";

    /**
     * initialization - adds extensions to list and outputs static decor information.
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