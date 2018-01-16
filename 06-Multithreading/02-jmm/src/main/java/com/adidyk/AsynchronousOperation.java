package com.adidyk;

import static com.adidyk.Constant.NAME_THREAD_COUNT_SPACES;
import static com.adidyk.Constant.NAME_THREAD_COUNT_WORD;
import static com.adidyk.Constant.STRING;

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
        new Thread(new CounterSpace(NAME_THREAD_COUNT_SPACES, STRING)).start();
        new Thread(new CounterWord(NAME_THREAD_COUNT_WORD, STRING)).start();
    }

    /**
     * main - is for create jar file and run program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        new AsynchronousOperation().start();
    }

}