package com.adidyk;

import java.util.Iterator;

/**
 * Class SimpleHashMap for create structure HashTable by data key and value.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 30.08.2017.
 * @version 1.0.
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class SimpleHashMap<K,V> implements SimpleMap<K, V> {


    @Override
    public boolean put(K key, V value) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
