package com.adidyk;

/**
 * Interface Storage defines next method for container of users: add, update, delete, findById, findAll.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class JdbcStorage implements Storage {

    /**
     * add - adds user.
     * @param user - user (link variable to object of class User).
     * @return - returns user.
     */
    @Override
    public User add(User user) {
        System.out.println("jdbc storage");
        return null;
    }

}