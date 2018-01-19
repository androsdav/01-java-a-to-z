package com.adidyk;

/**
 * Class Counter.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 18.01.2018.
 * @version 1.0.
 */
class Counter {

    /**
     * @param counter - is counter.
     */
    private long counter = 0L;

    /**
     * addCounter - increments counter by one.
     */
    void addCounter() {
        this.counter++;
    }

    /**
     * getCounter - get counter.
     * @return - get counter.
     */
    long getCounter() {
        return this.counter;
    }

}