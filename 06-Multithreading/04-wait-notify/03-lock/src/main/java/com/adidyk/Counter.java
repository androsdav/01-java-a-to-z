package com.adidyk;

/** Class StartUi for create jar file and run program (Thread-Pool).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
class Counter {

    /**
     * @param quantity - is quantity.
     */
    private int counter;

    /**
     * addCounter - is.
     */
    void addCounter() {
        this.counter++;
    }

    /**
     * getCounter - is.
     * @return - returns counter.
     */
    int getCounter() {
        return this.counter;
    }

}