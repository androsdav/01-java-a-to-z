package com.adidyk;

/**
 * Interface SimpleList for create container based on an array.
 * @param <E> - is type objects (generic).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
public interface SimpleList<E> extends Iterable<E> {

    /**
     * add - adds new object to container collection.
     * @param object - is object of class type <E>.
     */
    void add(E object);

    /**
     * get - returns object from container by index.
     * @param index - is index.
     * @return - returns object by index from container.
     */
    E get(int index);

}
