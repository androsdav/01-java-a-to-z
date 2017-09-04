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
                Node<K, V> newNode = new Node<>(hash, key, null, value, oldNode);
                this.table[bucket] = newNode;
                oldNode.prev = newNode;
            }
        } else {
            Node<K, V> newNode = new Node<>(hash, key, null, value, null);
            this.table[bucket] = newNode;
        }
        this.size++;
        return result;
    }

    /**
     * @param key its class K.
     * @return V its class.
     */
    @Override
    public V get(K key) {
        V result = null;
        int hash = this.hash(key);
        int bucket = this.bucket(hash);
            if (this.table[bucket] != null) {
                Node<K, V> firstNode = this.table[bucket];
                Node<K, V> item = this.searchKey(firstNode, key);
                if (item != null) {
                    result = item.value;
                }
            }
        return result;
    }

    /**
     * @param key its class K.
     * @return V its class.
     */
    @Override
    public V remove(K key) {
        V result = null;
        int hash = this.hash(key);
        int bucket = this.bucket(hash);
            if (this.table[bucket] != null) {
                Node<K, V> firstNode = this.table[bucket];
                Node<K, V> item = this.searchKey(firstNode, key);
                if (item != null) {
                    result = item.value;
                    if (item.prev == null) { // first element in LinkedList
                        if (item.next == null) {
                            this.table[bucket] = null;
                        } else {
                            Node<K, V> node = item.next;
                            node.prev = null;
                            this.table[bucket] = node;
                        }
                    } else if (item.next == null) {
                        Node<K, V> prevNode = item.prev;
                        prevNode.next = null;
                    } else {
                        Node<K, V> prevNode = item.prev;
                        Node<K, V> nextNode = item.next;
                        prevNode.next = nextNode;
                        nextNode.prev = prevNode;
                    }
                }
            }
        return result;
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
     * @return Node<K,V>
     */
    public Node<K, V> getIndex(int index) {
        return this.table[index];
    }

    /* ---------------- Private operations -------------- */
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

    /* ---------------- Iterator operations -------------- */

    /**
     * @return V its class.
     */
    @Override
    public Iterator<K> iterator() {
        return new SimpleIterator(this.table);
    }

    /**
     * class Iterator.
     */
    private class SimpleIterator implements Iterator<K> {

        /**
         * @param table table
         */
        private Node<K, V>[] table;

        private int index = 0;

        /**
         *
         * @param table its table
         */
        SimpleIterator(Node<K, V>[] table) {
            this.table = table;

        }

        /**
         * nothing
         */
        private void evenNext() {
            if (this.index < this.table.length) {
                while (this.table[this.index] == null) {
                    this.index++;
                    if (this.index == this.table.length) {
                        break;
                    }
                }
            }
        }

        /**
         * @return end
         */
        @Override
        public boolean hasNext() {
            this.evenNext();
            return false;
        }

        /**
         * @return next element.
         */
        @Override
        public K next() {
            this.evenNext();
            return this.table[this.index++];
        }

        @Override
        public void remove() {

        }
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
         * @param prev
         */
        private Node<K, V> prev;

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
         * @param prev next.
         * @param value key.
         * @param next next.
         */
        Node(int hash, K key, Node<K, V> prev, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.prev = prev;
            this.value = value;
            this.next = next;
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
