package com.adidyk;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @param <Integer> - is.
 * @param <User> - is.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 05.05.2018.
 * @version 1.0.
 */
public class Cache<Integer, User> {

    /**
     * @param map - is.
     */
    private ConcurrentHashMap<Integer, User> map = new ConcurrentHashMap<>();

    /**
     * @param key - is key.
     * @param value - is value.
     * add - is add.
     * @return - true.
     */
    boolean add(Integer key, User value) {
        boolean result = false;
        if (!this.map.containsKey(key)) {
            this.map.put(key, value);
            result = true;
        }
        return result;
    }

    /**
     *
     * @param key - is key.
     * @return - is.
     */
    public boolean update(Integer key) {
        boolean result = false;
        if (this.map.containsKey(key)) {
            //User user = this.map.get(key);
            //user.
            //user.
            result = true;
        }
        //User user = this.map.get(key);
        //user.
        //User user = this.get(key);
        //user.setRole();
        return result;


        //if (this.map.containsKey(key)) {
        //    this.map.put(key, value);

        //}

    }

    /**
     * today a do not write anething kodeblock.
     * @param key - is key.
     * @return - is.
     */
    boolean delete(Integer key) {
        boolean result = false;
        if (this.map.containsKey(key)) {
            this.map.remove(key);
            result = true;
        }
        return result;
    }

    /**
     * @param key - is key.
     * @return resuult.
     */
    User get(Integer key) {
        User result = null;
        if (this.map.containsKey(key)) {
            result = this.map.get(key);
        }
        return result;
    }

    /**
     *
     * @return - is.
     */
    ConcurrentHashMap<Integer, User> getAll() {
        return this.map;
    }

}