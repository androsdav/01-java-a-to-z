package com.adidyk;

/** Class StartUi for create jar file and run program (Thread-Pool).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
public class Lock {

    /**
     * lock - is lock.
     * @throws InterruptedException - is.
     */
    public void lock() throws InterruptedException {
        wait();
    }

    /**
     * unlock - is unlock.
     * @throws InterruptedException - is.
     */
    public void unlock() throws InterruptedException {
        notify();
    }
}
