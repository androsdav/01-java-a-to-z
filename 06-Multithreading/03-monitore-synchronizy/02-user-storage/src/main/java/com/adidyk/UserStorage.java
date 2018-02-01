package com.adidyk;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.Arrays;
import static java.lang.Math.round;

/** UserStorage class is container based on an array in which objects of class User are stored.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.07.2017.
 * @version 1.0.
 */
@ThreadSafe
public class UserStorage {

    /**
     * @param users - is reference variable to array.
     */
    @GuardedBy("this")
    private User[] users;

    /**
     * @param index - is index to cell of array.
     */
    @GuardedBy("this")
    private int index = 0;

    /**
     * UserStorage - constructor.
     */
    UserStorage() {
        this.users = new User[10];
    }

    /**
     * UserStorage - constructor.
     * @param size - is size of array.
     */
    UserStorage(int size) {
        this.users = new User[size];
    }

    /**
     * add - adds user to array.
     * @param user - is object of class User.
     * @return - returns true if user is added and returns false if user isn`t added.
     */
    synchronized boolean add(User user) {
        boolean isAdded = true;
        if (this.index == 0) {
            this.addObject(user);
        } else {
            isAdded = !this.searchDuplicate(user);
            if (isAdded) {
                this.addObject(user);
            }
        }
        return isAdded;
    }

    /**
     * update - update parameter (amount) for user by id.
     * @param user - is object user.
     * @return - returns true if user is updated and returns false if user in`t updated.
     */
    synchronized boolean update(User user) {
        boolean isUpdate = false;
        for (int index = 0; index < this.index; index++) {
            if (user.equals(this.users[index])) {
                this.users[index] = user;
                isUpdate = true;
                break;
            }
        }
        return isUpdate;
    }

    /**
     * transfer - transfers amount from one user another by id.
     * @param fromId - is Id.
     * @param toId - is Id.
     * @param amount - is amount.
     */
    synchronized void transfer(int fromId, int toId, int amount) {
        User  fromUser = null;
        User toUser = null;
        for (int index = 0; index < this.index; index++) {
            if (this.users[index].getId() == fromId) {
                fromUser = this.users[index];
            } else if (this.users[index].getId() == toId) {
                toUser = this.users[index];
            }
            if (fromUser != null && toUser != null) {
                fromUser.subAmount(amount);
                toUser.addAmount(amount);
                break;
            }
        }
    }

    /**
     * remove - deletes object by object from array of objects, and shifts array of objects to left by one position,
     * starting with the index of set object.
     * @param user - is object.
     * @return true.
     */
    synchronized boolean delete(User user) {
        boolean isDeleted = false;
        for (int index = 0; index < this.index; index++) {
            if (this.users[index].equals(user)) {
                System.arraycopy(this.users, index + 1, this.users, index, this.users.length - 1 - index);
                this.index--;
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    /**
     * addObject - adds object to Set-Array container.
     * @param user - is object.
     */
    private synchronized void addObject(User user) {
        if (this.index == this.users.length) {
            User[] usersTemp = new User[(int) round(1.5 * this.users.length)];
            System.arraycopy(this.users, 0, usersTemp, 0, this.users.length);
            this.users = usersTemp;
        }
        this.users[this.index++] = user;
    }

    /**
     * searchDuplicateByBinary - search duplicate by hash code and uses a binary search algorithm
     * and return true if object is duplicate in Set-Array, false - if object not duplicate in Set-Array.
     * @param user - is object.
     * @return true.
     */
    private synchronized boolean searchDuplicate(User user) {
        boolean duplicate = false;
        for (int index = 0; index < this.index; index++) {
            if (user.equals(this.users[index])) {
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }

    /**
     * get - returns object by index from array of objects.
     * @param index - is index.
     * @return - returns object.
     */
    synchronized User get(int index) {
        return this.users[index];
    }

    /**
     *
     * @return size.
     */
    synchronized int size() {
        return this.index;
    }

    /**
     * @return string.
     */
    @Override
    public synchronized String toString() {
        return String.format("%s%s%s%s%s%s", "UserStorage{", "objects=", Arrays.toString(users), ", index=", index, '}');
    }

}