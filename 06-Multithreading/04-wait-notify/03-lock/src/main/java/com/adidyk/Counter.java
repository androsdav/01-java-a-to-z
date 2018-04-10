package com.adidyk;

/** Class Counter.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
class Counter {

    /**
     * @param counter - is counter.
     */
    private int counter;

    /**
     * addCounter - increments counter by one.
     */
    void addCounter() {
        this.counter++;
    }

    /**
     * getCounter - returns counter.
     * @return - returns counter.
     */
    int getCounter() {
        return this.counter;
    }

}