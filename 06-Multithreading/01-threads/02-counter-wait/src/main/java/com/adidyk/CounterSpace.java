package com.adidyk;

import static com.adidyk.Constant.INFO;
import static com.adidyk.Constant.SPACE;

/**
 * Class CounterSpace counts number of space in line (Thread-space).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.01.2018.
 * @version 1.0.
 */
public class CounterSpace implements Runnable {

    /**
     * @param name - is name thread.
     */
    private final String name;

    /**
     * @param string - is string.
     */
    private final String string;

    /**
     * CounterSpace - constructor.
     * @param name - is name thread.
     * @param string - is name string.
     */
    CounterSpace(final String name, final String string) {
        this.name = name;
        this.string = string;
    }

    /**
     * run - run Thread-space.
     */
    @Override
    public void run() {
        System.out.println(String.format("%s %s %s", INFO, this.name, "-> start"));
        this.counter(this.string);
        System.out.println(String.format("%s %s %s", INFO, this.name, "<- finish"));
    }

    /**
     * counter - is counter that counts number of space in line.
     * @param string - is string.
     */
    private void counter(String string) {
        int count = 0;
        for (int index = 0; index < string.length(); index++) {
            if (string.charAt(index) == SPACE) {
                count++;
            }
        }
        this.view(count);
    }

    /**
     * view - outputs result (number of space in line) to console.
     * @param count - is number of space in line.
     */
    private void view(int count) {
        System.out.println(String.format("        %s = %s %s", this.name, count, "[space]"));
    }

}