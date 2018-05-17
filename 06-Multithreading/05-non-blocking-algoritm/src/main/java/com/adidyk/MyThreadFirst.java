package com.adidyk;

//import java.util.Map;

/**
 * Class MyThreadFirst creates thread and grabs lock if lock is free.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 12.05.2018.
 * @version 1.0.
 */
public class MyThreadFirst implements Runnable {

    /**
     * @param cache - is link variable to object of class Counter (counter).
     */
    private Cache cache;

    /**
     * MyThreadFirst - constructor.
     * @param cache - is link variable to object of class Locker (locker).
     */
    MyThreadFirst(Cache cache) {
        this.cache = cache;
    }

    /**
     * run - starts thread, grabs lock if lock is free and increases value
     * of counter by one, after that frees lock.
     */
    @Override
    public void run() {
        System.out.println(" " + Thread.currentThread().getName() + " -> start ...");
        for (int index = 0; index < 1000; index++) {
            this.cache.update(new User(2, "Adam", "test-" + index));
        }
        /*
        this.cache.update(new User(2, "Adam", "NEW_animal_thread1"));
        this.cache.update(new User(2, "Adam", "NEW_animal_thread2"));
        this.cache.update(new User(2, "Adam", "NEW_animal_thread3"));
        this.cache.update(new User(2, "Adam", "NEW_animal_thread4"));
        /*
        for (Map.Entry<Integer, User> item : cache.getAll().entrySet()) {
            System.out.println("key: " + item.getKey() + " value: " + item.getValue());
        }
        /*
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
        cache.update(1, "test");
        cache.update(1, "test");
        cache.update(1, "test");
        System.out.println(cache.get(1));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(this.cache.get(1));
        */
        System.out.println(" " + Thread.currentThread().getName() + " <- finish ...");
    }

}