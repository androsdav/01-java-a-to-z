package com.adidyk;

/**
 * Class UserStorage defines next method for container of users: add.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class UserStorage {

    /**
     * @param storage - storage (link variable to object of interface Storage).
     */
    private final Storage storage;

    /**
     * UserStorage - constructor.
     * @param storage - storage (link variable to object of interface Storage).
     */
    public UserStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * add - adds user to container.
     * @param user - user (link variable to object of class User).
     */
    User add(User user) {
        this.storage.add(user);
        return user;
    }

}