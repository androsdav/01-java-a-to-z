package com.adidyk.start;

import com.adidyk.models.User;
import java.util.List;

/**
 * Interface Storage defines next method for container of users:
 * addUser, searchUserById,searchUserByName, searchUserByLogin, searchUserByLoginByName updateUserById removeUserById,
 * updateUserById, removeUserById, getAllUser.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public interface StorageDAO {

    /**
     * addUser - adds new user to storage.
     * @param user - user (link variable to object of class User).
     */
    int addUser(User user);

    /**
     * searchUserById - searches user in storage by id and returns user.
     * @param id - user id.
     * @return - returns user.
     */
    User searchUserById(String id);

    /**
     * searchUserByName - searches user in storage by name and return list users.
     * @param user - user (link variable to object of class User).
     * @return - returns list users.
     */
    List<User> searchUserByName(User user);

    /**
     * searchUserByLogin - searches user in storage by login and returns list users.
     * @return - returns list users.
     */
    List<User> searchUserByLogin(User user);

    /**
     * searchUserByLoginByName - searches user in storage by login and by name and
     * returns list users.
     * @param user - user (link variable to object of class User).
     * @return - list users.
     */
    List<User> searchUserByLoginByName(User user);

    /**
     * updateUserById - update user in storage by id and return int.
     * @param user - user (link variable to objct of class User).
     * @return - returns int.
     */
    int updateUserById(User user);

    /**
     * removeUserById - remove user in storage by id and return int.
     * @param id - user id.
     * @return - returns int.
     */
    int removeUserById(String id);

    /**
     * getAllUser - gets all users from storage.
     * @return - returns all users from storage
     */
    List<User> getAllUser();

}