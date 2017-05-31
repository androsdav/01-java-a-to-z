package com.adidyk;

import java.util.Iterator;

public class IteratorDoublelArray implements Iterator {

    private final int[][] array;
    private int indexI = 0;
    private int indexJ = 0;

    public IteratorDoublelArray(int[][] array) {
        this.array = array;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        if (this.indexI < array[indexJ].length) {
            this.indexJ++;
        } else {
            this.indexI++;
            this.indexJ = 0;
        }
        return this.array[this.indexI][this.indexJ];
    }

    @Override
    public void remove() {
    }

}
