package com.adidyk.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class PostFormServlet uses form and method POST to enter name and surname and returns entered name and surname.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 28.12.2018.
 * @version 1.0.
 */
public class MemoryStore implements Store {

    /**
     * @param users - link variable to object of class ArrayList.
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
    public User add(User user) {
        user.setId(this.generateId());
        this.users.add(user);
        return user;
    }

    /**
     * update - update user by id.
     * @param user - user.
     */
    @Override
    public void update(User user) {
        User result = this.users.stream().
                filter(item -> item.getId().equals(user.getId())).
                findFirst().get();
        result =


        /*
        for (User item : this.users) {
            if (item.getId() == user.getId()) {
                item = user;
            }

        }
        */

    }

    /**
     * findById - finds user by id.
     * @param id - user id.
     * @return - returns user id.
     */
    public User findById(String id) {
        return this.users.stream().filter(item -> id.equals(item.getId())).findFirst().get();
    }

    /**
     * delete - delete user by id.
     * @param id - user id.
     */
    @Override
    public void delete(String id) {

    }

    /**
     *
     * @return - returns user id.
     */
    private String generateId() {
        return String.valueOf(this.id++);

    }
}
