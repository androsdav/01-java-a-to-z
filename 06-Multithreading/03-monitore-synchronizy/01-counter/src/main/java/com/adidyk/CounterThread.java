package com.adidyk;

/**
 * Class CounterThread it starts a thread and increments param counter of class Counter in loop.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 18.01.2018.
 * @version 1.0.
 */
public class CounterThread implements Runnable {

    /**
     * @param count - is link variable to object of class Counter.
     */
    private final Counter count;

    /**
     * CounterThread - constructor.
     * @param count - is link variable to object of class Counter.
     */
    CounterThread(Counter count) {
        this.count = count;

    }
    /**
     * run - is run thread and increments param counter of class Counter in loop.
     */
    @Override
    public void run() {
        for (int index = 0; index < 1000; index++) {
            this.count.addCounter();
        }
    }

}
