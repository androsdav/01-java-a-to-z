package com.adidyk;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class User for create user (object) with params: id, name, age.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
@ThreadSafe
public class User {

    /**
     * @param id - user id.
     */
    @GuardedBy("this")
    private final String id;

    /**
     * @param name - user name.
     */
    @GuardedBy("this")
    private String name;

    /**
     * @param age - user age.
     */
    @GuardedBy("this")
    private int age;

    /**
     * User - constructor.
     * @param id - user id.
     * @param name - user name.
     * @param age - user age.
     */
    User(final String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * setName - sets name for user.
     * @param name - user name.
     */
    synchronized void setName(String name) {
        this.name = name;
    }

    /**
     * setAge - sets age for user.
     * @param age - user age.
     */
    synchronized void setAge(int age) {
        this.age = age;
    }

    /**
     * getId - returns id for user.
     * @return - returns id for user.
     */
    synchronized String getId() {
        return this.id;
    }

    /**
     * getName - returns name for user.
     * @return - returns name for user.
     */
    synchronized String getName() {
        return this.name;
    }

    /**
     * getAge - returns age for user.
     * @return - returns age for user.
     */
    synchronized int getAge() {
        return this.age;
    }

    /**
     * equals - return boolean result.
     * @param obj - object of class User.
     * @return - returns boolean result "true" if id of user is same, and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return getId().equals(user.getId());
    }

    /**
     * hashCode - returns hashCode for user.
     * @return - returns hashCode for user.
     */
    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    /**
     * toString - returns string format.
     * @return - returns all information for user.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s%s%s",
                " User {", "id=", this.getId(), "; name=", this.getName(), "; age=", this.getAge(), "}");
    }

}