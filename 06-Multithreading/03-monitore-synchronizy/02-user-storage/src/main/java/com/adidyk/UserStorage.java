package com.adidyk;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.Arrays;
import static java.lang.Math.round;

/** UserStorage class is container based on an array in which objects of class User are stored.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.01.2018.
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
     * @return - returns true if user is updated and returns false if user isn`t updated.
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
     * @param fromId - is id of user who sends amount.
     * @param toId - is id of user who gets amount.
     * @param amount - is amount.
     */
    void transfer(int fromId, int toId, int amount) {
        User fromUser = this.searchUserById(fromId);
        User toUser = this.searchUserById(toId);
        if (fromUser != null && toUser != null) {
            if (fromUser.getId() < toUser.getId()) {
                synchronized (fromUser) {
                    synchronized (toUser) {
                        doTransfer(fromUser, toUser, amount);
                    }
                }
            } else {
                synchronized (toUser) {
                    synchronized (fromUser) {
                        doTransfer(fromUser, toUser, amount);
                    }
                }
            }
        }
    }



    /**
     * remove - deletes user by id from array, and shifts array of objects to left by one position,
     * starting with the index of object.
     * @param user - is object user.
     * @return - returns true if user is deleted and returns false if user  isn`t deleted.
     */
    synchronized boolean delete(User user) {
        boolean isDeleted = false;
        for (int index = 0; index < this.index; index++) {
            if (user.equals(this.users[index])) {
                System.arraycopy(this.users, index + 1, this.users, index, this.users.length - 1 - index);
                this.index--;
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    /**
     * addObject - adds user to array.
     * @param user - is object of class User.
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
     * searchDuplicate - search duplicate by user in array.
     * @param user - is object of class User.
     * @return - returns true if array contains entered user and returns false if array does not entered user.
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
     * searchUserById - searches user by id in array.
     * @param id - user id.
     * @return - returns user by id.
     */
    private User searchUserById(int id) {
        User user = null;
        synchronized (this) {
            for (int index = 0; index < this.index; index++) {
                if (this.users[index].getId() == id) {
                    user = this.users[index];
                    break;
                }
            }
        }
        return user;
    }

    /**
     * doTransfer - transfers amount from one user another.
     * @param fromUser - user who sends amount.
     * @param toUser - user who gets amount.
     * @param amount - is amount.
     */
    private void doTransfer(User fromUser, User toUser, int amount) {
        fromUser.subAmount(amount);
        toUser.addAmount(amount);
    }

    /**
     * get - returns object by index from array of objects.
     * @param index - is index.
     * @return - returns object by index from array of objects.
     */
    synchronized User get(int index) {
        return this.users[index];
    }

    /**
     * size - returns numbers of elements in array.
     * @return - returns numbers of elements in array.
     */
    synchronized int size() {
        return this.index;
    }

    /**
     * equals - returns boolean result.
     * @param obj - object of class UserStorage.
     * @return - returns boolean result "true" or "false".
     */
    @Override
    public synchronized boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserStorage that = (UserStorage) obj;
        return Arrays.equals(users, that.users);
    }

    /**
     * hashCode - returns hashCode for UserStorage.
     * @return - returns hashCode for UserStorage.
     */
    @Override
    public synchronized int hashCode() {
        return Arrays.hashCode(users);
    }

    /**
     * toString - returns string format.
     * @return - returns all information for UserStorage.
     */
    @Override
    public synchronized String toString() {
        return String.format("%s%s%s%s%s%s", "UserStorage{", "objects=", Arrays.toString(users), ", index=", index, '}');
    }

}