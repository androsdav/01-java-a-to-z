package com.adidyk;

//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/** Class StartUi for create jar file and run program (Locker).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 20.04.2018.
 * @version 1.0.
 */
class ParallelSearch {

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

    /**
     * init - initialisation.
     */
    void init() {
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
                Files.walkFileTree(Paths.get(root), new MyFileVisitor(extension));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}