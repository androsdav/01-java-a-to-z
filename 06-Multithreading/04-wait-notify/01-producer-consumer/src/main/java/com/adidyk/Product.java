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
public class Product {

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
     * User - constructor.
     * @param id - user id.
     * @param name - user name.
     */
    Product(final String id, String name) {
        this.id = id;
        this.name = name;
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
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return this.id.equals(product.id) && this.name.equals(product.name);
    }

    /**
     * hashCode - returns hashCode for user.
     * @return - returns hashCode for user.
     */
    @Override
    public int hashCode() {
        int result = this.id.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for user.
     */
    @Override
    public synchronized String toString() {
        return String.format("%s%s%s%s%s%s", " Product {", "id=", this.id, "; name=", this.name, "}");
    }

}