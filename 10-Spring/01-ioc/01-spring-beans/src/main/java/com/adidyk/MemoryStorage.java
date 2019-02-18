package com.adidyk;

import org.springframework.stereotype.Component;

/**
 * Interface Storage defines next method for container of users: add, update, delete, findById, findAll.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class MemoryStorage implements Storage {

    /**
     * add - adds user.
     * @param user - user (link variable to object of class User).
     * @return - returns user.
     */
    @Override
    public User add(User user) {
        System.out.println("memory storage");
        return null;
    }

}