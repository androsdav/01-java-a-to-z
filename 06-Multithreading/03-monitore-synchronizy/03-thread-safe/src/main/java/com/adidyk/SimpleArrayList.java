package com.adidyk;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.Arrays;
import java.util.Iterator;
import static java.lang.Math.round;

/**
 * SimpleArrayList is container based on an array (dynamic container).
 * @param <E> - is type objects (generic).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
@ThreadSafe
public class SimpleArrayList<E> implements SimpleList<E> {

    /**
     * @param objects - is reference variable to container.
     */
    @GuardedBy("this")
    private Object[] objects;

    /**
     * @param index - is index to cell of array.
     */
    @GuardedBy("this")
    private int index = 0;

    /**
     * @param modCount - counter of number modification.
     */
    private int modCount = 0;

    /**
     * SimpleArrayList - constructor.
     */
    SimpleArrayList() {
        this.objects = new Object[10];
    }

    /**
     * SimpleArrayList - constructor.
     * @param size - is size.
     */
    SimpleArrayList(int size) {
        this.objects = new Object[size];
    }

    /**
     * add - adds object to container.
     * @param object - is object.
     */
    public synchronized void add(final E object) {
        if (this.index == this.objects.length) {
            Object[] objectsTemp = new Object[(int) round(1.5 * this.objects.length)];
            System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
            this.objects = objectsTemp;
        }
        this.objects[this.index++] = object;
        this.modCount++;
    }

    /**
     * get - returns object from collections by index.
     * @param index - index in the container for which the object is returned from the cell.
     * @return - returns object from container by index.
     */
    public synchronized E get(int index) {
        return (E) this.objects[index];
    }


    /**
     * size - returns length of array of objects without null.
     * @return - returns length of array of objects without null.
     */
    synchronized int size() {
        return this.index;
    }

    /**
     * getAll - create collection without null and returns array.
     * @return - returns array of objects without null.
     */
    synchronized Object[] getAll() {
        Object[] objectTemp = new Object[this.index];
        System.arraycopy(this.objects, 0, objectTemp, 0, this.index);
        return objectTemp;
    }

    /**
     * equals - equals.
     * @param obj - is object.
     * @return true or false.
     */
    @Override
    public synchronized boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SimpleArrayList<?> that = (SimpleArrayList<?>) obj;
        return Arrays.equals(this.objects, that.objects);
    }

    /**
     * hashCode - returns hashCode.
     * @return - returns hashcode.
     */
    @Override
    public synchronized int hashCode() {
        return Arrays.hashCode(this.objects);
    }

    /**
     * toString - returns string format.
     * @return - returns all information in string format.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s",
                " NewArrayList{", "objects=", Arrays.toString(this.getAll()), "}", " size=", this.size());
    }

    /**
     * iterator - returns new iterator for container.
     * @return - returns new iterator for container.
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator(this.getAll(), this.modCount);
    }

    /**
     * SimpleIterator class iterator.
     */
    @ThreadSafe
    private class SimpleIterator implements Iterator<E> {

        /**
         * @param objects - is reference variable to container.
         */
        @GuardedBy("this")
        private Object[] objects;

        /**
         * @param index - is index to cell of array.
         */
        @GuardedBy("this")
        private int index = 0;

        /**
         * @param expectedModCount - expected number of modification.
         */
        private int expectedModCount;

        /**
         * SimpleIterator - constructor.
         * @param objects - is reference variable to container.
         * @param expectedModCount - expected number of modification.
         */
        SimpleIterator(Object[] objects, int expectedModCount) {
            this.objects = objects;
            this.expectedModCount = expectedModCount;
        }

        /**
         * hasNext - returns true if next element is in container or returns false if next element isn`t in container.
         * @return - returns true if next element is in container or returns false if next element isn`t in container.
         */
        @Override
        public synchronized boolean hasNext() {
            return this.index < this.objects.length;
        }

        /**
         * next - returns next element from collection.
         * @return - returns next element from collection.
         */
        @Override
        public synchronized E next() throws ConcurrentModificationException {
            if (this.expectedModCount != modCount) {
                throw new ConcurrentModificationException("ConcurrentModificationException");
            }
            return (E) this.objects[this.index++];
        }

        /**
         * remove - isn`t nothing.
         */
        @Override
        public void remove() {
        }

    }

}