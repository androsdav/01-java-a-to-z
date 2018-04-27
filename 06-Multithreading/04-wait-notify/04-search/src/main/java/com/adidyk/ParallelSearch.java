package com.adidyk;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileVisitResult;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;
import static java.nio.file.FileVisitResult.CONTINUE;

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
    private List<String> extensions;

    /**
     * @param paths - is paths.
     */
    private final SimpleQueue<Path> paths = new SimpleQueue<>();

    /**
     * @param files - result.
     */
    private List<Path> files = new ArrayList<>();

    /**
     * @param finish - is finish.
     */
    private boolean finish = false;

    /**
     * ParallelSearch - constructor.
     * @param root - path to folder from which needs to search.
     * @param text - search text.
     * @param extensions - extensions of files in which needs to do a search.
     */
    ParallelSearch(String root, String text, List<String> extensions) {
        this.root = root;
        this.text = text;
        this.extensions = extensions;
    }

    /**
     * init - initialisation.
     * @throws InterruptedException - is exception.
     */
    void init() throws InterruptedException {
        Thread search = new Thread(new Search());
        Thread read = new Thread(new Read());
        search.start();
        //Thread.sleep(4000);
        read.start();
    }

    /**
     *
     * @return path.
     */
    SimpleQueue<Path> getPaths() {
        return this.paths;
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
                Files.walkFileTree(Paths.get(root), new MyFileVisitor());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            finish = true;
        }
    }

    /** Class StartUi for create jar file and run program (Locker).
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 20.04.2018.
     * @version 1.0.
     */
    private class Read implements Runnable {

        /**
         * run - is run.
         */
        @Override
        public void run() {
            while (true) {
                synchronized (paths) {
                    while (paths.empty()) {
                        try {
                            paths.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String file = String.valueOf(paths.pop());
                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            System.out.println("path: " + file);
                            String string;
                            while ((string = br.readLine()) != null) {
                                if (string.contains(text)) {
                                    System.out.println("    string:" + string);
                                }
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /** Class StartUi for create jar file and run program (Locker).
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 11.04.2018.
     * @version 1.0.
     */
    private class MyFileVisitor extends SimpleFileVisitor<Path> {

         /**
         * visitFile - is.
         * @param file - is.
         * @param attr - is.
         * @return - is.
         */
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
            for (String extension : extensions) {
                PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*." + extension);
                if (matcher.matches(file.getFileName())) {
                    synchronized (paths) {
                        paths.push(file);
                        paths.notifyAll();
                    }
//                    System.out.println("Search result: " + file);
                }
            }
            return CONTINUE;
        }
    }

}