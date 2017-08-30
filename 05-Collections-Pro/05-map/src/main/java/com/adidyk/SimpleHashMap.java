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
public class SimpleHashMap<K, V> implements SimpleMap<K, V> {

    /**
     *  @param table its array
     */
    private Node<K, V>[] table;

    /**
     * @param size size
     */
    private int size = 12;

    /**
     * its constructor.
     */
    SimpleHashMap() {
        this.table = (Node<K, V>[]) new Node[12];
        Node<K,V>[] newTab = (Node<K,V>[])new Node[this.size];
    }

    /**
     * @param key its class K.
     * @param value its class V.
     * @return true or false.
     */
    @Override
    public boolean put(K key, V value) {
        int hash = this.hash(key);
        int bucket = this.bucket(hash);
        if (this.table[bucket] != null) {
            Node oldNode = this.table[bucket];
            Node<K, V> newNode = new Node<>(hash, key, value, oldNode);
        }
        //Node<K, V> newNode = new Node<>(hash, key, value);
        //this.table[bucket] = newNode;
        return false;
    }

    /**
     * @param key key.
     *  @return hash code.
     */
    private int hash(K key) {
        int h;
        if (key == null) {
            h = 0;
        } else {
            h = key.hashCode() ^ (key.hashCode() >>> 16);
        }
        return h;
    }

    /**
     * @param hash hash.
     * @return bucket
     */
    private int bucket(int hash) {
        return hash & (this.table.length - 1);
    }

    /**
     * @param key its class K.
     * @return V its class.
     */
    @Override
    public V get(K key) {
        return null;
    }

    /**
     * @param key its class K.
     * @return V its class.
     */
    @Override
    public boolean remove(K key) {
        return false;
    }

    /**
     * @return V its class.
     */
    @Override
    public Iterator<K> iterator() {
        return null;
    }

    /**
     * its class Node.
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     */
    private static class Node<K, V> {

        /**
         * @param hash
         */
        private int hash;

        /**
         * @param key
         */
        private K key;

        /**
         * @param value
         */
        private V value;

        /**
         * @param next
         */
        private Node<K, V> next;

        /**
         * its constructor.
         * @param hash key.
         * @param key key.
         * @param value key.
         * @param next next.
         */
        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }

}