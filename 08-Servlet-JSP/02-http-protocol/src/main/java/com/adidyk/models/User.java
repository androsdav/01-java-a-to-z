package com.adidyk.models;

import java.util.Date;
import java.util.Objects;

/**
 * Class User for create object user with param: id, name, login, email, createDate.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 27.01.2019.
 * @version 1.0.
 */
public class User {

    /**
     * @param id - user id.
     */
    private String id;

    /**
     * @param name - name user.
     */
    private String name;

    /**
     * @param login - user login.
     */
    private String login;

    /**
     * @param email - user email.
     */
    private String email;

    /**
     * @param dateCreate - date create user.
     */
    private Date createDate;

    /**
     * User - constructor.
     * @param name - user name.
     * @param login - user login.
     * @param email - user email.
     * @param createDate - date create user.
     */
    public User(String name, String login, String email, Date createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    /**
     * setId - sets user id.
     * @param id - user id.
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
     * setEmail - sets user emIL.
     * @param email - user email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setCreateDate - sets create date user.
     * @param createDate - date create user.
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * getId - returns user id.
     * @return - returns user id.
     */
    public String getId() {
        return id;
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
     * getEmail - returns user email.
     * @return - returns user email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * getCreateDate - returns date create user.
     * @return - returns date create user.
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * equals - return boolean result.
     * @param obj - object of class User.
     * @return - returns boolean result "true" if name, login, email is same,
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
        return  Objects.equals(this.name, user.name) &&
                Objects.equals(this.login, user.login) &&
                Objects.equals(this.email, user.email);
    }

    /**
     * hashCode - returns hashCode for user.
     * @return - returns hashCode for user.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.login, this.email);
    }

    /**
     * toString - returns string format.
     * @return - returns all information for user.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s%s%s%s%s%s%s",
                "User{", "id=", this.id, ", name=", this.name, ", login=", this.login, ", email=",
                this.email, ", createDate=", this.createDate, "}");
    }

}