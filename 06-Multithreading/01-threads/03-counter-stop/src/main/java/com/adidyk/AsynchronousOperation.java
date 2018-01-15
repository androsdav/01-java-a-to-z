package com.adidyk;

import static com.adidyk.Constant.NAME_THREAD_COUNT_CHAR;
import static com.adidyk.Constant.NAME_THREAD_TIME;
import static com.adidyk.Constant.STRING;
import static com.adidyk.Constant.TIME;

/**
 * Class AsynchronousOperation for create jar file and run program (Thread-time and Thread-char).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.01.2018.
 * @version 1.0.
 */
public class AsynchronousOperation {

    /**
     * start - run program, run Thread-time and Thread-char.
     */
    private void start() {
        Thread countChar = new Thread(new CountChar(NAME_THREAD_COUNT_CHAR, STRING));
        Thread time = new Thread(new Time(NAME_THREAD_TIME, TIME, countChar));
        countChar.start();
        time.start();
    }

    /**
     * main - is for create jar file and run program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        new AsynchronousOperation().start();
    }

}