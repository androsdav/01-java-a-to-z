package com.adidyk;

import java.util.Iterator;

public class IteratorEvenArray implements Iterator {

    private final int[] array;
    private int index = 0;

    IteratorEvenArray(final int[] array) {
        this.array = array;
    }

    private int evenIndex() {
        while(this.array[this.index]%2 != 0) {
            this.index++;
        }
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.array.length;
    }

    public Object next() {
        this.evenIndex();
        return this.array[this.index++];
    }

    public void remove() {
    }
}
