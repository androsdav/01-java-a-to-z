package com.adidyk;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/** Class User for create user (object) with params: id, amount.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.01.2018.
 * @version 1.0.
*/
@ThreadSafe
class User {

    /**
     * @param id - user id.
     */
    @GuardedBy("this")
    private int id;

    /**
     * @param amount - user amount.
     */
    @GuardedBy("this")
    private int amount;

    /**
     * User - constructor.
     * @param id - user id.
     * @param amount - user amount.
     */
    User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * setId - sets id for user.
     * @param id - user id.
     */
    synchronized void setId(int id) {
        this.id = id;
    }

    /**
     * setAmount - sets amount for user.
     * @param amount - user amount.
     */
    synchronized void addAmount(int amount) {
        this.amount = this.amount + amount;
    }

    /**
     * subAmount - sets amount for user.
     * @param amount - is amount.
     */
    synchronized void subAmount(int amount) {
        this.amount = this.amount - amount;
    }

    /**
     * getId - get id for user.
     * @return - returns id for user.
     */
    synchronized int getId() {
        return this.id;
    }

    /**
     * getAmount - gets amount for user.
     * @return - returns amount for user.
     */
    synchronized int getAmount() {
        return this.amount;
    }

    /**
     * equals - return boolean result.
     * @param obj - object of class User.
     * @return - returns boolean result "true" if id of user is same, and  returns "false" - isn`t same.
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
        return this.getId() == user.getId();
    }

    /**
     * hashCode - returns hashCode for user.
     * @return - returns hashCode for user.
     */
    @Override
    public synchronized int hashCode() {
        return this.getId();
    }

    /**
     * toString - returns string format.
     * @return - returns all information for user.
     */
    @Override
    public synchronized String toString() {
        return String.format("%s%s%s%s%s%s", "User{", "id=", this.id, ", amount=", this.amount, '}');
    }

}