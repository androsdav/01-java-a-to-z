package com.adidyk;

public interface StackAndQueue<E> {

    boolean empty();
    E peek();
    E pop();
    E push(E object);
    int search(E object);

}
