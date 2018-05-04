package com.adidyk;

/** Class StartUi for create jar file and run program (Thread-Pool).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - runs program, creates Thread-Pool by number core of processor and adds work to queue,
     * after this completes work.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        ThreadPool pool = new ThreadPool(Runtime.getRuntime().availableProcessors());
        for (int index = 0; index < 200; index++) {
            pool.add(new Work(index + 1, "work"));
        }
        pool.shutdown();
    }heroes

}