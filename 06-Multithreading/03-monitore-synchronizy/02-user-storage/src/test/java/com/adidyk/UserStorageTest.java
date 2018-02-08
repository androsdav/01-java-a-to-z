package com.adidyk;

import org.junit.Test;

/**
 * UserStorageTest does testing of class UserStorage.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.01.2018.
 * @version 1.0.
 */
public class UserStorageTest {

    /**
     * Add is thread that uses object of class UserStorage.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 24.01.2018.
     * @version 1.0.
     */
    private class Add extends Thread {

        /**
         * @param storage - is storage (link variable to object of class Counter).
         */
        private final UserStorage storage;

        /**
         * @param id - is id.
         */
        private int id = 1;

        /**
         * ThreadCount - constructor.
         * @param storage - is counter (link variable to object of class Counter).
         */
        private Add(UserStorage storage) {
            this.storage = storage;
        }

        /**
         * run - runs thread and increase counter by one.
         */
        @Override
        public void run() {
            this.storage.add(new User(this.id++, 10));
        }
    }

    /**
     * ThreadCount is thread that uses object of class Counter.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 24.01.2018.
     * @version 1.0.
     */
    private class Get extends Thread {

        /**
         * @param counter - is counter (link variable to object of class Counter).
         */
        private final UserStorage storage;

        /**
         * ThreadCount - constructor.
         * @param storage - is counter (link variable to object of class Counter).
         */
        private Get(UserStorage storage) {
            this.storage = storage;
        }

        /**
         * run - runs thread and increase counter by one.
         */
        @Override
        public void run() {
            //this.storage.add(new User(1, 10));
            this.view();
        }

        /**
         * view - is view.
         */
        void view() {
            System.out.println();
            System.out.println();
            System.out.println(this.storage.get(0));
            System.out.println();
        }
    }

    /**
     * whenExecute3ThreadThen3 - test class Counter.
     * @throws InterruptedException - is interrupted exception.
     */
    @Test
    public void whenExecute3ThreadThen3() throws InterruptedException {
        UserStorage storage = new UserStorage(3);
        Thread add1 = new Add(storage);
        Thread add2 = new Add(storage);
        Thread get1 = new Get(storage);
        add1.start();
        add2.start();
        get1.start();
        //System.out.println();
        //System.out.println(get1.get(0));
       // System.out.println();
//        assertThat(counter.getCounter(), is(3));
    }



}