package com.adidyk;

/** Class StartUi for create jar file and run program (Thread-Pool).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
class Locker {

    /**
     * @param is locked - is.
     */
    private boolean isLocked = false;

    /**
     * @param threadLock - is lock.
     */
    private Thread threadLock = null;

    /**
     * @param object - is object.
     */
    private Object object = new Object();

    /**
     * lock - is lock.
     * @throws InterruptedException - is.
     */
    synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (this.isLocked) {
            System.out.println("  - [info]: " + thread.getName() + " is lock, wait ...");
            wait();
        }
        System.out.println("  - [info]: " + thread.getName() + " is not lock, go ...");
        this.isLocked = true;
        this.threadLock = thread;
    }

    /**
     * unlock - is unlock.
     */
    synchronized void unlock() {
        Thread thread = Thread.currentThread();
        this.isLocked = false;
        System.out.println("  - [info]: " + thread.getName() + " unlock ...");
        notify();
    }

}