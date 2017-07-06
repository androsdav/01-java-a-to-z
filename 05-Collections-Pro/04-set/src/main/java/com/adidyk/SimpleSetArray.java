package com.adidyk;

import java.util.Iterator;

public class SimpleSetArray<E> implements SimpleSet<E> {

    private Object[] objects;
    private int index = 0;

    // Constructor
    SimpleSetArray() {
        this.objects = new Object[0];
    }

    // add - adds object to set container
    public boolean add(E object) {
        boolean addObject = true;
        if(this.objects.length == 0) {
            this.addObject(object);
        } else if(addObject = !this.searchDuplicate(object)) {
            this.addObject(object);
        }
        return addObject;
    }

    // size - return size set
    public int size() {
        return this.objects.length;
    }

    // searchDuplicate - searches duplicate and return true if it`s duplicate, false - if it`s not duplicate
    private boolean searchDuplicate(E object) {
        boolean sameObject = false;
        for (int position = 0; position < this.index; position++) {
            if(this.objects[position] != null && object.equals(this.objects[position])) {
                sameObject = true;
                break;
            }
        }
        return sameObject;
    }

    // addObject - adds object to set container
    private void addObject(E object) {
        Object[] objectsTemp = new Object[this.objects.length + 1];
        System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
        this.objects = objectsTemp;
        this.objects[this.index++] = object;
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