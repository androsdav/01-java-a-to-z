package com.adidyk;

import java.io.IOException;

//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
//import java.util.List;
//import java.nio.file.attribute.BasicFileAttributes;

/** Class StartUi for create jar file and run program (Locker).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.04.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - runs program, creates three thread: one thread of class MyThreadFirst and two thread
     * of class MyThreadSecond.
     * @param arg - is nothing.
     * @throws InterruptedException - is interrupted exception.
     * @throws IOException - is interrupted exception.
     */
    public static void main(String[] arg) throws InterruptedException, IOException {
        System.out.println();
        System.out.println(" Searches ...");
        System.out.println();
        String root = "root";
        String text = "heroes";
        List<String> extensions = new ArrayList<>();
        extensions.add("java");
        extensions.add("xml");
        ParallelSearch parallelSearch = new ParallelSearch(root, text, extensions);
        parallelSearch.init();
    }

}