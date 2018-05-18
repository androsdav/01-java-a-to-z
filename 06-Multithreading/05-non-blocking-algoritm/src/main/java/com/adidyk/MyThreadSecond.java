package com.adidyk;

//import java.util.Map;

/**
 * Class MyThreadSecond creates thread and grabs lock if lock is free.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 12.05.2018.
 * @version 1.0.
 */
public class MyThreadSecond implements Runnable {

    /**
     * @param cache - is link variable to object of class Cache (counter).
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
        //this.cache.delete(new User(2, "Adam", "NEW_animal_thread5"));
        /*
        this.cache.update(new User(2, "Adam", "NEW_animal_thread5"));
        this.cache.update(new User(2, "Adam", "NEW_animal_thread6"));
        this.cache.update(new User(2, "Adam", "NEW_animal_thread7"));
        this.cache.update(new User(2, "Adam", "NEW_animal_thread8"));
        */
        for (int index = 0; index < 100; index++) {
            this.cache.update(new User(2, "Adam", "test-" + index));
        }
        System.out.println(" " + Thread.currentThread().getName() + " <- finish ...");
    }

        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        for (Map.Entry<Integer, User> item : cache.getAll().entrySet()) {
            System.out.println("key: " + item.getKey() + " value: " + item.getValue());
        }
        */
        /*
        this.cache.update(new User(2, "Adam", "NEW_animal_thread5"));
        this.cache.update(new User(2, "Adam", "NEW_animal_thread6"));
        this.cache.update(new User(2, "Adam", "NEW_animal_thread7"));
        this.cache.update(new User(2, "Adam", "NEW_animal_thread8"));
        //System.out.println(" " + Thread.currentThread().getName() + " " + this.cache.get(2));
        System.out.println(" " + Thread.currentThread().getName() + " <- finish ...");
        */

}