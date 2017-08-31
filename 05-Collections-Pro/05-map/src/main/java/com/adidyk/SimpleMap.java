package com.adidyk;

/**
 * Interface SimpleMap for create structure HashTable by data key and value.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 30.08.2017.
 * @version 1.0.
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public interface SimpleMap<K, V> extends Iterable<K> {

    /**
     * @param key its class K.
     * @param value its class V.
     * @return true or false.
     */
    V put(K key, V value);

    /**
     * @param key its class K.
     * @return V its class.
     */
    V get(K key);

    /**
     * @param key its class K.
     * @return V its class.
     */
    boolean remove(K key);

}
