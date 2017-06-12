package com.adidyk;

import java.util.Arrays;

import static java.lang.Math.round;

public class SimpleArray<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray() {
        this.objects = new Object[10];
    }

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    // add - add object to objects array
    public void add(T object) {
        if (this.index == this.objects.length) {
            Object[] objectTemp = new Object[(int) round(1.5 * this.objects.length)];
            System.arraycopy(this.objects, 0, objectTemp, 0, this.objects.length);
            this.objects = objectTemp;
        }
        this.objects[this.index++] = object;
    }

    // add - add object to objects to index
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

    // set
    public void set(int index, T object) {
        if (index < this.getAll().length) {

        }

    }

    // remove - object by object
    public void remove(T object) {
        for (int index = 0; index < this.objects.length; index++) {
            if (this.objects[index] == object) {
                System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - 1 - index);
                this.index--;
                break;
            }
        }
        Object[] objectTemp = new Object[this.objects.length - 1];
        System.arraycopy(this.objects, 0, objectTemp, 0, this.objects.length - 1);
        this.objects = objectTemp;
    }

    // remove - object by index
    public void remove(int index) {
        if (index < this.objects.length) {
            System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - 1 - index);
            this.index--;
        } else {
            System.out.println("Index more than length array objects ... ");
        }
    }

    // get - get object by index
    public T get(int index) {
        return (T) this.objects[index];
    }

    // getAll - without null
    public Object[] getAll() {
        Object[] objectGet = new Object[this.index];
        System.arraycopy(this.objects, 0, objectGet, 0, this.index);
        return objectGet;
    }

    // set - set object by index
    public void set() {

    }

    // size -
    public int size() {
        return this.index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleArray)) return false;

        SimpleArray<?> that = (SimpleArray<?>) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(this.getAll(), that.getAll());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.getAll());
    }

    @Override
    public String toString() {
        return "SimpleArray{" + "objects=" + Arrays.toString(this.objects) +'}' +" size:  " + this.size();
    }
}