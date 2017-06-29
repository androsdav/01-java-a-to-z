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
            if (object.item.equals(item)) {
                count++;
                break;
            }
            count++;
            object = object.prev;
        }
        return count;
    }

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
