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
     * addUser - adds new user to users table in database base_storage.
     * @param user - user (link variable to object of class User).
     */
    int addUser(User user);

    /**
     * searchUserById - searches user in user by id.
     * and returns user if search result true and returns EmptyResultDataAccessException if search result false.
     * @param id - user id.
     * @return - returns user if search result true and returns EmptyResultDataAccessException if search result false.
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