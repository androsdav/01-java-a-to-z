package com.adidyk;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class Counter.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 18.01.2018.
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
        synchronized (Counter.class) {
            this.counter++;
        }
    }

    /**
     * getCounter - get counter.
     * @return - get counter.
     */
    synchronized int getCounter() {
        synchronized (Counter.class) {
            return this.counter;
        }
    }

}