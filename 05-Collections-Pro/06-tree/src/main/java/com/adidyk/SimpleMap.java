package com.adidyk;

/**
 * Interface SimpleMap for create structure HashTable by data key and value.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 30.08.2017.
 * @version 1.0.
 * @param <K> the type of keys maintained by this map.
 * @param <V> the type of mapped values.
 */
public interface SimpleMap<K, V> extends Iterable<K> {

    /**
     * @param key - is generic type <K>.
     * @param value - is generic type <V>.
     * @return V -  generic type.
     */
    V put(K key, V value);

    /**
     * @param key its class K.
     * @return V generic type.
     */
    V get(K key);

    /**
     * @param key - is generic type <K>.
     * @return V - generic type.
     */
    V remove(K key);

}