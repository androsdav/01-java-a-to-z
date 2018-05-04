package com.adidyk;

import java.io.IOException;
import static com.adidyk.Constant.*;

/** Class StartUi for create jar file and run program (Locker).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.04.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * @param parallelSearch - is.
     */
    private ParallelSearch parallelSearch;

    /**
     *
     * @throws InterruptedException - is.
     */
    private void start() throws InterruptedException {
        this.initialization();
        this.search();
        this.result();
    }

    /**
     *
     */
    private void initialization() {
        Constant.initialization();
    }

    /**
     *
     * @throws InterruptedException - is.
     */
    private void search() throws InterruptedException {
        this.parallelSearch = new ParallelSearch(ROOT, TEXT, EXTENSIONS);
        this.parallelSearch.initialization();
    }

    /**
     *
     */
    private void result() {
        for (String item : this.parallelSearch.get()) {
            System.out.println(" " + item);
        }
        System.out.println(LINE);
    }

    /**
     * main - runs program, creates three thread: one thread of class MyThreadFirst and two thread
     * of class MyThreadSecond.
     * @param arg - is nothing.
     * @throws InterruptedException - is interrupted exception.
     * @throws IOException - is interrupted exception.
     */
    public static void main(String[] arg) throws InterruptedException, IOException {
        new StartUi().start();
    }
}