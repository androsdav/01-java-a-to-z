package com.adidyk;

import java.util.Iterator;

public class SimpleQueue<E> implements StackAndQueue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    // empty  - returns true if Queue is empty, and false if Stack is not empty
    public boolean empty() {
        boolean queueEmpty = false;
        if (this.first == null) queueEmpty = true;
        return queueEmpty;
    }

    // peek - returns first object from Queue
    public E peek() {
        final Node<E> object = this.first;
        if (object == null) {
            throw new HasNotFirstElementException("Queue has not object ... ");
        }
        return object.item;
    }

    // pop - returns first object and remove this object from Queue
    public E pop() {
        final Node<E> object = this.first;
        if (object == null) {
            throw new HasNotFirstElementException("Queue has not object ... ");
        }
        this.first = object.next;
        this.size--;
        return object.item;
    }

    // push - adds object to beginning of Queue
    public E push(E object) {
        Node<E> oldNode = this.last;
        Node<E> newNode = new Node<>(oldNode, object, null);
        this.last = newNode;
        if (oldNode == null)
            this.first = newNode;
        else
            oldNode.next = newNode;
        this.size++;
        return object;

    }

    // search - searches item in Queue and returns to needed count method pop, if search item false returns -1
    public int search(E item) {
        Node<E> object = this.first;
        boolean searchItem = false;
        int count = 0;
        for (int index = 0; index < this.size - 1; index++) {
            if (object.item.equals(item)) {
                count++;
                searchItem = true;
                break;
            }
            count++;
            object = object.next;
        }
        if (!searchItem) count = -1;
        return count;
    }

    public int size() {
        return this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleQueue)) return false;
        SimpleQueue<?> that = (SimpleQueue<?>) o;
        if (size != that.size) return false;
        return first.equals(that.first);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s", "SimpleQueue{", "first=", this.first, ", size=", this.size, "}");
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator(this.first, this.size);
    }

    private class SimpleIterator implements Iterator<E> {

        private Node<E> object;
        private E result;
        private int size;
        private int index;

        SimpleIterator(Node<E> first, int size) {
            this.object = first;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return (this.index < this.size);
        }

        @Override
        public E next() {
            this.result = this.object.item;
            this.object = this.object.next;
            this.index++;
            return this.result;
        }

        @Override
        public void remove() {
        }

    }

    private static class Node<E> {

        private Node<E> prev;
        private E item;
        private Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

    }

}