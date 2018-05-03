package com.adidyk;

import java.io.IOException;
import java.util.ArrayList;

import static com.adidyk.Constant.*;

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
        //String root = "root";
        //String text = "heroes";
        //List<String> extensions = new ArrayList<>();
        //extensions.add("java");
        //extensions.add("xml");
        ArrayList<String> extensions = new ArrayList<>();
        extensions.add("java");
        extensions.add("xml");
        ParallelSearch parallelSearch = new ParallelSearch(ROOT, TEXT, extensions);
        parallelSearch.init();
        /*
        for (String item : EXTENSIONS) {
            System.out.println(item);
        }
        */
    }

}