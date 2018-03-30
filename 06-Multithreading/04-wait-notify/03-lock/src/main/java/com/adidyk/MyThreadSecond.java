package com.adidyk;

/** Class StartUi for create jar file and run program (Thread-Pool).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
public class MyThreadSecond implements Runnable {

    /**
     * @param name - is name.
     */
    private String name;

    /**
     * @param lock - is lock.
     */
    private MyLock lock;

    /**
     * @param count - is.
     */
    private Counter counter;

    /**
     * NyThread - constructor.
     * @param name - is name thread.
     * @param lock - is lock.
     * @param counter - is lock.
     */
    MyThreadSecond(String name, MyLock lock, Counter counter) {
        this.name = name;
        this.lock = lock;
        this.counter = counter;
    }

    /**
     * run - is run.
     */
    @Override
    public void run() {
        try {
            System.out.println(" Thread-" + this.name + " -> start ...   ");
            //this.lock.lock(this.name);
            Thread.sleep(5);
            //this.lock.unlock(this.name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //this.counter.addCounter();
        //this.lock.unlock(this.name);
        System.out.println(" Thread-" + this.name + " <- finish ...");
    }

}