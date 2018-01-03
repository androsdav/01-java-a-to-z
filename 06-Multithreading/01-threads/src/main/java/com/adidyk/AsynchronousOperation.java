package com.adidyk;

import static com.adidyk.Constant.NAME_THREAD_COUNT_SPACES;
import static com.adidyk.Constant.NAME_THREAD_COUNT_WORD;
import static com.adidyk.Constant.STRING;

/**
 * Class AsynchronousOperation for create jar file and run program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.01.2017.
 * @version 1.0.
 */
public class AsynchronousOperation {

    /**
     * @param string - is string.
     */
    private final String string;

    /**
     * @param space - is name of thread that does to count number of space in line.
     */
    private final String space;

    /**
     * @param word - is name of thread that does to count number of word in line.
     */
    private final String word;

    /**
     * AsynchronousOperation - constructor.
     * @param string - is string.
     * @param space - is name of thread that does to count number of space in line.
     * @param word - is name of thread that does to count number of word in line.
     */
    private AsynchronousOperation(final String string, final String space, final String word) {
        this.string = string;
        this.space = space;
        this.word = word;
    }

    /**
     * start - run program.
     */
    private void start() {
        new Thread(new CounterSpace(this.space, this.string)).start();
        new Thread(new CounterWord(this.word, this.string)).start();
    }

    /**
     * main - is for create jar file and run program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        new AsynchronousOperation(STRING, NAME_THREAD_COUNT_SPACES, NAME_THREAD_COUNT_WORD).start();
    }

}