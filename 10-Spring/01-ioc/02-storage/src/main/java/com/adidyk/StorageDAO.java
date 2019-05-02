package com.adidyk;

/**
 * Interface Storage defines next method for container of users: add.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public interface StorageDAO {

    /**
     * add - adds user to container.
     * @param user - user (link variable to object of class User).
     */
    User addUser(User user);

}