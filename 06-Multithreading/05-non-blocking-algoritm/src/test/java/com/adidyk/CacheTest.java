package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserTest does testing of class User.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
public class CacheTest {

    /**
     * @param bob - link variable to object of class user.
     */
    private final User bob = new User(1, "Bob", "operator");

    /**
     * @param bob - link variable to object of class user.
     */
    private final User adam = new User(2, "Adam", "administrator");

    /**
     * @param bob - link variable to object of class user.
     */
    private final User dilan = new User(3, "Dilan", "god");

    /**
     * @param cache - is link variable to object of class Cache.
     */
    private final Cache cache = new Cache();

    /**
     * init - initialisation all parameters and adds new user to container list.
     */
    @Before
    public void init() {
        this.cache.add(this.bob);
        this.cache.add(this.adam);
        this.cache.add(this.dilan);
    }

    /**
     * addTest - tests method add of class Cache.
     */
    @Test
    public void addTest() {
        User resultAddTrue = this.cache.add(new User(4, "Amanda", "star"));
        User resultAddFalse = this.cache.add(new User(2, "David", "policeman"));
        assertThat(resultAddTrue, is(new User(4, "Amanda", "star")));
        assertThat(resultAddFalse, is(new User(2, "Adam", "administrator")));
    }

    /**
     * updateTest - tests method update of class Cache.
     */
    @Test
    public void updateTest() {
        boolean resultTrue = this.cache.update(new User(1, "Bob", "advanced"));
        boolean resultFalse = this.cache.update(new User(6, "Bob", "advanced"));
        assertThat(true, is(resultTrue));
        assertThat(false, is(resultFalse));
        assertThat(1, is(this.cache.get(1).getVersion()));
        assertThat("advanced", is(this.cache.get(1).getRole()));
    }

    /**
     * updateOptimisticExceptionTest - tests method update when appears
     * optimistic exception when multithreading.
     */
    @Test
    public void updateOptimisticExceptionTest() {
        Thread first = new Thread(new ThreadFirst(this.cache));
        first.start();
        //System.out.println("exit");
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //this.cache.update(new User(1, "Bob", "operator"));
            try {
                cache.update(new User(1, "Bob", "operator"));
                System.out.println(this.cache.get(1));
            } catch (OptimisticException ex) {
                System.out.println("Thread 2: exception");
                assertThat(ex.getMessage(), is("optimistic exceptio"));
            }
        }).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * deleteTest - tests method delete of class Cache.
     */
    @Test
    public void deleteTest() {
        boolean resultDeleteTrue = this.cache.delete(new User(2, "Adam", "administrator"));
        boolean resultDeleteFalse = this.cache.delete(new User(2, "David", "policeman"));
        assertThat(true, is(resultDeleteTrue));
        assertThat(false, is(resultDeleteFalse));
    }

    /**
     * getTest - tests method get of class Cache.
     */
    @Test
    public void getTest() {
        User result = this.cache.get(3);
        assertThat(3, is(result.getId()));
        assertThat("Dilan", is(result.getName()));
        assertThat("god", is(result.getRole()));
        assertThat(0, is(result.getVersion()));
    }


    /**
     * Class MyThreadFirst creates thread and grabs lock if lock is free.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 12.05.2018.
     * @version 1.0.
     */
    private class ThreadFirst implements Runnable {

        /**
         * @param cache - is link variable to object of class Counter (counter).
         */
        private Cache cache;

        /**
         * MyThreadFirst - constructor.
         *
         * @param cache - is link variable to object of class Locker (locker).
         */
        ThreadFirst(Cache cache) {
            this.cache = cache;
        }

        /**
         * run - starts thread, grabs lock if lock is free and increases value
         * of counter by one, after that frees lock.
         */
        @Override
        public void run() {
            this.cache.update(new User(1, "bob", "operator"));
            System.out.println("Thread1: " + this.cache.get(1));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(this.cache.get(1));
        }

    }

    /**
     * Class MyThreadSecond creates thread and grabs lock if lock is free.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 12.05.2018.
     * @version 1.0.
     */
    public class ThreadSecond implements Runnable {

        /**
         * @param cache - is link variable to object of class Cache (counter).
         */
        private Cache cache;

        /**
         * MyThreadSecond - constructor.
         * @param cache - is link variable to object of class Locker (locker).
         */
        ThreadSecond(Cache cache) {
            this.cache = cache;
        }

        /**
         * run - starts thread, grabs lock if lock is free and increases value
         * of counter by one, after that frees lock.
         */
        @Override
        public void run() {
            /*
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            try {
                this.cache.update(new User(1, "Bob", "operator"));
            } catch (OptimisticException ex) {
                System.out.println("---------EXCEPTION---------");
                assertThat(ex.getMessage(), is("optimistic exceptio"));
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}