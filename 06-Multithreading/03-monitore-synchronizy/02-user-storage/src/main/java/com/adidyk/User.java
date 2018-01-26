package com.adidyk;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/** Class User for create user (object) with params: id, amount.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.07.2017.
 * @version 1.0.
*/
@ThreadSafe
public class User {

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
     * @param id - user ud.
     */
    public  synchronized void setId(int id) {
        this.id = id;
    }

    /**
     * setAmount - sets amount for user.
     * @param amount - user amount.
     */
    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * getId - get id for user.
     * @return - returns id for user.
     */
    public synchronized int getid() {
        return this.id;
    }

    /**
     * getAmount - gets amount for user.
     * @return - returns amount for user.
     */
    public synchronized int getAmount() {
        return this.amount;
    }

}