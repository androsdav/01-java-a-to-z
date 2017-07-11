package com.adidyk;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleSetArray<E> implements SimpleSet<E> {

    private Object[] objects;
    private int index = 0;

    // Constructor
    SimpleSetArray() {
        this.objects = new Object[0];
    }

    // add - adds object to Set-Array container and return true if object added to container, false - not added
    //       and sorts all object in Set-Array by hashcode
    public boolean add(E object) {
        boolean isAdded = true;
        if(this.objects.length == 0) {
            this.addObject(object);
        } else if(isAdded = !this.searchDuplicateByBinary(object)) {
            this.addObject(object);
        }
        this.sortObjectsByHashCode();
        return isAdded;
    }

    // size - return size Set-Array container
    public int size() {
        return this.objects.length;
    }

    // searchDuplicateByBinary - search duplicate by hash code and uses a binary search algorithm
    //                           and return true if object is duplicate in Set-Array,
    //                           false - if object not duplicate in Set-Array
    private boolean searchDuplicateByBinary(E object) {
        boolean sameObject = false;
        int left = 0;
        int right = this.objects.length - 1;
        int index;
        do {
            index = (right + left) / 2;
            if (this.objects[index].hashCode() == object.hashCode())
                sameObject = true;
            else if (this.objects[index].hashCode() > object.hashCode() && right - left != 0)
                right = index - 1;
            else if (right - left != 0)
                left = index + 1;
        } while((index != left && index != right ) && !sameObject);
        return sameObject;
    }

    // addObject - adds object to Set-Array container
    private void addObject(E object) {
        Object[] objectsTemp = new Object[this.objects.length + 1];
        System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
        this.objects = objectsTemp;
        this.objects[this.index++] = object;
    }

    private void sortObjectsByHashCode() {
        Arrays.sort(this.objects);
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator(this.objects);
    }

    private class SimpleIterator implements Iterator<E> {

        private Object[] objects;
        private int index = 0;

        public SimpleIterator(Object[] objects) {
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