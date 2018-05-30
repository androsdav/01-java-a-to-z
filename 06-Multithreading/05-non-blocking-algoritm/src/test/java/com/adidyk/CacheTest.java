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
     * @param adam - link variable to object of class user.
     */
    private final User adam = new User(2, "Adam", "administrator");

    /**
     * @param dilan - link variable to object of class user.
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
        //boolean resultTrue = this.cache.update(new User(1, "Bob", "advanced"));
        //boolean resultFalse = this.cache.update(new User(6, "Bob", "advanced"));
        //assertThat(true, is(resultTrue));
        //assertThat(false, is(resultFalse));
        //assertThat(1, is(this.cache.get(1).getVersion()));
        //assertThat("advanced", is(this.cache.get(1).getRole()));
    }

    /**
     * updateOptimisticExceptionTest - tests method update of class Cache when appears
     * optimistic exception when multithreading.
     * @exception InterruptedException - is interrupted exception.
     */
    @Test
    public void updateOptimisticExceptionTest() throws InterruptedException {
        /*
        for (int index = 0; index < 100; index++) {
            new Thread(new ThreadFirst(this.cache)).start();
        }
        Thread.sleep(4000);
        */
        Thread first = new Thread(new ThreadFirst(this.cache));
        Thread second = new Thread(new ThreadSecond(this.cache));
        first.start();
        second.start();
        Thread.sleep(3000);
       // first.join();
        //second.join();
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
     * Class ThreadFirst creates thread.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 12.05.2018.
     * @version 1.0.
     */
    private class ThreadFirst implements Runnable {

        /**
         * @param cache - is link variable to object of class Cache.
         */
        private Cache cache;

        /**
         * ThreadFirst - constructor.
         *
         * @param cache - is link variable to object of class Cache.
         */
        ThreadFirst(Cache cache) {
            this.cache = cache;
        }

        /**
         * run - starts thread.
         */
        @Override
        public void run() {
            /*
            try {
                this.cache.updateNew(new User(2, "Bob", "administrator"));
            } catch (OptimisticException ex) {
                assertThat(ex.getMessage(), is("optimistic exception"));
            }
            //this.cache.add(new User(1, "Tom", "operator"));
            //this.cache.add(new User(2, "Bob", "administrator"));
            //this.cache.add(new User(3, "Bill", "admin"));

            //System.out.println("first: " + this.cache.get(2));
            /*
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            try {
                for (int index = 0; index < 2000; index++) {
                    this.cache.update(new User(1, "bob", "operator" + index));
                    //System.out.println("[threadFirst]: " + this.cache.get(1));
                }
            } catch (OptimisticException ex) {
                assertThat(ex.getMessage(), is("optimistic exception"));
                System.out.println("[info]: 'optimistic exception' testing was successful");
            }

        }

    }

    /**
     * Class ThreadSecond creates thread.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 12.05.2018.
     * @version 1.0.
     */
    public class ThreadSecond implements Runnable {

        /**
         * @param cache - is link variable to object of class Cache.
         */
        private Cache cache;

        /**
         * ThreadSecond - constructor.
         * @param cache - is link variable to object of class Cache.
         */
        ThreadSecond(Cache cache) {
            this.cache = cache;
        }

        /**
         * run - starts thread.
         */
        @Override
        public void run() {
            /*
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                this.cache.updateNew(new User(2, "Bob", "administrator"));
            } catch (OptimisticException ex) {
                assertThat(ex.getMessage(), is("optimistic exception"));
            }
            */
            try {
                for (int index = 0; index < 2000; index++) {
                    this.cache.update(new User(1, "bob", "administrator" + index));
  //                  System.out.println("[threadSecond]: " + this.cache.get(1));
                }
            } catch (OptimisticException ex) {
                assertThat(ex.getMessage(), is("optimistic exception"));
                System.out.println("[info]: 'optimistic exception' testing was successful");
            }
        }

    }

}