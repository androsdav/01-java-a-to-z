package com.adidyk;

/** Class StartUi for create jar file and run program (Thread-Pool).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
public class MyThread implements Runnable {

    /**
     * @param name - is name.
     */
    private String name;

    /**
     * @param lock - is lock.-
     */
    private MyLock lock;

    /**
     * NyThread - constructor.
     * @param name - is name thread.
     * @param lock - is lock.
     */
    MyThread(String name, MyLock lock) {
        this.name = name;
        this.lock = lock;
    }

    /**
     * run - is run.
     */
    @Override
    public void run() {
        System.out.println("start thread: " + this.name);
        System.out.println("finish thread: " + this.name);
    }
}
