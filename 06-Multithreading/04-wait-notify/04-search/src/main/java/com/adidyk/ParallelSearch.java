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
import java.util.List;
import static java.nio.file.FileVisitResult.CONTINUE;
import static com.adidyk.Constant.*;

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
    private final List<String> files = new ArrayList<>();

    /**
     * @param finish - is finish.
     */
    private boolean isRunning = true;

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
    void initialization() throws InterruptedException {
        Thread searchFile = new Thread(new SearchFile());
        Thread searchText = new Thread(new SearchText());
        searchFile.start();
        searchText.start();
    }

    /**
     *
     * @return path.
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

    /** Class StartUi for create jar file and run program (Locker).
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 20.04.2018.
     * @version 1.0.
     */
    private class SearchFile implements Runnable {

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
            synchronized (paths) {
                isRunning = false;
                paths.notifyAll();
            }
        }
    }

    /** Class StartUi for create jar file and run program (Locker).
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 20.04.2018.
     * @version 1.0.
     */
    private class SearchText implements Runnable {

        /**
         * run - is run.
         */
        @Override
        public void run() {
            while (!paths.empty() || isRunning) {
                synchronized (paths) {
                    synchronized (files) {
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
                }
            }
            synchronized (files) {
                files.notifyAll();
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
          *
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