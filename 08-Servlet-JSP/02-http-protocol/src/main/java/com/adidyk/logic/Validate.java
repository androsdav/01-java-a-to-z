package com.adidyk.logic;

import com.adidyk.models.User;
import java.util.List;

/**
 * Interface Validate defines next method for container of users: add, update, delete, findById, findAll.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 27.01.2019.
 * @version 1.0.
 */
public interface Validate {

    /**
     * add - adds user to container.
     * @param user - user (link variable to object of class User).
     */
    User add(User user);

    /**
     * update - updates user by id in container.
     * @param user - user (link variable to object of class User).
     */
    void update(User user);

    /**
     * delete - deletes user by id from container.
     * @param id - user id.
     * @return - returns id.
     */
    String delete(String id);

    /**
     * findById - finds user by id in container.
     * @param id - user id.
     * @return - returns user id.
     */
    User findById(String id);

    /**
     * findAll - returns all user from container.
     * @return - returns all user.
     */
    List<User> findAll();

}