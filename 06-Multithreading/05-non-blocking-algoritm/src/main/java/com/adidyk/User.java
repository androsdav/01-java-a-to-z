package com.adidyk;

/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
*/
class User {

    /**
     * @param id - is id.
     */
    private int id;

    /**
     * @param name - name user.
     */
    private String name;

    /**
     * @param id - number of children for the user.
     */
    private String role;

    /**
     * @param version - is version.
     */
    private volatile int version;

    /**
     * @param id - name user.
     * @param name -  name user.
     * @param role - name user.
     **/
    User(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    /**
     *
     * @param role - is role.
     */
    synchronized void setRole(String role) {
        this.role = role;
        this.version++;
    }

    /**
     *
     * @param version - is version.
     */
    synchronized void setVersion(int version) {
        this.version = version;
    }

    /**
     *
     * @return - is.
     */
    synchronized int getId() {
        return id;
    }

    /**
     *
     * @return - is.
     */
    synchronized String getName() {
        return this.name;
    }

    /**
     *
     * @return - is.
     */
    synchronized String getRole() {
        return this.role;
    }

    /**
     *
     * @return - is.
     */
    synchronized int getVersion() {
        return this.version;
    }

    /**
     *
     * @param o - is object.
     * @return - returns.
     */
    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    /**
     *
     * @return - is returns id.
     */
    @Override
    public synchronized int hashCode() {
        return id;
    }

    /**
     *
     * @return - is.
     */
    @Override
    public synchronized String toString() {
        return String.format("%s%s%s%s%s%s%s%s%s%s%s", "User{", "id=", this.id, ", name=", this.name, ", ",
                "role=", this.role, ", version=", this.version, "}");
    }
}