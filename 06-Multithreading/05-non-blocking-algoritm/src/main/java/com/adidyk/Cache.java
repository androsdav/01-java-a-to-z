package com.adidyk;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @param <K> - is key.
 * @param <V> - is value.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 05.05.2018.
 * @version 1.0.
 */
public class Cache<K, V> {

    /**
     * @param map - is.
     */
    private ConcurrentHashMap<K, V> map = new ConcurrentHashMap<>();

    /**
     * @param key - is key.
     * @param value - is value.
     * add - is add.
     * @return - true.
     */
    boolean add(K key, V value) {
        boolean result = true;
        if (this.map.containsKey(key)) {
            result = false;

        } else {
            this.map.put(key, value);
        }
        return result;
    }

    /**
     *
     * @param key - is key.
     * @param value - is value.
     */
    public void update(K key, V value) {
        if (this.map.containsKey(key)) {
            this.map.put(key, value);

        }

    }

    /**
     * today a do not write anething kodeblock.
     * @param key - is key.
     */
    public void delete(K key) {
        this.map.remove(key);
    }

    /**
     * @return resuult.
     */
    V get() {
        V result = null;
        if (this.map.put()) {

        }
        return result;
    }

    /**
     *
     * @return - is.
     */
    ConcurrentHashMap<K, V> getAll() {
        return this.map;
    }

}
