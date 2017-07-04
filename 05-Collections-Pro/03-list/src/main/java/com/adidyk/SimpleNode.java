package com.adidyk;

public class SimpleNode<E> {

    public E item;
    public SimpleNode<E> next;

    SimpleNode(E item, SimpleNode<E> next) {
        this.item = item;
        this.next = next;
    }

}
