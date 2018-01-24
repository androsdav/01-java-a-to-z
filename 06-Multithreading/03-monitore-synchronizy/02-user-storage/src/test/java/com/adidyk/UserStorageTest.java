package com.adidyk;

import org.junit.Before;
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
     * @param storageActual - link variable to object class UserStorage.
     */
    private UserStorage storageActual = new UserStorage();


    /**
     * @param storageExpected - link variable to object class UserStorage.
     */
    private UserStorage storageExpected = new UserStorage();

    /**
     * @param user - user.
     */
    private User user = new User(3, 30);


    /**
     * init - adds new user to container storageActual and storageExpected.
     */
    @Before
    public void init() {
        this.storageActual.add(new User(1, 10));
        this.storageActual.add(new User(2, 20));
        this.storageActual.add(new User(3, 30));
        this.storageExpected.add(new User(1, 10));
        this.storageExpected.add(new User(2, 20));
    }

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
         * @param storage - is storage (link variable to object of class UserStorage).
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
     * transferThreadTest - tests class UserStorage.
     * @throws InterruptedException - is interrupted exception.
     */
    @Test
    public void transferThreadTest() throws InterruptedException {
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

    /**
     * addTest - tests method add of class UserStorage.
     */
    @Test
    public void addTestTrue() {
        boolean resultTrue = this.storageExpected.add(this.user);
        boolean resultFalse = this.storageExpected.add(this.user);
        assertThat(this.storageActual, is(this.storageExpected));
        assertThat(resultTrue, is(true));
        assertThat(resultFalse, is(false));
    }

    /**
     * updateTest - tests method update of class UserStorage.
     */
    @Test
    public void updateTest() {
        this.storageExpected.add(new User(3, 1234));
        boolean resultTrue = this.storageExpected.update(this.user);
        assertThat(this.storageActual, is(this.storageExpected));
        assertThat(resultTrue, is(true));
    }

    /**
     * transferTest - tests method transfer of class UserStorage.
     */
    @Test
    public void transferTest() {
        this.storageActual.add(new User(3, 43));
        this.storageActual.add(new User(4, 27));
        this.storageExpected.add(new User(3, 30));
        this.storageExpected.add(new User(4, 40));
        this.storageExpected.transfer(4, 3, 13);
        assertThat(this.storageActual, is(this.storageExpected));
    }

    /**
     * deleteTest - tests method delete of class UserStorage.
     */
    @Test
    public void deleteTest() {
        this.storageExpected.add(new User(4, 40));
        this.storageExpected.add(new User(3, 30));
        boolean resultTrue = this.storageExpected.delete(new User(4, 23124));
        boolean resultFalse = this.storageExpected.delete(new User(45, 23124));
        assertThat(this.storageActual, is(this.storageExpected));
        assertThat(resultTrue, is(true));
        assertThat(resultFalse, is(false));
    }

    /**
     * getTest - tests method get of class UserStorage.
     */
    @Test
    public void getTest() {
        assertThat(new User(1, 10), is(this.storageActual.get(0)));
    }

    /**
     * sizeTest - tests get of class UserStorage.
     */
    @Test
    public void sizeTest() {
        assertThat(3, is(this.storageActual.size()));
    }

}