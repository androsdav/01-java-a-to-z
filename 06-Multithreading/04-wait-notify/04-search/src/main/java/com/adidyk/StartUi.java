package com.adidyk;

import java.io.IOException;
import static com.adidyk.Constant.*;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.04.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * @param parallelSearch - is link variable to object of class ParallelSearch.
     */
    private ParallelSearch parallelSearch;

    /**
     * start - runs program: initializations static parameters, starts parallel search
     * and outputs result search.
     * @throws InterruptedException - is interrupted exception.
     */
    private void start() throws InterruptedException {
        this.initialization();
        this.parallelSearch();
        this.result();
    }

    /**
     * initialization - initializations static parameters.
     */
    private void initialization() {
        Constant.initialization();
    }

    /**
     * parallelSearch - starts parallel search.
     * @throws InterruptedException - is interrupted exception.
     */
    private void parallelSearch() throws InterruptedException {
        this.parallelSearch = new ParallelSearch(ROOT, TEXT, EXTENSIONS);
        this.parallelSearch.initialization();
    }

    /**
     * result - outputs result search.
     */
    private void result() {
        for (String item : this.parallelSearch.get()) {
            System.out.println(" " + item);
        }
        System.out.println(LINE);
    }

    /**
     * main - runs program.
     * @param arg - is nothing.
     * @throws InterruptedException - is interrupted exception.
     * @throws IOException - is io exception.
     */
    public static void main(String[] arg) throws InterruptedException, IOException {
        new StartUi().start();
    }

}