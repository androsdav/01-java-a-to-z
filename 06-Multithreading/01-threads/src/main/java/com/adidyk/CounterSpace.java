package com.adidyk;

/**
 * Class StartUi for create jar file and run program.
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
     *
     * @param name - is name thread.
     * @param string - is name string.
     */
    CounterSpace(final String name, final String string) {
        this.name = name;
        this.string = string;
    }

    /**
     * run - run program.
     */
    @Override
    public void run() {
        this.counter(this.string);

    }

    /**
     * counter - is counter space.
     * @param string - is string.
     */
    private void counter(String string) {
        int count = 0;
        for (int index = 0; index < string.length(); index++) {
            if (string.charAt(index) == ' ') {
                count++;
            }
        }
        System.out.println(String.format("%s%s %s", "Count of space: ", count, this.name));
    }
}
