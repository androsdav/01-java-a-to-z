package com.adidyk;

import java.util.Iterator;

/**
 * SimpleArrayList is container based on an array (dynamic container).
 * @param <E> - is type objects (generic).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
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
     * @return - returns added object..
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
     * @return - returns first element (object) from queue. and remove this object from queue.
     */
    public E pop() {
        if (this.first == null) {
            throw new HasNotFirstElementException("Queue has not object ... ");
        }
        final Node<E> object = new Node<>(this.first.prev, this.first.item, this.first.next);
        this.first = null;
        this.first = object.next;
        this.size--;
        return object.item;
    }
    // search - searches item in Queue and returns to needed count method pop, if search item false returns -1
    /**
     * search - is.
     * @param item - is.
     * @return is.
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

    // size - return size queue
    /**
     * size - is.
     * @return is.
     */
    public int size() {
        return this.size;
    }

    /**
     *
     * @param o is.
     * @return is.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleQueue)) {
            return false;
        }
        SimpleQueue<?> that = (SimpleQueue<?>) o;
        if (size != that.size) {
            return false;
        }
        return first.equals(that.first);
    }

    /**
     *
     * @return is.
     */
    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + size;
        return result;
    }

    /**
     *
     * @return is.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s", "SimpleQueue{", "first=", this.first, ", size=", this.size, "}");
    }


    /**
     *
     * @return is.
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator(this.first, this.size);
    }

    /**
     * is.
     */
    private class SimpleIterator implements Iterator<E> {

        /**
         * is.
         */
        private Node<E> object;

        /**
         * is.
         */
        private E result;

        /**
         *
         */
        private int size;

        /**
         * is.
         */
        private int index;

        /**
         *
         * @param first is.
         * @param size is.
         */
        SimpleIterator(Node<E> first, int size) {
            this.object = first;
            this.size = size;
        }

        /**
         *
         * @return is.
         */
        @Override
        public boolean hasNext() {
            return (this.index < this.size);
        }

        /**
         *
         * @return is.
         */
        @Override
        public E next() {
            this.result = this.object.item;
            this.object = this.object.next;
            this.index++;
            return this.result;
        }

        /**
         * is.
         */
        @Override
        public void remove() {
        }

    }

    /**
     *
     * @param <E> is.
     */
    private static class Node<E> {

        /**
         * is.
         */
        private Node<E> prev;

        /**
         * is.
         */
        private E item;

        /***
         * is.
         */
        private Node<E> next;

        /**
         *
         * @param prev is.
         * @param item is.
         * @param next is.
         */
        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

    }

}