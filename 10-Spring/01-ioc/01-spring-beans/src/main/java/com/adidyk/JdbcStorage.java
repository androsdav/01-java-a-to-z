package com.adidyk;

/**
 * Class JdbcStorage defines next method for container of users: add.
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
    public User add(User user) {
        System.out.println("jdbc storage");
        return null;
    }

}