package com.adidyk;

import java.util.Arrays;
import static java.lang.Math.round;

public class SimpleArray<T> {

    private Object[] objects;
    private int index = 0;

    // Constructor
    public SimpleArray() {
        this.objects = new Object[10];
    }

    // Constructor
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    // add - adds object to array of objects
    public void add(T object) {
        if (this.index == this.objects.length) {
            Object[] objectTemp = new Object[(int) round(1.5 * this.objects.length)];
            System.arraycopy(this.objects, 0, objectTemp, 0, this.objects.length);
            this.objects = objectTemp;
        }
        this.objects[this.index++] = object;
    }


    // add - inserts object by index into array of objects
    //       and shifts array of objects to right by one position, starting with the set index
    public void add(int index, T object) {
        if (this.index == this.objects.length) {
            Object[] objectTemp = new Object[(int) round(1.5 * this.objects.length)];
            System.arraycopy(this.objects, 0, objectTemp, 0, this.objects.length);
            this.objects = objectTemp;
        }
        if (index < this.index) {
            System.arraycopy(this.objects, index, this.objects, index + 1, this.getAll().length - index);
            this.objects[index] = object;
            this.index++;
        }
    }

    // set - sets object by index into array of objects (rewriting)
    public void set(int index, T object) {
        if (index < this.index) {
            this.objects[index] = object;
        }
    }

    // remove - deletes object by object from array of objects,
    //          and shifts array of objects to left by one position, starting with the index of set object
    public void remove(T object) {
        for (int index = 0; index < this.index; index++) {
            if (this.objects[index] == object) {
                System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - 1 - index);
                this.index--;
                break;
            }
        }
    }

    // remove - deletes object by index from array of objects,
    //          and shifts array of objects to left by one position, starting with the index of set object
    public void remove(int index) {
        if (index < this.index) {
            System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - 1 - index);
            this.index--;
        } else {
            System.out.println("Index more than length array objects ... ");
        }
    }

    // get - returns object by index from array of objects
    public T get(int index) {
        return (T) this.objects[index];
    }

    // getAll - returns array of objects without null
    public Object[] getAll() {
        Object[] objectGet = new Object[this.index];
        System.arraycopy(this.objects, 0, objectGet, 0, this.index);
        return objectGet;
    }

    // size - returns length of array of objects without null
    public int size() {
        return this.index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleArray)) return false;

        SimpleArray<?> that = (SimpleArray<?>) o;

        return Arrays.equals(this.objects, that.objects);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.objects);
    }

    @Override
    public String toString() {
        return "SimpleArray{" + "objects=" + Arrays.toString(this.getAll()) +'}' +" size:  " + this.size();
    }

}