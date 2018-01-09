package com.adidyk;

import static com.adidyk.Constant.INFO;

/**
 * Class Time  checks total execution time of program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.01.2018.
 * @version 1.0.
 */
public class Time implements Runnable {

    /**
     * @param name - is name thread.
     */
    private final String name;

    /**
     * @param time - is time for execution of program.
     */
    private final int time;

    /**
     * @param countChar - is countChar.
     */
    private final Thread countChar;

    /**
     * Time - constructor.
     * @param name - is name thread.
     * @param time - is time.
     * @param countChar - is countChar.
     */
    Time(final String name, int time, Thread countChar) {
        this.name = name;
        this.time = time;
        this.countChar = countChar;
    }

    /**
     * run - run Thread-time check total execution time of program.
     */
    @Override
    public void run() {
        System.out.println(String.format("%s %s %s", INFO, this.name, "-> start"));
        try {
            Thread.sleep(this.time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.countChar.interrupt();
        System.out.println(String.format("%s %s %s", INFO, this.name, "<- finish"));
    }

}