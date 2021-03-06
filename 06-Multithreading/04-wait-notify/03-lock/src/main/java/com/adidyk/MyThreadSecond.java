package com.adidyk;

/** Class MyThreadSecond creates thread and grabs lock if lock is free.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
public class MyThreadSecond implements Runnable {

    /**
     * @param locker - is link variable to object of class Locker (locker).
     */
    private Locker locker;

    /**
     * @param counter - is link variable to object of class Counter (counter).
     */
    private Counter counter;

    /**
     * MyThreadSecond - constructor.
     * @param locker - is link variable to object of class Locker (locker).
     * @param counter - is link variable to object of class Counter (counter).
     */
    MyThreadSecond(Locker locker, Counter counter) {
        this.locker = locker;
        this.counter = counter;
    }

    /**
     * run - starts thread, grabs lock if lock is free and increases value
     * of counter by one, after that frees lock.
     */
    @Override
    public void run() {
        System.out.println(" " + Thread.currentThread().getName() + " -> start ...");
        try {
            this.locker.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.counter.addCounter();
        this.locker.unlock();
        System.out.println(" " + Thread.currentThread().getName() + " <- finish ...");
    }

}