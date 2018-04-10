package com.adidyk;

/** Class Locker blocks lock if lock is free and unlock lock if thread has lock.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
class Locker {

    /**
     * @param isLocked - if thread has lock isLocked true (used method lock),
     * if thread has not lock isLocked false (used method unlock).
     */
    private boolean isLocked = false;

    /**
     * @param threadLock - is thread that grabs lock.
     */
    private Thread threadLock = null;

    /**
     * lock - thread grabs lock if lock is free.
     * @throws InterruptedException - is interrupted exception.
     */
    synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (this.isLocked && this.threadLock != thread) {
            System.out.println("  - [info]: " + thread.getName() + " is lock, wait ...");
            wait();
        }
        System.out.println("  - [info]: " + thread.getName() + " is not lock, go ...");
        this.isLocked = true;
        this.threadLock = thread;
    }

    /**
     * unlock - if thread has lock then lock is released.
     */
    synchronized void unlock() {
        Thread thread = Thread.currentThread();
        if (this.threadLock == thread) {
            this.isLocked = false;
            System.out.println("  - [info]: " + thread.getName() + " unlock ...");
            notify();
        }
    }

}