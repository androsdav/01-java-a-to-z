package com.adidyk;

public interface SimpleList<E> extends Iterable<E> {

    void add(E object);
    E get(int index);

}
