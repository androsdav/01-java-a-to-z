package com.adidyk;

/**
 * Class StartUi for create jar file and run program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.01.2017.
 * @version 1.0.
 */
public class CounterWord implements Runnable {
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
    CounterWord(final String name, final String string) {
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
        //boolean wordStart = false;
        //boolean wordEnd = false;
        boolean word = false;
        for (int index = 0; index < string.length(); index++) {
            if (string.charAt(index) != ' ') {
                word = true;
            }
            if ((string.charAt(index) == ' ' && word) || (index == string.length() - 1) && word) {
                count++;
                word = false;
            }
        }
        System.out.println(String.format("%s%s %s", "Count of word: ", count, this.name));
    }

}
