package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
         * @param storage - is storage (link variable to object of class UserStorage).
         */
        private final UserStorage storage;

        /**
         * @param id - user id.
         */
        private int id;

        /**
         * @param amount - user amount.
         */
        private int amount;

        /**
         * ThreadCount - constructor.
         * @param storage - is storage (link variable to object of class UserSorage).
         * @param id - is user id.
         * @param amount - is user amount.
         */
        private Add(UserStorage storage, int id, int amount) {
            this.storage = storage;
            this.id = id;
            this.amount = amount;
        }

        /**
         * run - runs thread and adds new user to storage (array).
         */
        @Override
        public void run() {
            this.storage.add(new User(this.id, this.amount));
        }
    }

    /**
     * amountThreadTest - test class UserStorage.
     * @throws InterruptedException - is interrupted exception.
     */
    @Test
    public void amountThreadTest() throws InterruptedException {
        UserStorage storage = new UserStorage(3);
        Thread add1 = new Add(storage, 1, 10);
        Thread add2 = new Add(storage, 2, 20);
        Thread add3 = new Add(storage, 3, 30);
        add1.start();
        add1.join();
        add2.start();
        add2.join();
        add3.start();
        add3.join();
        storage.transfer(1, 2, 4);
        assertThat(6, is(storage.get(0).getAmount()));
        assertThat(24, is(storage.get(1).getAmount()));
        assertThat(30, is(storage.get(2).getAmount()));
    }

}