package com.adidyk;

import static com.adidyk.Constant.INFO;
import static com.adidyk.Constant.SPACE;

/**
 * Class CounterWord counts number of word in line (Thread-words).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.01.2018.
 * @version 1.0.
 */
public class CounterWord implements Runnable {

    /**
     * @param name - is name Thread-word.
     */
    private final String name;

    /**
     * @param string - is string.
     */
    private final String string;

    /**
     * CounterWord - constructor.
     * @param name - is name thread.
     * @param string - is name string.
     */
    CounterWord(final String name, final String string) {
        this.name = name;
        this.string = string;
    }

    /**
     * run - run Thread-word.
     */
    public void run() {
        System.out.println(String.format("%s %s %s", INFO, this.name, "-> start"));
        this.counter(this.string);
        System.out.println(String.format("%s %s %s", INFO, this.name, "<- finish"));
    }

    /**
     * counter - is counter that counts number of word in line.
     * @param string - is name string.
     */
    private void counter(String string) {
        int count = 0;
        boolean word = false;
        for (int index = 0; index < string.length(); index++) {
            if (string.charAt(index) != SPACE) {
                word = true;
            }
            if ((string.charAt(index) == SPACE && word) || (index == string.length() - 1) && word) {
                count++;
                word = false;
            }
        }
        this.view(count);
    }

    /**
     * view - outputs result (number of space in line) to console.
     * @param count - is number of space in line.
     */
    private void view(int count) {
        System.out.println(String.format("        %s = %s %s",  this.name, count, "[word]"));
    }

}