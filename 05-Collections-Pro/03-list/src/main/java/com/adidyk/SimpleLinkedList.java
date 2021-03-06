package com.adidyk;

import java.util.Iterator;

public class SimpleLinkedList<E> implements SimpleList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    // add - adds object to linked list
    public void add(E object) {
        final Node<E> oldNode = this.last;
        final Node<E> newNode = new Node<>(oldNode, object, null);
        this.last = newNode;
        if (oldNode == null)
            this.first = newNode;
        else
            oldNode.next = newNode;
        this.size++;
    }

    // get - gets object by index from linked list
    public E get(int index) {
        this.checkPositionIndex(index);
        Node<E> object = this.first;
        for (int position = 0; position < index; position++) {
            object = object.next;
        }
       return object.item;
    }

    // getFirst - returns first object from linked list
    public E getFirst() {
        final Node<E> object = this.first;
        if (object == null) {
            throw new HasNotFirstElementException("Has not first element ... ");
        }
        return object.item;
    }

    // getLast - returns last object from linked list
    public E getLast(){
        final Node<E> object = this.last;
        if (object == null) {
            throw new HasNotLastElementException("Has not last element ...");

        }
        return object.item;
    }

    // size - returns size linked list
    public int size() {
        return this.size;
    }

    // outOfBoundMsg - returns information about exception
    private String outOfBoundMsg(int index) {
        return "Index: " + index + "; " + "range of indexes: [" + "0-" + (this.size - 1) + "]";
    }

    // checkPositionIndex - check position index
    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index < this.size)) {
            throw new IndexOutOfBoundsException(this.outOfBoundMsg(index));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleLinkedList)) return false;
        SimpleLinkedList<?> that = (SimpleLinkedList<?>) o;
        if (size != that.size) return false;
        if (!getFirst().equals(that.getFirst())) return false;
        return getLast().equals(that.getLast());

    }

    @Override
    public int hashCode() {
        int result = getFirst().hashCode();
        result = 31 * result + getLast().hashCode();
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return String.format( " %s%s%s%s%s%s%s%s",
                "SimpleLinkedList{", "first =", this.first.item, "; last =", this.last.item, "}", " size=", this.size);
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

        Node (Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this. next = next;
        }

    }

}
