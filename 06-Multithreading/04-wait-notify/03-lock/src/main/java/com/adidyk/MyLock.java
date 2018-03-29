package com.adidyk;

/** Class StartUi for create jar file and run program (Thread-Pool).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
class MyLock {

    /**
     * @param is locked - is.
     */
    private boolean isLocked = false;

    /**
     * @param object - is object.
     */
    private Object object = new Object();

    /**
     * lock - is lock.
     * @throws InterruptedException - is.
     */
    synchronized void lock() throws InterruptedException {
        //while (isLocked) {
            System.out.println("lock start");
            wait();
            System.out.println("lock finish");
        //}
        isLocked = true;
    }

    /**
     * unlock - is unlock.
     */
    synchronized void unlock() {
        isLocked = false;
        System.out.println("unlock start");
        notify();
        System.out.println("unlock finish");
    }

}
