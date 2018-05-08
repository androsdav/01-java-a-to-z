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
     *
     * add - is add.
     */
    public void add(K key, V value) {
        this.map.put(key, value);

    }

    /**
     *
     * @param key - is key.
     * @param value - is value.
     */
    public void update(K key, V value) {

    }

    /**
     * today a do not write anething kodeblock.
     * @param key - is key.
     */
    public void delete(K key) {
        this.map.remove(key);
    }

}
