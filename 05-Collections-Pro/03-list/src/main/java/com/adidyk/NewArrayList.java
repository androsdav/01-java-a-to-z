package com.adidyk;

import java.util.Arrays;
import java.util.Iterator;
import static java.lang.Math.round;

public class NewArrayList<E> implements Iterable<E> {

    private Object[] objects;
    private int index = 0;

    // Constructor
    NewArrayList() {
        this.objects = new Object[10];
    }

    // Constructor
    NewArrayList(int size) {
        this.objects = new Object[size];
    }

    // add - adds object to array of objects
    public void add(E object) {
        if (this.index == this.objects.length) {
            Object[] objectsTemp = new Object[(int)round(1.5 * this.objects.length)];
            System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
            this.objects = objectsTemp;
        }
        this.objects[this.index++] = object;
    }

    // get - returns object by index from array of objects
    public E get(int index) {
        return (E) this.objects[index];
    }

    // getAll - returns array of objects without null
    public Object[] getAll() {
        Object[] objectTemp = new Object[this.index];
        System.arraycopy(objects, 0, objectTemp, 0, this.index);
        return objectTemp;
    }

    // size - returns length of array of objects without null
    public int size() {
        return this.index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewArrayList<?> that = (NewArrayList<?>) o;
        return Arrays.equals(objects, that.objects);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(objects);
    }

    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s",
                " NewArrayList{", "objects=", Arrays.toString(this.getAll()), "}", " size=", this.size());
    }

    @Override
    public Iterator<E> iterator() {
        return new NewIterator(this.getAll());
    }

    private class NewIterator implements Iterator<E> {

        private Object[] objects;
        private int index = 0;

        NewIterator(Object[] objects) {
            this.objects = objects;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.objects.length;
        }

        @Override
        public E next() {
            return (E) this.objects[this.index++];
        }

        @Override
        public void remove() {
        }

    }

}