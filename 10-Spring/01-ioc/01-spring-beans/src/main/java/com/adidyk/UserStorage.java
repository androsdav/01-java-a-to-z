package com.adidyk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Interface Storage defines next method for container of users: add, update, delete, findById, findAll.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
@Component
public class UserStorage {

    /**
     * @param storage - storage.
     */
    private final Storage storage;

    /**
     * UserStorage - constructor.
     * @param storage - storage.
     */
    @Autowired
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