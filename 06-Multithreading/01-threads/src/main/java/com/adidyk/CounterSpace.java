package com.adidyk;

import static com.adidyk.Constant.SPACE;

/**
 * Class CounterSpace counts number of space in line.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.01.2017.
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
     * run - run thread.
     */
    @Override
    public void run() {
        System.out.println("start thread:" + this.name);
        this.counter(this.string);
        System.out.println("finish thread:" + this.name);
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
        System.out.println(String.format("%s %s %s", this.name, count, "[space]"));
    }

}