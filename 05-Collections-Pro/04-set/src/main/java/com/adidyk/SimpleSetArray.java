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
    public boolean add(E object) {
        boolean addObject = true;
        if(this.objects.length == 0) {
            this.addObject(object);
        } else if(addObject = !this.searchDuplicate(object)) {
            this.addObject(object);
        }
        this.sortObjectByHashCode();
        return addObject;
    }

    // size - return size Set-Array container
    public int size() {
        return this.objects.length;
    }

    // addObject - adds object to Set-Array container
    private void addObject(E object) {
        Object[] objectsTemp = new Object[this.objects.length + 1];
        System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
        this.objects = objectsTemp;
        this.objects[this.index++] = object;
    }

    // searchDuplicate - searches duplicate and return true if it`s duplicate, false - if it`s not duplicate
    private boolean searchDuplicate(E object) {
        boolean sameObject = false;
        for (Object item : objects) {
            if (item !=null && object.equals(item)) {
                sameObject = true;
                break;
            }
        }
        return sameObject;
    }

    private void sortObjectByHashCode() {
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