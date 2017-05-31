package com.adidyk;


import java.util.Iterator;

public class IteratorArray implements Iterator {

    private final int[] array;
    private int index = 0;

    public IteratorArray(int[] array) {
        this.array = array;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return this.array[this.index++];
    }

    @Override
    public void remove() {

    }
}
