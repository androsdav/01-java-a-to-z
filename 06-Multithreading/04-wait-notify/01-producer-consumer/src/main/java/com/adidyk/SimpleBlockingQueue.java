package com.adidyk;

/**
 * SimpleArrayList is container based on an array (dynamic container).
 * @param <E> - is type objects (generic).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
class SimpleBlockingQueue<E> {

    /**
     * @param queue - queue.
     */
    private SimpleQueue<E> queue = new SimpleQueue<>();

    /**
     * push - adds object to end of queue.
     * @param object - is object.
     * @param i - is.
     */
    void push(E object, int i) {
        System.out.println(i);
        queue.push(object);

    }

}
