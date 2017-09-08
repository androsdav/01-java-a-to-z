package com.adidyk;

import java.util.Iterator;

/**
 * ------------------------------------------------------------------------------------------------------------
 * Class SimpleHashMap is HashTable structure by analogy as in Java. SimpleHashMap is implemented on arrays where
 * each cell of the array can contain linked list object Node. Object of class Node has next parameters:
  * -> hash  - hash value by key;
 * -> key   - key its generic type <K>;
 * -> prev  - link on previous object of class Node;
 * -> value - value its generic type <V>;
 * -> next  - link on next object of class Node.
 *------------------------------------------------------------------------------------------------------------
 * Class SimpleHashMap have next method:
 * -> put    - adds key and value in array, where is bucket number is calculated from hash code of key;
 * -> get    - returns value by key;
 * -> remove - remove object of class Node by key.
 *------------------------------------------------------------------------------------------------------------
 * Class SimpleHashMap can use method for-each and method iterator.
 * @param <K> - the type of keys maintained by this map.
 * @param <V> - the type of mapped values.
 *------------------------------------------------------------------------------------------------------------
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 30.08.2017.
 * @version 1.0.
 * ------------------------------------------------------------------------------------------------------------
 */
class SimpleHashMap<K, V> implements SimpleMap<K, V> {

    /**
     *  @param table - array for object for class Node.
     */
    private Node<K, V>[] table;

    /**
     * @param size - quantity of objects of class Node.
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
     * @return returns added value if table don`t has key, old value if table has key.
     */
    @Override
    public V put(K key, V value) {
        V result = value;
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
     * get - search value by key and returns value by inputted key if key is true or returns null if key is false.
     * @param key - its generic type <K>.
     * @return returns value by inputted key if key is true or returns null if key is false.
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
     * remove - search value by key and remove object for class Node if inputted key is true or returns null if
     * inputted key is false.
     * @param key - its generic type <K>.
     * @return returns value by inputted key if key is true or returns null if inputted key is false.
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
                    if (item.prev == null) {
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
     * @return returns quantity of objects of class Node.
     */
    int size() {
        return this.size;
    }

    /**
     * searchKey - searches key in linked list and returns object of class Node for inputted key if inputted key
     * is true or returns null if inputted key is false.
     * @param firstNode - is first object of class Node in cell of array []table (bucket).
     * @param key - its generic type <K>.
     * @return returns object of class Node for inputted key if inputted key is true or returns null if inputted
     * key is false.
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
     * hash - calculates hash value using hash code key, as well as "XOR" and bit right shift operators ">>>".
     * @param key - its generic type <K>.
     * @return returns hash value for inputted key.
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
     * bucket - calculates cell in array ([]table) using hash value by key and size of array, as well as
     * logical operation AND "&".
     * @param hash - is hash calculated by key.
     * @return returns number for bucket calculated by key.
     */
    private int bucket(int hash) {
        return hash & (this.table.length - 1);
    }


    /**
     * Iterator - override Iterator.
     * @return returns object of class SimpleIterator.
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
         * @param table - array for objects for class Node.
         */
        private Node<K, V>[] table;

        /**
         * @param index - counter, position in array.
         */
        private int index = 0;

        /**
         * @param result - iteration, is object of class Node.
         */
        private Node<K, V> result;

        /**
         * @param node - first object of class Node in linked list.
         */
        private Node<K, V> node;

        /**
         * @param listTrue - listTrue = true ->  if bucket has object of class Node (first element in linked list)
         *                   listTrue = false -> if bucket doesn't has object of class Node (bucket has null).
         */
        private boolean listTrue = false;

        /**
         * Constructor  - sets next default parameter table.
         * @param table  - array for objects for class Node.
         */
        SimpleIterator(Node<K, V>[] table) {
            this.table = table;
        }

        /**
         * arrayNext - searches for the bucket number that contains the object of class Node if listTrue = false.
         * If bucket number is found parameter listTrue takes on value true (listTrue = true).
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
         * listNode - each element of the linked list is sent to output iterator.
         * If linked list is finish listTrue takes on value true (listTrue = true).
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
         * hasNext - override method from interface Iterable.
         * object of class Node.
         * @return returns true if table has next object of class Node, returns false if table does`t has next
         * object of class Node.
         */
        @Override
        public boolean hasNext() {
            this.arrayNext();
            return this.index < this.table.length;
        }

        /**
         * next - override method from interface Iterable.
         * @return returns object of class Node from array ([]table) and shift cursor on next not
         * null elements in array.
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
     * ------------------------------------------------------------------------------------------------------------
     * Class Node using for created object of class Node. Object of class Node has next parameters:
     * -> hash  - hash value by key;
     * -> key   - key its generic type <K>;
     * -> prev  - link on previous object of class Node;
     * -> value - value its generic type <V>;
     * -> next  - link on next object of class Node.
     *------------------------------------------------------------------------------------------------------------
     * @param <K> - the type of keys maintained by this map.
     * @param <V> - the type of mapped values.
     *------------------------------------------------------------------------------------------------------------
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 30.08.2017.
     * @version 1.0.
     * ------------------------------------------------------------------------------------------------------------
     */
    private static class Node<K, V> {

        /**
         * @param hash - hash value by key.
         */
        private int hash;

        /**
         * @param key - key is generic type <K>;
         */
        private K key;

        /**
         * @param prev - link on previous object of class Node;
         */
        private Node<K, V> prev;

        /**
         * @param value - value is generic type <V>;
         */
        private V value;

        /**
         * @param next link on next object of class Node.
         */
        private Node<K, V> next;

        /**
         * Constructor  - sets next default parameters: hash, key, prev, value, nest.
         * @param hash  - hash value by key;
         * @param key   - key its generic type <K>;
         * @param prev  - link on previous object of class Node;
         * @param value - value is generic type <V>;
         * @param next  - link on next object of class Node.
         */
        Node(int hash, K key, Node<K, V> prev, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        /**
         * toString - override method from class Object.
         * @return returns key and value from object of class Node in string format.
         */
        @Override
        public String toString() {
            return String.format("%s%s%s%s", "key: ", this.key, ", value: ", this.value);
        }

    }

}
