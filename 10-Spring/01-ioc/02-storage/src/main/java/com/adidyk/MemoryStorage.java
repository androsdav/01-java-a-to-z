package com.adidyk;

import java.util.List;

/**
 * Interface Storage defines next method for container of users: add.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class MemoryStorage implements StorageDAO {

    /**
     * add - adds user.
     * @param user - user (link variable to object of class User).
     * @return - returns user.
     */
    @Override
    public void addUser(User user) {
        System.out.println("memory storage");
    }

    /**
     *
     * @param id - id user.
     * @return
     */
    @Override
    public User searchUserById(String id) {
        return null;
    }

    /**
     *
     * @param user - user.
     * @return
     */
    @Override
    public void updateUserById(User user) {
    }

    /**
     *
     * @param id
     */
    @Override
    public void removeUserById(String id) {

    }

    @Override
    public List getAllUser() {
        return null;
    }

    @Override
    public List<User> getAllUserByLogin(String login) {
        return null;
    }

    /**
     * @param name - name.
     * @return - return list.
     */
    @Override
    public List<User> getAllUserByName(String name) {
        return null;
    }

    /**
     * @param login - login.
     * @param name  - name.
     * @return - list.
     */
    @Override
    public List<User> getAllUserByLoginByName(String login, String name) {
        return null;
    }

}