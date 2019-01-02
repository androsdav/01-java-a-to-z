package com.adidyk.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class MemoryStore uses form and method POST to enter name and surname and returns entered name and surname.
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
        for (int index = 0; index < this.users.size(); index++) {
            if (user.getId().equals(this.users.get(index).getId())) {
                this.users.set(index, user);
                break;
            }
        }
    }

    /**
     * delete - delete user by id.
     * @param id - user id.
     */
    @Override
    public String delete(String id) {
        for (int index = 0; index < this.users.size(); index++) {
            if (id.equals(this.users.get(index).getId())) {
                this.users.remove(index);
                break;
            }
        }
        return id;
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
     *
     * @return - is.
     */
    public List<User> findAll() {
        return this.users;
    }

    /**
     *
     * @return - returns user id.
     */
    private String generateId() {
        return String.valueOf(this.id++);
    }

}