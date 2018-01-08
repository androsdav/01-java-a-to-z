package com.adidyk;

import static com.adidyk.Constant.NAME_THREAD_COUNT_SPACES;
import static com.adidyk.Constant.NAME_THREAD_COUNT_WORD;
import static com.adidyk.Constant.MAIN_THREAD;
import static com.adidyk.Constant.STRING;

/**
 * Class AsynchronousOperation for create jar file and run program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.01.2017.
 * @version 1.0.
 */
public class AsynchronousOperation {

    /**
     * start - run program, run Main-thread and CounterSpace-thread and CounterWord-thread.
     */
    private void start() {
        System.out.println("START");
        Thread thread = new Thread(new MainThread(MAIN_THREAD));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FINISH");
    }

    /**
     * main - is for create jar file and run program.
     *
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        new AsynchronousOperation().start();
    }

    /**
     * Class MainThread is main thread.
     *
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @version 1.0.
     * @since 06.01.2017.
     */
    public static final class MainThread implements Runnable {

        /**
         * @param name - is name thread.
         */
        private final String name;

        /**
         * MAinThread - constructor.
         *
         * @param name - is name thread.
         */
        MainThread(final String name) {
            this.name = name;
        }

        /**
         * run - starts two threads:
         * thread -> counts number of space in line;
         * thread -> counts number of word in line.
         */
        @Override
        public void run() {
            System.out.println("[INFO]: " + "main-thread start ... ");
            Thread space = new Thread(new CounterSpace(NAME_THREAD_COUNT_SPACES, STRING));
            Thread word = new Thread(new CounterWord(NAME_THREAD_COUNT_WORD, STRING));
            space.start();
            try {
                space.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            word.start();
            try {
                word.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("[INFO]: " + "main-thread finish ... ");
            }
        }
    }

}