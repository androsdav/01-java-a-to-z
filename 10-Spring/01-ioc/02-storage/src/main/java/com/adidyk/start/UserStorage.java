package com.adidyk.start;

import com.adidyk.models.User;
import com.adidyk.start.StorageDAO;

import java.util.List;

/**
 * Class UserStorage defines next method for container of users: add.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class UserStorage {

    /**
     * @param storage - storage (link variable to object of interface Storage).
     */
    private final StorageDAO storage;

    /**
     * UserStorage - constructor.
     * @param storage - storage (link variable to object of interface Storage).
     */
    public UserStorage(StorageDAO storage) {
        this.storage = storage;
    }

    /**
     * add - adds user to container.
     * @param user - user (link variable to object of class User).
     */
    void addUser(User user) {
        this.storage.addUser(user);
    }

    /**
     *
     * @param id
     * @return
     */
    User getUserById(String id) {
        return this.storage.searchUserById(id);
    }

    /**
     *
     * @param user - user.
     */
    void updateUserById(User user) {
        this.storage.updateUserById(user);
    }

    /**
     *
     * @param id - id.
     */
    void removeUserById(String id) {
        this.storage.removeUserById(id);
    }

    /**
     *
     * @return - return.
     */
    List<User> getAllUser() {
        return this.storage.getAllUser();
    }

    /**
     *
     * @param login - login.
     * @return - return - login.
     */
    List<User> getAllUserByLogin(String login) {
        return this.storage.getAllUserByLogin(login);
    }

    /**
     *
     * @param name - name.
     * @return - name.
     */
    List<User> getAllUserByName(String name) {
        return this.storage.getAllUserByName(name);
    }

    /**
     *
     * @param login - login.
     * @param name - name.
     * @return - list.
     */
    public List<User> getAllUserByLoginByName(String login, String name) {
        return this.storage.getAllUserByLoginByName(login, name);
    }

}