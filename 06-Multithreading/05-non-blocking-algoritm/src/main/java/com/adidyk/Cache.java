package com.adidyk;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class Cache is container for storing models using non-blocking algorithms.
 * Container built using ConcurrentHashMap.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 05.05.2018.
 * @version 1.0.
 */
class Cache {

    /**
     * @param cache - is link variable to object of class ConcurrentHashMap (container).
     */
    private Map<Integer, User> cache = new ConcurrentHashMap<>();

    /**
     * add - adds user to container by key (where key is id user).
     * User added to container if container do not has input key, and
     * user not added to container if container has input key.
     * @param user - link variable to object of class User.
     * @return - returns added user if container not has input key or
     * returns user from container by key if container has inputted key.
     */
    User add(User user) {
        return cache.computeIfAbsent(user.getId(), key -> user);
    }

    /**
     * update - update user role by key, if container has input key (where key is id user).
     * @param user - is link variable to object of class User.
     * @return - returns true if user update role, returns false if user not update role..
     */
    boolean update(User user) {
        boolean result = false;
        //User temp = this.cache.get(user.getId());
        //User oldUser = new User(temp.getId(), temp.getName(), temp.getRole());
        //oldUser.setRole(temp.getRole());
        User newRole = this.cache.computeIfPresent(user.getId(), (key, value) -> {
            if (this.cache.containsKey(user.getId())) {
                int version = this.cache.get(user.getId()).getVersion();
                if (version == this.cache.get(user.getId()).getVersion()) {
                    this.cache.get(user.getId()).setRole(user.getRole());
                } else {
                    throw new OptimisticException("optimistic exception");
                }
            }


            /*
            if (this.cache.containsKey(user.getId())) {
                User oldUser = new User(this.cache.get(user.getId()).getId(), this.cache.get(user.getId()).getName(),
                        this.cache.get(user.getId()).getRole());
                oldUser.setVersion(this.cache.get(user.getId()).getVersion());
                //System.out.println(oldUser);
                //System.out.println(this.cache.get(user.getId()));
                //int version = this.cache.get(user.getId()).getVersion();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (oldUser.getVersion() == this.cache.get(user.getId()).getVersion()) {
                    this.cache.get(user.getId()).setRole(user.getRole());
                } else {
                    throw new OptimisticException("optimistic exception");
                }
            }
            */

            return value;
        });
        if (newRole != null) {
            result = true;
        }
        return result;
    }

    /**
     * update - update user role by key, if container has input key (where key is id user).
     * @param user - is link variable to object of class User.
     * @return - returns true if user update role, returns false if user not update role..
     */
    boolean updateNew(User user) {
        boolean result = false;
        if (this.cache.containsKey(user.getId())) {
            int version = this.cache.get(user.getId()).getVersion();
            if (version == this.cache.get(user.getId()).getVersion()) {
                this.cache.get(user.getId()).setRole(user.getRole());
            } else {
                throw new OptimisticException("optimistic exception");
            }
            result = true;
        }
        return result;
        /*
        boolean result = false;
        if (this.cache.containsKey(user.getId())) {
            User oldUser = new User(this.cache.get(user.getId()).getId(), this.cache.get(user.getId()).getName(),
                    this.cache.get(user.getId()).getRole());
            oldUser.setVersion(this.cache.get(user.getId()).getVersion());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (oldUser.getVersion() == this.cache.get(user.getId()).getVersion()) {
                this.cache.get(user.getId()).setRole(user.getRole());
                result = true;
            } else {
                throw new OptimisticException("optimistic exception");
            }
        }
        return result;
        */
    }

    /*
        /**
     * update - update user role by key, if container has input key (where key is id user).
     * @param user - is link variable to object of class User.
     * @return - returns true if user update role, returns false if user not update role..
     */
    /*
    boolean update(User user) {
        boolean result = false;
        if (this.cache.containsKey(user.getId())) {
            int version = this.cache.get(user.getId()).getVersion();
            if (version == this.cache.get(user.getId()).getVersion()) {
                this.cache.get(user.getId()).setRole(user.getRole());
            } else {
                throw new OptimisticException("optimistic exception");
            }
            result = true;
        }
        return result;
    }
    */

    /**
     * delete - removes user from container by key (where key is id user) if
     * container has key.
     * @param user - is link variable to object of class user.
     * @return - returns true if user remove, returns false if user not remove.
     */
    boolean delete(User user) {
        return cache.remove(user.getId(), user);
    }

    /**
     * get - gets user by key (where key is user id).
     * @param key - is id user.
     * @return - returns user from container if key is true or returns null if
     * container not has key.
     */
    User get(Integer key) {
        User result = null;
        if (this.cache.containsKey(key)) {
            result = this.cache.get(key);
        }
        return result;
    }

}