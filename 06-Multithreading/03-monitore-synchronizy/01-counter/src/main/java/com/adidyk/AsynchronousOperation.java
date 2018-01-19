package com.adidyk;

/**
 * Class AsynchronousOperation for create jar file and run program (CounterThread).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 18.01.2018.
 * @version 1.0.
 */
public class AsynchronousOperation {

    /**
     * start - run program, create many threads.
     */
    private void start() {
        Counter count = new Counter();
        for (int index = 0; index < 1000; index++) {
            Thread thread = new Thread(new CounterThread(count));
            thread.start();
        }
        System.out.println("Counter result: " + count.getCounter());
    }

    /**
     * main - is for create jar file and run program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        new AsynchronousOperation().start();
    }

}