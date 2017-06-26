package com.adidyk;

import java.util.Iterator;

public class SimpleLinkedList<E> implements SimpleContainer<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    // Constructor
    SimpleLinkedList() {
    }

    // add - add object to SimpleLinkedList
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

    // get - get object by index
    public E get(int index) {
        Node<E> result = this.first;
        for (int position = 0; position < index; position++) {
            result = result.next;
        }
       return result.item;
    }

    // getFirst -
    public E getFirst() {
        final Node<E> result = this.first;
        return result.item;
    }

    // getLast -
    public E getLast(){
        final Node<E> result = this.last;
        return result.item;
    }

    // size -
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new NewIterator(this.first, this.size);
    }

    private class NewIterator implements Iterator<E> {

        private Node<E> first;
        private Node<E> result;
        private int size;

        NewIterator(Node<E> first, int size) {
            this.first = first;
            this.result = first;
        }

        @Override
        public boolean hasNext() {
            return this.result.next != null;
        }

        @Override
        public E next() {
            //final Node<E> result = first;
            this.result = this.result.next;
            return this.result.item;
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
