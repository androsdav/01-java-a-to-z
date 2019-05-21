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
    int addUser(User user);

    /**
     *
     * @param id - id user.
     * @return - returns user by id.
     */
    User searchUserById(String id);

    /**
     *
     * @param user - name.
     * @return - return list.
     */
    List<User> searchUserByName(User user);

    /**
     *
     * @return - list.
     */
    List<User> searchUserByLogin(User user);

    /**
     *
     * @param user - login.
     * @return - list.
     */
    List<User> searchUserByLoginByName(User user);

    /**
     *
     * @param user - user.
     */
    int updateUserById(User user);

    /**
     *
     * @param id - id.
     */
    int removeUserById(String id);

    /**
     * getAllUser - gets all users from users table.
     * @return
     */
    List<User> getAllUser();



}