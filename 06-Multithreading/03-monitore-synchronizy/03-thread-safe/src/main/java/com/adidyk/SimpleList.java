package com.adidyk;

/**
 * SimpleList list.
 * @param <E> - is generic.
 */
public interface SimpleList<E> extends Iterable<E> {

    /**
     * add - adds new object to collection.
     * @param object - is object
     */
    void add(E object);

    /**
     * get - returns object from collection by index.
     * @param index - is index in collection that have inputted object.
     * @return - returns object from collection by index.
     */
    E get(int index);

}
