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
     * @param name - is name.
     */
    synchronized void lock(String name) throws InterruptedException {
        while (this.isLocked) {
            System.out.println(" - [info]: Thread-" + name + " object is lock, wait ...");
            wait();
            //System.out.println(" - [info]: Thread-" + name + " object is not lock, go ...");
        }
        System.out.println(" - [info]: Thread-" + name + " object is not lock, go ...");
        isLocked = true;
    }

    /**
     * unlock - is unlock.
     * @param name - is name.
     */
    synchronized void unlock(String name) {
        isLocked = false;
        System.out.println(" - [info]: Thread-" + name + " lock finish ...");
        notify();
    }

}
