package com.adidyk;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class Counter this is counter.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.01.2018.
 * @version 1.0.
 */
@ThreadSafe
class Counter {

    /**
     * @param counter - is counter.
     */
    @GuardedBy("this")
    private int counter = 0;

    /**
     * addCounter - increments counter by one.
     */
    synchronized void addCounter() {
            this.counter++;
    }

    /**
     * getCounter - return result of counter.
     * @return - get result of counter.
     */
    synchronized int getCounter() {
            return this.counter;
    }

}