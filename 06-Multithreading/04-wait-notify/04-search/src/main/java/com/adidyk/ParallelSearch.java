package com.adidyk;

import java.util.List;

/** Class StartUi for create jar file and run program (Locker).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 20.04.2018.
 * @version 1.0.
 */
public class ParallelSearch {

    /**
     * @param root - path to folder from which needs to search.
     */
    private String root;

    /**
     * @param text - search text.
     */
    private String text;

    /**
     * @param extension - extensions of files in which needs to do a search.
     */
    private List<String> extension;

    /**
     * ParallelSearch -
     * @param root - path to folder from which needs to search.
     * @param text - search text.
     * @param extension - extensions of files in which needs to do a search.
     */
    ParallelSearch(String root, String text, List<String> extension) {
        this.root = root;
        this.text = text;
        this.extension = extension;
    }

    /** Class StartUi for create jar file and run program (Locker).
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 20.04.2018.
     * @version 1.0.
     */
    private class Search implements Runnable {

        /**
         * run - search all files when has task extensions.
         */
        @Override
        public void run() {

        }
    }

}