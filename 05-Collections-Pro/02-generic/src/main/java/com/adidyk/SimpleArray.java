package com.adidyk;

import static java.lang.Math.round;

public class SimpleArray<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray() {
        this.objects = new Object[5];
    }

    public T add(T object) {
        if (this.index == this.objects.length) {
            Object[] objectTemp = new Object[(int) round(1.5  * this.objects.length)];
            System.arraycopy(this.objects, 0, objectTemp, 0, this.objects.length);
            this.objects = objectTemp;
        }
        this.objects[this.index++] = object;
        return object;
    }

    public void removeObjectByObject(T object) {
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

    public void removeObjectByIndex(int index) {
        if (index < this.objects.length) {
            System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - 1 - index);
            this.index--;
        } else {
            System.out.println("Index more than length array objects ... ");
        }
    }

    public Object[] getAllObject() {
        return this.objects;
    }





}
