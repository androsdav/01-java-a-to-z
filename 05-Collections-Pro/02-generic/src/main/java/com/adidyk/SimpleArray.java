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

    // add - add object bto objects to index
    public void add(int index, T object) {
        if (this.index == this.objects.length) {
            Object[] objectTemp = new Object[(int) round(1.5 * this.objects.length)];
            System.arraycopy(this.objects, 0, objectTemp, 0, this.objects.length);
            this.objects = objectTemp;
        }
        System.arraycopy(this.objects, index - 1, this.objects, index, this.objects.length - 1 - index);
        this.objects[index] = object;
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
        Object[] objectGet = null;
        boolean nullTrue = false;
        for (int index = 0; index < this.objects.length; index++) {
            if (this.objects[index] == null) {
                objectGet = new Object[index];
                System.arraycopy(this.objects, 0, objectGet, 0, index);
                nullTrue = true;
                break;
            }
        }
        if (!nullTrue) {objectGet = this.objects;}
        return objectGet;
    }

    // set - set object by index
    public void set() {

    }

    // size -
    public int size() {
        int length = 0;
        for (int index = 0; index < this.objects.length; index++) {
            if (this.objects[index] == null) {
                length = index;
                break;
            }
        }
        return length;
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
        return "SimpleArray{" + "objects=" + Arrays.toString(this.objects) +'}';
    }
}