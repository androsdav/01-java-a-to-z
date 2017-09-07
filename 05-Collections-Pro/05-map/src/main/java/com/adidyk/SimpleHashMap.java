package com.adidyk;

import java.util.Iterator;

/**
 * Class SimpleHashMap is HashTable structure by analogy as in Java. SimpleHashMap is implemented on arrays where
 * each cell of the array can contain linked list object Node. Object of class Node has next parameters:
 *
 * -> hash  - hash value by key;
 * -> key   - key its generic type <K>;
 * -> prev  - link on previous object of class Node;
 * -> value - value its generic type <V>;
 * -> next  - link on next object of class Node.
 *
 * Class SimpleHashMap have next method:
 * -> put    - adds key and value in array, where is bucket number is calculated from hash code of key;
 * -> get    - returns value by key;
 * -> remove - remove object of class Node by key.
 *
 * Class SimpleHashMap can use method for-each and method iterator.
 * @param <K> the type of keys maintained by this map.
 * @param <V> the type of mapped values.
 *
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 30.08.2017.
 * @version 1.0.
 */
class SimpleHashMap<K, V> implements SimpleMap<K, V> {

    /**
     *  @param table - array for object for class Node.
     */
    private Node<K, V>[] table;

    /**
     * @param size - quantity of object of class Node.
     */
    private int size;

    /**
     * Constructor - sets size of array ([]table).
     */
    SimpleHashMap() {
        this.table = (Node<K, V>[]) new Node[12];
    }

    /**
     * put - adds new object Node (hash, key, prev, value, next) in array where is bucket number is calculated
     * from hash code of key and returns added value. If key already exists in the table, only value is update and
     * returns old value.
     * @param key - its generic type <K>.
     * @param value - its generic type <V>.
     * @return added value if table don`t has key, old value if table has key.
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
     * get - returns value by key;
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
    public Iterator iterator() {
        return new SimpleIterator(this.table);
    }

    /**
     * class Iterator.
     */
    private class SimpleIterator implements Iterator<Node<K, V>> {

        /**
         * @param table table
         */
        private Node<K, V>[] table;

        /**
         * @param index index
         */
        private int index = 0;

        /**
         * @param position position
         */
        private int position = 0;

        /**
         * @param result result
         */
        private Node<K, V> result;

        /**
         * @param nextNode nextNode
         */
        private Node<K, V> nextNode;

        /**
         * @param firstNode firstNode
         */
        private Node<K, V> node;

        /**
         *
         */
        private boolean listTrue = false;

        /**
         *
         * @param table its table
         */
        SimpleIterator(Node<K, V>[] table) {
            this.table = table;
        }

        /**
         * nothing.
         */
        private void arrayNext() {
            if (!this.listTrue) {
                for (int position = this.index; position < this.table.length; position++) {
                    if (this.table[position] != null) {
                        this.index = position;
                        this.node = this.table[this.index];
                        break;
                    }
                }
                this.listTrue = true;
            }
        }

        /**
         * nothing.
         */
        private void listNext() {
            this.result = this.node;
            if (this.node.next != null) {
                this.node = this.node.next;
            } else {
                this.index++;
                this.listTrue = false;
            }
        }

        /**
         * @return end.
         */
        @Override
        public boolean hasNext() {
            this.arrayNext();
            return this.index < this.table.length;
        }

        /**
         * @return next element.
         */
        @Override
        public Node<K, V> next() {
            this.arrayNext();
            this.listNext();
            return this.result;
        }

        /**
         * nothing.
         */
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
            /*
            return String.format("%s%s%s%s%s%s%s%s%s%s", "Node{", "hash=", this.hash, ", key=", this.key,
                    ", value=", this.value, ", next=", next, "}");
                    */
            return String.format("%s%s%s%s", "key: ", this.key, "value: ", this.value);
        }
    }

}
