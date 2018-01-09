package com.adidyk;

import static com.adidyk.Constant.INFO;

/**
 * Class Time  checks total execution time of program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.01.2018.
 * @version 1.0.
 */

public class CountChar implements Runnable {

    /**
     * @param name - is ame thread.
     */
    private final String name;

    /**
     * @param string - is name string.
     */
    private final String string;

    /**
     * CountChar - constructor.
     * @param name - is name thread.
     * @param string - name string.
     */
    CountChar(final String name, final String string) {
        this.name = name;
        this.string = string;
    }

    /**
     * run - run Thread-time check total execution time of program.
     */
    @Override
    public void run() {
        System.out.println(String.format("%s %s %s", INFO, this.name, "-> start"));
        this.counter();
        System.out.println(String.format("%s %s %s", INFO, this.name, "<- finish"));
    }

    /**
     * counter - is counter that counts number of symbol in line.
     */
    private void counter() {
        long count = 0;
        while (!Thread.interrupted()) {
            for (int index = 0; index < string.length(); index++) {
                count++;
            }
        }
        this.view(count);
    }

    /**
     * view - outputs result (number of space in line) to console.
     * @param count - is number of space in line.
     */
    private void view(long count) {
        System.out.println(String.format("        %s = %s %s", this.name, count, "[symbol]"));
    }

}