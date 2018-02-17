package com.adidyk;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.Iterator;
import static java.lang.Math.round;

/**
 * SimpleArrayList is conteayner.
 * @param <E> - is generic.
 */
@ThreadSafe
public class SimpleArrayList<E> implements SimpleList<E> {

    /**
     * @param objects - is objects.
     */
    @GuardedBy("this")
    private Object[] objects;

    /**
     * @param index - is index.
     */
    @GuardedBy("this")
    private int index = 0;

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
     * add - adds object to array of objects.
     * @param object - is object
     */
    public synchronized void add(E object) {
        if (this.index == this.objects.length) {
            Object[] objectsTemp = new Object[(int) round(1.5 * this.objects.length)];
            System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
            this.objects = objectsTemp;
        }
        this.objects[this.index++] = object;
    }

    /**
     * get - returns object from collections by index.
     * @param index - is index in collection that have inputted object.
     * @return - returns object from collection by index.
     */
    public synchronized E get(int index) {
        return (E) this.objects[index];
    }

    /**
     * getAll - create collection without null and returns array.
     * @return - returns array of objects without null.
     */
    public synchronized Object[] getAll() {
        Object[] objectTemp = new Object[this.index];
        System.arraycopy(objects, 0, objectTemp, 0, this.index);
        return objectTemp;
    }

    /**
     * size - returns length of array of objects without null.
     * @return - returns length of array of objects without null.
     */
    public int size() {
        return this.index;
    }

    /**
     * equals - equals.
     * @param obj - is object.
     * @return true or false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SimpleArrayList<?> that = (SimpleArrayList<?>) obj;
        return Arrays.equals(objects, that.objects);
    }

    /**
     * hashCode - returns hashCode.
     * @return - returns hashcode.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(objects);
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
     * iterator - iterator.
     * @return - returns iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator(this.getAll());
    }

    /**
     * SimpleIterator class iterator.
     */
    @ThreadSafe
    private class SimpleIterator implements Iterator<E> {

        /**
         * @param objects - is objects.
         */
        @GuardedBy("this")
        private Object[] objects;

        /**
         * @param index - is index.
         */
        @GuardedBy("this")
        private int index = 0;

        /**
         * SimpleIterator - iterator.
         * @param objects - is objects.
         */
        SimpleIterator(Object[] objects) {
            this.objects = objects;
        }

        /**
         * hasNext - returns true or false.
         * @return - returns true or false.
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
        public synchronized E next() {
            return (E) this.objects[this.index++];
        }

        /**
         * remove - is nothing.
         */
        @Override
        public void remove() {
        }

    }

}