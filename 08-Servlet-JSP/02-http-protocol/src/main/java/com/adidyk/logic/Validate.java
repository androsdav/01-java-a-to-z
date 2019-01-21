package com.adidyk.logic;

import com.adidyk.models.User;

import java.util.List;

/**
 * Class PostFormServlet uses form and method POST to enter name and surname and returns entered name and surname.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.12.2018.
 * @version 1.0.
 */
public interface Validate {

    /**
     * add - adds user.
     * @param user - user.
     */
    User add(User user);

    /**
     * update - update user by id.
     * @param user - user.
     */
    void update(User user);

    /**
     * delete - delete user by id.
     * @param id - user id.
     */
    String delete(String id);

    /**
     * findById - finds user by id.
     * @param id - user id.
     * @return - returns user id.
     */
    User findById(String id);

    /**
     *
     * @return - returns all user.
     */
    List<User> findAll();

}