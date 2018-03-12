package com.adidyk;

import net.jcip.annotations.ThreadSafe;

/**
 * SimpleBlockingQueue is bounded blocking queue based on an queue of class SimpleQueue.
 * @param <E> - is type objects (generic).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.03.2018.
 * @version 1.0.
 */
@ThreadSafe
class SimpleBlockingQueue<E> {

    /**
     * @param queue - link variable to object of class SimpleQueue.
     */
    private SimpleQueue<E> queue = new SimpleQueue<>();

    /**
     * @param lock - link variable to object of class Object.
     */
    private final Object lock = new Object();

    /**
     * @param size - queue size limit.
     */
    private final int size;

    /**
     * @param counter - is counter.
     */
    private int counter;

    /**
     * SimpleBlockingQueue - constructor.
     * @param size - queue size limit.
     */
    SimpleBlockingQueue(final int size) {
        this.size = size;
    }

    /**
     * add - adds object to end of queue.
     * If queue is full, then queue is blocked to add.
     * @param object - is object.
     */
    void add(E object) {
        synchronized (this.lock) {
            while (this.counter >= this.size) {
                try {
                    System.out.println(String.format("%s%s", " [info]: ", "queue is full ... "));
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.queue.push(object);
            this.counter++;
            System.out.println(String.format("%s%s%s%s", " add: -> ", object, ", count = ", this.counter));
            this.lock.notify();
        }
    }

    /**
     * get - gets first object from queue and remove this object from queue.
     * If queue is empty, then queue is blocked to get.
     * @return - returns first object from queue.
     */
    E get() {
        synchronized (this.lock) {
            final E result;
            while (this.queue.empty()) {
                try {
                    System.out.println(String.format("%s%s", " [info]: ", "queue is empty ... "));
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            result = this.queue.pop();
            this.counter--;
            System.out.println(String.format("%s%s%s%s", " get: <- ", result, ", count = ", this.counter));
            this.lock.notify();
            return result;
        }
    }

    /**
     * equals - return boolean result.
     * @param obj - object of class Object.
     * @return - returns boolean result "true" if container is same, and returns "false" - isn`t same.
     */
    @Override
    public synchronized boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleBlockingQueue)) {
            return false;
        }
        SimpleBlockingQueue<?> that = (SimpleBlockingQueue<?>) obj;
        if (size != that.size) {
            return false;
        }
        return queue.equals(that.queue);
    }

    /**
     * hashCode - returns hashCode for container.
     * @return - returns hashcode for container.
     */
    @Override
    public synchronized int hashCode() {
        int result = queue.hashCode();
        result = 31 * result + size;
        return result;
    }

}