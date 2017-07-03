package com.adidyk;

import java.util.Iterator;

public class SimpleStack<E> implements StackAndQueue<E> {

    private Node<E> last;
    private int size;

    // empty  - returns true if Stack is empty, and false if Stack is not empty
    public boolean empty() {
        boolean stackEmpty = false;
        if (this.last == null) stackEmpty = true;
        return stackEmpty;
    }

    // peek - returns last object from Stack
    public E peek() {
        final Node<E> object = this.last;
        if (object == null) {
            throw new HasNotLastElementException("Stack has not object ... ");
        }
        return object.item;
    }

    // pop - returns last object and remove this object from Stack
    public E pop() {
        if (this.last == null) {
            throw new HasNotLastElementException("Stack has not object ... ");
        }
        final Node<E> object = new Node<>(this.last.prev, this.last.item, this.last.next);
        this.last = null;
        this.last = object.prev;
        size--;
        return object.item;
    }

    // push - adds object to top of Stack
    public E push(E object) {
        final Node<E> oldNode = this.last;
        final Node<E> newNode = new Node<>(oldNode, object, null);
        this.last = newNode;
        if (oldNode != null) oldNode.next = newNode;
        this.size++;
        return object;
    }

    // search - searches item in Stack and returns to needed count method pop, if search item false returns -1
    public int search(E item) {
        Node<E> object = this.last;
        boolean searchItem = false;
        int count = 0;
        for (int index = this.size - 1; index >= 0; index--) {
            if (object.item.equals(item)) {
                count++;
                searchItem  = true;
                break;
            }
            count++;
            object = object.prev;
        }
        if (!searchItem) count = -1;
        return count;
    }

    // size - returns size stack
    public int size() {
        return this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleStack)) return false;
        SimpleStack<?> that = (SimpleStack<?>) o;
        if (size != that.size) return false;
        return last.equals(that.last);
    }

    @Override
    public int hashCode() {
        int result = last.hashCode();
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s", "SimpleStack{", "last=", this.last,"; size=", this.size, "}");
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator(this.last, this.size);
    }

    private class SimpleIterator implements Iterator<E> {

        private Node<E> object;
        private E result;
        private int size;
        private int index;

        SimpleIterator(Node<E> last, int size) {
            this.object = last;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return (this.index < this.size);
        }

        @Override
        public E next() {
            this.result = this.object.item;
            this.object = this.object.prev;
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
