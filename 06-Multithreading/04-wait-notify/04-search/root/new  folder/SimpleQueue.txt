package com.adidyk;

import java.util.Iterator;

/**
 * SimpleQueue is container based on an queue.
 * @param <E> - is type objects (generic).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
public class SimpleQueue<E> implements StackAndQueue<E> {

    /**
     * @param first - is first element in queue.
     */
    private Node<E> first;

    /**
     * @param last - is last element in queue.
     */
    private Node<E> last;

    /**
     * @param size - number of element in queue.
     */
    private int size;

    /**
     * empty - returns true if queue is empty, and returns false if queue is not empty.
     * @return - returns true if queue is empty, and returns false if queue is not empty.
     */
    public boolean empty() {
        boolean queueEmpty = false;
        if (this.first == null) {
            queueEmpty = true;
        }
        return queueEmpty;
    }

    /**
     * push - adds object to end of queue.
     * @param object - is object.
     * @return - returns added object.
     */
    public E push(E object) {
        Node<E> oldNode = this.last;
        Node<E> newNode = new Node<>(oldNode, object, null);
        this.last = newNode;
        if (oldNode == null) {
            this.first = newNode;
        } else {
            oldNode.next = newNode;
        }
        this.size++;
        return object;
    }

    /**
     * peek - returns first element (object) from queue.
     * @return - returns first element (object) from queue.
     */
    public E peek() {
        final Node<E> object = this.first;
        if (object == null) {
            throw new HasNotFirstElementException("Queue has not object ... ");
        }
        return object.item;
    }

    /**
     * pop - returns first element (object) from queue and remove this object from queue.
     * @return - returns first element (object) from queue and remove this object from queue.
     */
    public E pop() {
        if (this.first == null) {
            throw new HasNotFirstElementException("Queue has not object ... ");
        }
        final Node<E> object = new Node<>(this.first.prev, this.first.item, this.first.next);
        this.first = null;
        this.first = object.next;
        if (this.first != null) {
            this.first.prev = null;
        }
        this.size--;
        if (this.size == 0) {
            this.last = null;
        }
        return object.item;
    }

    /**
     * search - searches item in queue and returns to needed count method pop, if search item false returns -1.
     * @param item - is object.
     * @return - returns to needed count method pop, if search item false return -1.
     */
    public int search(E item) {
        Node<E> object = this.first;
        boolean searchItem = false;
        int count = 0;
        for (int index = 0; index < this.size; index++) {
            if (object.item.equals(item)) {
                count++;
                searchItem = true;
                break;
            }
            count++;
            object = object.next;
        }
        if (!searchItem) {
            count = -1;
        }
        return count;
    }

    /**
     * size - returns number of element of queue.
     * @return - returns number of element of queue.
     */
    int size() {
        return this.size;
    }

    /**
     * equals - return boolean result.
     * @param obj - object of class Object.
     * @return - returns boolean result "true" if container is same, and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleQueue)) {
            return false;
        }
        SimpleQueue<?> that = (SimpleQueue<?>) obj;
        return this.size == that.size && this.first.equals(that.first) && this.last.equals(that.last);
    }

    /**
     * hashCode - returns hashCode for container.
     * @return - returns hashcode for container.
     */
    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + last.hashCode();
        result = 31 * result + size;
        return result;
    }

    /**
     * toString - returns string format.
     * @return - returns all information in string format.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s", "SimpleQueue{", "first=", this.first, ", size=", this.size, "}");
    }

    /**
     * iterator - returns new iterator for container.
     * @return - returns new iterator for container.
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator(this.first, this.size);
    }

    /**
     * SimpleIterator class iterator.
     */
    private class SimpleIterator implements Iterator<E> {

        /**
         * @param object - is first element in container (linked list).
         */
        private Node<E> object;

        /**
         * @param result - is returned element by iterator.
         */
        private E result;

        /**
         * @param size - is number of element in container (queue).
         */
        private int size;

        /**
         * @param index - is index.
         */
        private int index;

        /**
         * SimpleIterator - constructor.
         * @param first - is first element in container (queue).
         * @param size - is number of element in container (queue).
         */
        SimpleIterator(Node<E> first, int size) {
            this.object = first;
            this.size = size;
        }

        /**
         * hasNext - returns true if next element is in container or returns false if next element isn`t in container.
         * @return - returns true if next element is in container or returns false if next element isn`t in container.
         */
        @Override
        public boolean hasNext() {
            return (this.index < this.size);
        }

        /**
         * next - returns next element from collection.
         * @return - returns next element from collection.
         */
        @Override
        public E next() {
            this.result = this.object.item;
            this.object = this.object.next;
            this.index++;
            return this.result;
        }

        /**
         * remove - isn`t nothing.
         */
        @Override
        public void remove() {
        }

    }

    /**
     * Node class using for created object of class Node in container (queue).
     * Object of class Node has next parameters:
     * -> prev  - link on previous object of class Node;
     * -> value - value its generic type <E>;
     * -> next  - link on next object of class Node.
     * @param <E> - is type objects (generic).
     */
    private static class Node<E> {

        /**
         * @param prev - link on previous object of class Node.
         */
        private Node<E> prev;

        /**
         * @param item - value its generic type <E>.
         */
        private E item;

        /**
         * @param next - link on next object of class Node.
         */
        private Node<E> next;

        /**
         * Node - constructor.
         * @param prev - link on previous object of class Node.
         * @param item - value its generic type <E>.
         * @param next - link on next object of class Node.
         */
        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        /**
         * equals - return boolean result.
         * @param obj - object of class Object.
         * @return - returns boolean result "true" if object of class Node is same, and returns "false" - isn`t same.
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Node)) {
                return false;
            }
            Node<?> node = (Node<?>) obj;
            return this.item.equals(node.item);
        }

        /**
         * hashCode - returns hashCode for container.
         * @return - returns hashcode for container.
         */
        @Override
        public int hashCode() {
            return this.item.hashCode();
        }

    }

}