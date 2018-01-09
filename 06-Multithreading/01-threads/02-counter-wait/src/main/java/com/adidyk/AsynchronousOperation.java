package com.adidyk;

import static com.adidyk.Constant.NAME_THREAD_COUNT_SPACES;
import static com.adidyk.Constant.NAME_THREAD_COUNT_WORD;
import static com.adidyk.Constant.NAME_THREAD_MAIN;
import static com.adidyk.Constant.STRING;
import static com.adidyk.Constant.INFO;

/**
 * Class AsynchronousOperation for create jar file and run program (Thread-space and Thread-words).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.01.2018.
 * @version 1.0.
 */
public class AsynchronousOperation {

    /**
     * start - run program, run Thread-space and Thread-word.
     */
    private void start() {
        System.out.println(String.format("\n%s %s \n", INFO, "PROGRAM -> START"));
        Thread thread = new Thread(new MainThread(NAME_THREAD_MAIN));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("\n%s %s \n", INFO, "PROGRAM <- FINISH"));
    }

    /**
     * main - is for create jar file and run program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        new AsynchronousOperation().start();
    }

    /**
     * Class MainThread is main thread.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @version 1.0.
     * @since 09.01.2018.
     */
    public static final class MainThread implements Runnable {

        /**
         * @param name - is name thread.
         */
        private final String name;

        /**
         * MainThread - constructor.
         * @param name - is name thread.
         */
        MainThread(String name) {
            this.name = name;
        }

        /**
         * run - starts two threads: Threads-space and Threads-words.
         */
        @Override
        public void run() {
            System.out.println(String.format("%s %s %s", INFO, this.name, "-> start"));
            Thread space = new Thread(new CounterSpace(NAME_THREAD_COUNT_SPACES, STRING));
            Thread words = new Thread(new CounterWord(NAME_THREAD_COUNT_WORD, STRING));
            space.start();
            try {
                space.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            words.start();
            try {
                words.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s %s %s", INFO, this.name, "<- finish"));
        }
    }

}