package com.adidyk;

public class SimpleNode<E> {

    public E item;
    public SimpleNode<E> next;

    SimpleNode(E item, SimpleNode<E> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleNode<?> that = (SimpleNode<?>) o;

        return item != null ? item.equals(that.item) : that.item == null;

    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("%s%s%s%s","SimpleNode{", "item=", this.item, "}");
    }

}
