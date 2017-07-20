package com.adidyk;

import java.util.Calendar;

/**
 * Its my first JavaDoc. I like java codding
 * everyday and all
 * day.
 */
class User {

    /**
     *
     */
    private String name;
    /**
     *
     */
    private int children;
    /**
     *
     */
    private Calendar birthday;

    /**
     * @param name 1
     * @param children 1
     * @param birthday 1
     */
    User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * @param name 1
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * @param children 1
     */
    void setChildren(int children) {
        this.children = children;
    }

    /**
     * @param birthday 1
     */
    void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    /**
     * @return 1
     */
    String getNAme() {
        return this.name;
    }

    /**
     * @return 1
     */
    int getChildren() {
        return this.children;
    }

    /**
     * @return 1
     */
    Calendar getBirthday() {
        return this.birthday;
    }

    /**
     * @return 1
     */
    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + this.children;
        result = 31 * result + (this.birthday != null ? this.birthday.hashCode() : 0);
        return result;
    }

}