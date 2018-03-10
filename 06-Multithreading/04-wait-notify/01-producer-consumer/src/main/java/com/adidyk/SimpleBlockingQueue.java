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
     * @param lock - lock.
     */
    private final Object lock = new Object();

    /**
     * @param size - is.
     */
    private final int size;

    /**
     * @param counter - is counter..
     */
    private int counter;

    /**
     * SimpleBlockingQueue - constructor.
     * @param size - is.
     */
    SimpleBlockingQueue(final int size) {
        this.size = size;
    }

    /**
     * add - adds object to end of queue.
     * @param object - is object.
     */
    void add(E object) {
        synchronized (this.lock) {
            while (this.counter >= this.size) {
                try {
                    System.out.println("Queue is full ... ");
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.queue.push(object);
            this.counter++;
            System.out.println("add: " + object + " count = " + this.counter);
            this.lock.notify();
        }
    }

    /**
     * get - get.
     * @return - returns.
     */
    E get() {
        synchronized (this.lock) {
            final E result;
            while (this.queue.empty()) {
                try {
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            result = this.queue.pop();
            this.counter--;
            System.out.println("get: " + result + " count = " + this.counter);
            this.lock.notify();
            return result;
        }
    }

    /**
     *
     * @return - returns.
     */
    SimpleQueue<E> getAll() {
        return this.queue;
    }

}