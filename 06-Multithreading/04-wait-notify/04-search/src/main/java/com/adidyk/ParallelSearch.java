package com.adidyk;

import java.io.IOException;
import java.nio.file.Files;
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
     * ParallelSearch - constructor.
     * @param root - path to folder from which needs to search.
     * @param text - search text.
     * @param extension - extensions of files in which needs to do a search.
     */
    ParallelSearch(String root, String text, List<String> extension) {
        this.root = root;
        this.text = text;
        this.extension = extension;
    }

    public void init() {
        Thread search = new Thread(new Search());
        search.start();
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
            try {
                Files.walkFileTree(root, new MyFileVisitor());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

}