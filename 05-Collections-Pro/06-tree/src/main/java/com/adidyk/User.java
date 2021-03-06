package com.adidyk;

import java.util.Calendar;

/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
*/
class User implements Comparable<User> {

    /**
     * name - name user.
     */
    private String name;

    /**
     * children - number of children for the user.
     */
    private int children;

    /**
     * birthday - user birthday.
     **/
    private Calendar birthday;

    /**
     * @param name name user.
     * @param children number of children for the user.
     * @param birthday user birthday.
     **/
    User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * setName - sets name for user.
     * @param name name user.
     **/
    void setName(String name) {
        this.name = name;
    }

    /**
     * setChildren - sets number children for the user.
     * @param children number of children for the user.
     **/
    void setChildren(int children) {
        this.children = children;
    }

    /**
     * setBirthday - sets user birthday.
     * @param birthday user birthday.
     **/
    void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    /**
     * @return String this.name - name user.
     */
    String getName() {
        return this.name;
    }

    /**
     * @return returns children - number of children of user.
    **/
    int getChildren() {
        return this.children;
    }

    /**
     * @return returns birthday - user birthday.
     */
    Calendar getBirthday() {
        return this.birthday;
    }

    /**
     * @return returns hashCode for user.
     **/
    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + this.children;
        result = 31 * result + (this.birthday != null ? this.birthday.hashCode() : 0);
        return result;
    }

    /**
     * @return boolean result - return "true" if name and number of children and birthday
     * users is same, and return "false" if all params users isn`t same.
     **/
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User user = (User) obj;
        return this.name.equals(user.name) && this.children == user.children && this.birthday.equals(user.birthday);
    }

    /**
     * @return all param for User
     */
    @Override
    public String toString() {
        return String.format("%s", this.name);
    }

    /**
     * @param user - is user.
     * @return returns 0 or 1 or -1.
     */
    @Override
    public int compareTo(User user) {
        int result = this.name.compareTo(user.name);
        if (result != 0) {
            return result;
        }
        result = Integer.compare(this.children, user.children);
        if (result != 0) {
            return result;
        }
        result = this.birthday.compareTo(user.birthday);
        return result;
    }

}