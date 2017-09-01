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
    private int size;

    /**
     * its constructor.
     */
    SimpleHashMap() {
        this.table = (Node<K, V>[]) new Node[12];
    }

    /**
     * @param key its class K.
     * @param value its class V.
     * @return true or false.
     */
    @Override
    public V put(K key, V value) {
        V result = null;
        int hash = this.hash(key);
        int bucket = this.bucket(hash);
        if (this.table[bucket] != null) {
            Node<K, V> firstNode = this.table[bucket];
            Node<K, V> item = this.searchKey(firstNode, key);
            if (item != null) {
                result = item.value;
                item.value = value;
            } else {
                Node<K, V> oldNode = this.table[bucket];
                Node<K, V> newNode = new Node<>(hash, key, value, oldNode);
                this.table[bucket] = newNode;
            }
        } else {
            Node<K, V> newNode = new Node<>(hash, key, value, null);
            this.table[bucket] = newNode;
        }
        this.size++;
        return result;
    }

    /**
     * @param firstNode ist node
     * @param key key
     * @return key
     */
    private Node<K, V> searchKey(Node<K, V> firstNode, K key) {
        Node<K, V> result = null;
        for (Node<K, V> item = firstNode; item != null; item = item.next) {
            if (item.hash == this.hash(key) && key.equals(item.key)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * @param key key.
     *  @return hash code.
     */
    private int hash(K key) {
        int hash;
        if (key == null) {
            hash = 0;
        } else {
            hash = key.hashCode() ^ (key.hashCode() >>> 16);
        }
        return hash;
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
        V result = null;
        boolean resultTrue = false;
        for (int bucket = 0; bucket < this.table.length; bucket++) {
            if (this.table[bucket] != null) {
                Node<K, V> item = this.searchKey(this.table[bucket], key);
            }
            Node<V, K> item =

            /*
            if (aTable != null) {
                for (Node<K, V> item = aTable; item != null; item = item.next) {
                    if (item.hash == this.hash(key) && key.equals(item.key)) {
                        result = item.value;
                        resultTrue = true;
                    }
                }
            }
            if (resultTrue) {
                break;
            }
            */
        }
        return result;
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
     * @return size table
     */
    public int size() {
        return this.table.length;
    }

    /**
     *
     * @param index index
     * @return Noe<K,V>
     */
    public Node<K, V> getIndex(int index) {
        return this.table[index];
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

        /**
         * @param value value.
         */
        public void setValue(V value) {
            this.value = value;
        }

        /**
         * @return all param object for class Node
         */
        @Override
        public String toString() {
            return String.format("%s%s%s%s%s%s%s%s%s%s", "Node{", "hash=", this.hash, ", key=", this.key,
                    ", value=", this.value, ", next=", next, "}");
        }
    }

}
