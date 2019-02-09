package com.adidyk;

/**
 * Interface Storage defines next method for container of users: add, update, delete, findById, findAll.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class UserStorage {

    /**
     * @param storage - storage.
     */
    private final Storage storage;

    /**
     * UserStorage - constructor.
     * @param storage - storage.
     */
    public UserStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * add - adds user to container.
     * @param user - user (link variable to object of class User).
     */
    public User add(User user) {
        this.storage.add(user);
        return user;
    }

}