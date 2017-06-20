package com.adidyk;

public interface SimpleContainer<E> extends Iterable<E> {

    void add(E object);
    E get(int index);

}
