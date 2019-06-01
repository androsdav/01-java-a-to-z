package com.adidyk.models;

import java.util.Objects;

/**
 * Class User for create object user with param: name, login.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class User {

    /**
     * @param id - id user.
     */
    private String id;
    /**
     * @param name - user name.
     */
    private String name;

    /**
     * @param login - user login.
     */
    private String login;

    /**
     * User - constructor.
     * @param name - user name.
     * @param login - user login.
     */
    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }

    /**
     * setId - sets id user.
     * @param id - id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * setName - sets user name.
     * @param name - user name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setLogin - sets user login.
     * @param login - user login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * getId - returns user id.
     * @return - returns user id.
     */
    public String getId() {
        return this.id;
    }
    /**
     * getName - returns user name.
     * @return - returns user name.
     */
    public String getName() {
        return name;
    }

    /**
     * getLogin - returns user login.
     * @return - returns user login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * equals - return boolean result.
     * @param obj - object of class User.
     * @return - returns boolean result "true" if name, login is same,
     * and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(this.name, user.name) && Objects.equals(this.login, user.login);
    }

    /**
     * hashCode - returns hashCode for user.
     * @return - returns hashCode for user.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.login);
    }

    /**
     * toString - returns string format.
     * @return - returns all information for user.
     */
    @Override
    public String toString() {
        return String.format(" %s%7s%2s %-28s%2s %-35s%2s", "|", this.getId(), "|", this.getLogin(), "|",this.getName(), "|");
    }

}