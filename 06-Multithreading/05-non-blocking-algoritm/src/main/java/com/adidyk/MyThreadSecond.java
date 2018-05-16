package com.adidyk;

/**
 * Class MyThreadSecond creates thread and grabs lock if lock is free.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 12.05.2018.
 * @version 1.0.
 */
public class MyThreadSecond implements Runnable {

    /**
     * @param cache - is link variable to object of class Counter (counter).
     */
    private Cache cache;

    /**
     * MyThreadSecond - constructor.
     * @param cache - is link variable to object of class Locker (locker).
     */
    MyThreadSecond(Cache cache) {
        this.cache = cache;
    }

    /**
     * run - starts thread, grabs lock if lock is free and increases value
     * of counter by one, after that frees lock.
     */
    @Override
    public void run() {
        System.out.println(" " + Thread.currentThread().getName() + " -> start ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.cache.update(new User(2, "Adam", "NEW_animal_thread2"));
        System.out.println(this.cache.get(2));
        System.out.println(" " + Thread.currentThread().getName() + " <- finish ...");
    }

}