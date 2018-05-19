package com.adidyk;

/**
 * Class User for create user (object) with params: id, name, role and version.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
*/
class User {

    /**
     * @param id - user id.
     */
    private int id;

    /**
     * @param name - name user.
     */
    private String name;

    /**
     * @param role - user role.
     */
    private String role;

    /**
     * @param version - user version.
     */
    private volatile int version;

    /**
     * User - constructor.
     * @param id - user id.
     * @param name -  user name.
     * @param role - user role.
     **/
    User(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    /**
     * setRole - sets role for user and change role.
     * @param role - user role.
     */
    synchronized void setRole(String role) {
        this.role = role;
        this.version++;
    }

    /**
     * setVersion - sets version for user.
     * @param version - is version.
     */
    synchronized void setVersion(int version) {
        this.version = version;
    }

    /**
     * getId - returns id for user.
     * @return - returns id for user.
     */
    synchronized int getId() {
        return id;
    }

    /**
     * getName - returns name for user.
     * @return - returns name for user.
     */
    synchronized String getName() {
        return this.name;
    }

    /**
     * getRole - returns role for user.
     * @return - returns role for user.
     */
    synchronized String getRole() {
        return this.role;
    }

    /**
     * getVersion - returns version for user.
     * @return - returns version for user.
     */
    synchronized int getVersion() {
        return this.version;
    }

    /**
     * equals - return boolean result.
     * @param obj - object of class User.
     * @return - returns boolean result "true" if id of user is same, and returns "false" - isn`t same.
     */
    @Override
    public synchronized boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return id == user.id;
    }

    /**
     * hashCode - returns hashCode for user.
     * @return - returns hashCode for user.
     */
    @Override
    public synchronized int hashCode() {
        return id;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for user.
     */
    @Override
    public synchronized String toString() {
        return String.format("%s%s%s%s%s%s%s%s%s%s%s", "User{", "id=", this.id, ", name=", this.name, ", ",
                "role=", this.role, ", version=", this.version, "}");
    }

}