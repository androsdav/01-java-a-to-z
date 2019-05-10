package com.adidyk.start;

import com.adidyk.models.User;

import java.util.List;

/**
 * Interface Storage defines next method for container of users: add.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public interface StorageDAO {

    /**
     * addUser - adds user to container.
     * @param user - user (link variable to object of class User).
     */
    void addUser(User user);

    /**
     *
     * @param id - id user.
     * @return - returns user by id.
     */
    User searchUserById(String id);

    /**
     *
     * @param user - user.
     */
    void updateUserById(User user);

    /**
     *
     * @param id - id.
     */
    void removeUserById(String id);

    /**
     * getAllUser - gets all users from users table.
     * @return
     */
    List<User> getAllUser();

    /**
     *
     * @return - list.
     */
    List<User> getAllUserByLogin(String login);

    /**
     *
     * @param name - name.
     * @return - return list.
     */
    List<User> getAllUserByName(String name);

    /**
     *
     * @param login - login.
     * @param name - name.
     * @return - list.
     */
    List<User> getAllUserByLoginByName(String login, String name);

}