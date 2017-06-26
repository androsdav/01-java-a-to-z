package com.adidyk;

public class Node<E> {

    public Node<E> prev;
    public E item;
    public Node<E> next;

    Node (Node<E> prev, E item, Node<E> next) {
        this.prev = prev;
        this.item = item;
        this. next = next;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return this.prev;
    }

    public E getItem() {
        return this.item;
    }

    public Node<E> getNext() {
        return this.next;
    }
}
