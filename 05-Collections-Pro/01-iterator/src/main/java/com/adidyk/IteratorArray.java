package com.adidyk;


import java.util.Iterator;

public class IteratorArray implements Iterator {

    private final int[] array;
    private int index = 0;

    IteratorArray(final int[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return this.index < this.array.length;
    }

    public Object next() {
        return this.array[this.index++];
    }

    public void remove() {
    }

}
