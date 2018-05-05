package com.adidyk;

/**
 * Interface StackAndQueue for create container based on an linked list.
 * @param <E> - is type objects (generic).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
public interface StackAndQueue<E> extends Iterable<E> {

    /**
     * empty - returns true if queue is empty, and returns false if queue is not empty.
     * @return - returns true if queue is empty, and returns false if queue is not empty.
     */
    boolean empty();

    /**
     * push - adds object to end of queue.
     * @param object - is object.
     * @return - returns added object.
     */
    E push(E object);

    /**
     * peek - returns first element (object) from queue.
     * @return - returns first element (object) from queue.
     */
    E peek();

    /**
     * pop - returns first element (object) from queue and remove this object from queue.
     * @return - returns first element (object) from queue. and remove this object from queue.
     */
    E pop();

    /**
     * search - searches item in Queue and returns to needed count method pop, if search item false returns -1.
     * @param item - is object.
     * @return - returns to needed count method pop, if search item false return -1.
     */
    int search(E item);

}