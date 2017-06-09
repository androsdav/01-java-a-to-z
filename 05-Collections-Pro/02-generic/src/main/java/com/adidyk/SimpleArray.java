package com.adidyk;

import static java.lang.Math.round;

public class SimpleArray<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray() {
        this.objects = new Object[10];
    }

    public T add(T object) {
        this.objects[this.index++] = object;
        if (this.index == this.objects.length) {
            Object[] objectTemp = new Object[(int) round(1.5  * this.objects.length)];
            System.arraycopy(this.objects, 0, objectTemp, 0, this.objects.length);
            this.objects = objectTemp;
        }
        return object;
    }


    public void removeObjectByObject(T object) {
        int indexDell;
        for (int index = 0; index < this.objects.length; index++) {
            if (this.objects[index] == object) {
                this.objects[index] = null;
                break;
            }

        }
    }


}
