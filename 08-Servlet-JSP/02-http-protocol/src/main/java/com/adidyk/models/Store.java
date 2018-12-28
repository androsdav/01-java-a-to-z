package com.adidyk.models;

/**
 * Class PostFormServlet uses form and method POST to enter name and surname and returns entered name and surname.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.12.2018.
 * @version 1.0.
 */
public interface Store {

    /**
     * add - adds user.
     * @param user - user.
     */
    void add(User user);

    /**
     * update - update user by id.
     * @param user - user.
     */
    void update(User user);

    /**
     * delete - delete user by id.
     * @param id - user id.
     */
    void delete(String id);

}