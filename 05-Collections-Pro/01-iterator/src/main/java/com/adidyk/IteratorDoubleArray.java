package com.adidyk;

import java.util.Iterator;

public class IteratorDoubleArray implements Iterator {

    private final int[][] array;
    private int indexI = 0;
    private int indexJ = 0;

    IteratorDoubleArray(int[][] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return !(this.indexI == this.array.length - 1 && this.indexJ == this.array.length);
    }

    public Object next() {
        if (this.indexJ == this.array.length) {
            this.indexI++;
            this.indexJ = 0;
        }
        return this.array[this.indexI][this.indexJ++];
    }

    public void remove() {
    }

}
