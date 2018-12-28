package com.adidyk.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PostFormServlet uses form and method POST to enter name and surname and returns entered name and surname.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 28.12.2018.
 * @version 1.0.
 */
public class MemoryStore implements Store {

    /**
     * @param users - llink variable to object of class ArrayList.
     */
    private List<User> users = new ArrayList<>();

    /**
     * @param id - user id.
     */
    private int id = 1;

    /**
     * add - adds user.
     * @param user - user.
     */
    @Override
    public void add(User user) {
        user.setId(this.id);
        this.users.add(user);
        this.id++;
    }

    /**
     * update - update user by id.
     * @param user - user.
     */
    @Override
    public void update(User user) {
        for (User item : this.users) {
            if (item.getId() == user.getId()) {
                item = user;
            }

        }

    }

    /**
     * delete - delete user by id.
     * @param id - user id.
     */
    @Override
    public void delete(String id) {

    }
}
