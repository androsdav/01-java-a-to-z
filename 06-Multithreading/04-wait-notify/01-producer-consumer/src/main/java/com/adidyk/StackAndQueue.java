package com.adidyk;

/**
 *
 * @param <E> is.
 */

public interface StackAndQueue<E> extends Iterable<E> {

    /**
     *
     * @return is.
     */
    boolean empty();

    /**
     *
     * @return is.
     */
    E peek();

    /**
     *
     * @return is.
     */
    E pop();

    /**
     *
     * @param object is.
     * @return is.
     */
    E push(E object);

    /**
     *
     * @param item is.
     * @return is.
     */
    int search(E item);

}
