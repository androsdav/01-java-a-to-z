package com.adidyk;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.FileVisitResult.CONTINUE;
import static com.adidyk.Constant.*;

/**
 * Class ParallelSearch runs two threads, where:
 * first thread - searches for all files with specified extensions and adds them to queue.
 * second thread - second thread takes found files from the queue and looks for specified
 * text in them, if the text is found, the path to the file is added to the list.
 * Also Class ParallelSearch returns result search.
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
     * @param paths - link variable to object of class SimpleQueue where are
     * located found files by specified extensions.
     */
    private final SimpleQueue<Path> paths = new SimpleQueue<>();

    /**
     * @param files - link variable to object of class ArrayList where are
     * located found files by specified text.
     */
    private final List<String> files = new ArrayList<>();

    /**
     * @param isRunning - if searches is finish isRunning = false.
     */
    private volatile boolean isRunning = true;

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
     * initialisation - start two threads: searchFile and searchText.
     * @throws InterruptedException - is interrupted exception.
     */
    void initialization() throws InterruptedException {
        Thread searchFile = new Thread(new SearchFile());
        Thread searchText = new Thread(new SearchText());
        searchFile.start();
        searchText.start();
    }

    /**
     * get - returns result search.
     * @return - returns result search.
     */
    List<String> get() {
        while (isRunning) {
            synchronized (files) {
                try {
                    files.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
               }
            }
        }
        System.out.println(LINE);
        System.out.println(ALL_FOUND_FILE);
        return this.files;
    }

    /**
     * Class SearchFile run thread for searches for all files with specified
     * extensions and adds them to queue.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 20.04.2018.
     * @version 1.0.
     */
    private class SearchFile implements Runnable {

        /**
         * run - searches for all files with specified extensions and adds them to queue.
         */
        @Override
        public void run() {
            try {
                Files.walkFileTree(Paths.get(root), new MyFileVisitor());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            synchronized (paths) {
                isRunning = false;
                paths.notifyAll();
            }
        }

    }

    /**
     * Class SearchText run thread, takes found files from the queue and looks for
     * specified text in them, if the text is found, the path to the file is added to the list.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 20.04.2018.
     * @version 1.0.
     */
    private class SearchText implements Runnable {

        /**
         * run - takes found files from the queue and looks for specified text in them,
         * if the text is found, the path to the file is added to the list..
         */
        @Override
        public void run() {
            synchronized (paths) {
                synchronized (files) {
                    while (!paths.empty() || isRunning) {
                        while (paths.empty() && isRunning) {
                            try {
                                paths.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (!paths.empty()) {
                            String file = String.valueOf(paths.pop());
                            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                                System.out.println(" file: " + file);
                                String string;
                                boolean searchTrue = false;
                                while ((string = br.readLine()) != null) {
                                    if (string.contains(text)) {
                                        searchTrue = true;
                                        System.out.println("  - line: " + string);
                                    }
                                }
                                if (searchTrue) {
                                    files.add(file);
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    files.notifyAll();
                }
            }
        }

    }

    /**
     * Class MyFileVisitor StartUi for create jar file and run program (Locker).
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 11.04.2018.
     * @version 1.0.
     */
    private class MyFileVisitor extends SimpleFileVisitor<Path> {

         /**
         * visitFile - walks through the tree and also searches for files with the specified extensions.
         * @param file - link variable to object of class ArrayList where are located found files by specified text.
         * @param attr - basic file attributes.
         * @return - returns CONTINUE.
         */
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
            for (String extension : extensions) {
                PathMatcher matcher = FileSystems.getDefault().getPathMatcher(PATTERN + extension);
                if (matcher.matches(file.getFileName())) {
                    synchronized (paths) {
                        paths.push(file);
                        paths.notifyAll();
                    }
                }
            }
            return CONTINUE;
        }

    }

}