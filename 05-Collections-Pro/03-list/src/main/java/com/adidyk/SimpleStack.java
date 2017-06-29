package com.adidyk;

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
        final Node<E> object = this.last;
        if (object == null) {
            throw new HasNotLastElementException("Stack has not object ... ");
        }
        this.last = object.prev;
        size--;
        return object.item;
    }

    // push -
    public E push(E object) {
        final Node<E> oldNode = this.last;
        this.last = new Node<>(oldNode, object, null);
        this.size++;
        return object;
    }

    // search -
    public int search(E item) {
        Node<E> object = this.last;
        int count = 0;
        for (int index = this.size; index >= 0; index--) {
            if (object.equals(item)) {
                break;
            }
            count++;
            object = object.prev;
        }
        return count;
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
