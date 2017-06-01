package com.adidyk;

public class IteratorDoubleArray {

    private final int[][] array;
    private int indexI = 0;
    private int indexJ = 0;
    private boolean index = true;

    IteratorDoubleArray(int[][] array) {
        this.array = array;
    }

    private void indexNext() {
        if (this.indexJ == this.array.length) {
            this.indexI++;
            this.indexJ = 0;
        }
        if (this.indexI == this.array.length - 1 && this.indexJ == this.array.length - 1) {
            this.index = false;
        }
    }

    public boolean hasNext() {
            return this.index;
    }

    public Object next() {
        this.indexNext();
        return this.array[this.indexI][this.indexJ++];
    }

    public void remove() {
    }
}
