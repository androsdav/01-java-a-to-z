package com.adidyk;

import java.util.Calendar;

/**
 * Class USer for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
*/
class User {

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
    String getNAme() {
        return this.name;
    }
    /**
     * @return int this.children - number of children of user.
    **/
    int getChildren() {
        return this.children;
    }

    /**
     * @return this.birthday - user birthday.
     */
    Calendar getBirthday() {
        return this.birthday;
    }

    /**
     * @return int result - hashCode for user.
     **/
    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + this.children;
        result = 31 * result + (this.birthday != null ? this.birthday.hashCode() : 0);
        return result;
    }

}