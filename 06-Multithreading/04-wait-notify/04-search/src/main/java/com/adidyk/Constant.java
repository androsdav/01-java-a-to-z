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
    static final String TEXT = "heroes";

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
     * Constant - constructor.
     */
    Constant() {
        EXTENSIONS.add(JAVA);
        EXTENSIONS.add(XML);
    }

}