package com.adidyk;

import java.util.Iterator;

public class SimpleSetLinkedList<E> implements SimpleSet<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    // add - adds object to Set-linkedList container
    public boolean add(E object) {
        boolean isAdded = false;
        if (!searchDuplicate(object)) {
            this.addObject(object);
            isAdded = true;
        }
        return isAdded;
    }

    // size - return size Set-LinkedList container and return true if object added to container, false - not added
    public int size() {
        return this.size;
    }

    // addObject - adds object to Set-LinkedList container
    private void addObject(E object) {
        Node<E> oldNode = this.last;
        Node<E> newNode = new Node<>(oldNode, object, null);
        this.last = newNode;
        if (oldNode == null)
            this.first = newNode;
        else
            oldNode.next = newNode;
        this.size++;
    }

    // searchDuplicate - searches duplicate and return true if it`s duplicate, false - if it`s not duplicate
    private boolean searchDuplicate(E object) {
        boolean sameObject = false;
                for (Node<E> node = this.first; node != null; node = node.next) {
            if (object.equals(node.item)) {
                sameObject = true;
                break;
            }
        }
        return sameObject;
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