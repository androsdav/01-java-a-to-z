package com.adidyk;

/** Class StartUi for create jar file and run program (Thread-Pool).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
public class MyThreadFirst implements Runnable {

    /**
     * @param thread - is name.
     */
    private Thread thread;

    /**
     * @param lock - is lock.
     */
    private Locker locker;

    /**
     * @param count - is.
     */
    private Counter counter;

    /**
     * NyThread - constructor.
     * @param locker - is lock.
     * @param counter - is lock.
     */
    MyThreadFirst(Locker locker, Counter counter) {
        this.locker = locker;
        this.counter = counter;
    }

    /**
     * run - is run.
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
        /*
        try {
            this.locker.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        this.counter.addCounter();
        this.locker.unlock();
        System.out.println(" " + Thread.currentThread().getName() + " <- finish ...");
        /*
        try {
            System.out.println(" Thread-" + this.name + " -> start ...   ");
            this.lock.lock(this.name);
            //Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int index = 0; index < 1000; index++) {
            this.counter.addCounter();
        }
        //this.counter.addCounter();
        //this.lock.unlock(this.name);
        System.out.println(" Thread-" + this.name + " <- finish ...");
        */
    }

}