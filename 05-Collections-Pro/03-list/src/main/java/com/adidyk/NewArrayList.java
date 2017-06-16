package com.adidyk;

import static java.lang.Math.round;

public class NewArrayList<E> {

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

}
