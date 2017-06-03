package com.adidyk;

import java.util.Iterator;

public class IteratorEvenArray implements Iterator {

    private final int[] array;
    private int index = 0;

    IteratorEvenArray(final int[] array) {
        this.array = array;
    }

    private void evenNext() {
        if (this.index < this.array.length) {
            while (this.array[this.index] % 2 != 0) {
                this.index++;
                if (this.index == this.array.length) {
                    break;
                }
            }
        }
    }

    public boolean hasNext() {
        this.evenNext();
        return  (this.index < this.array.length);
    }

    public Object next() {
        this.evenNext();
        return this.array[this.index++];
    }

    public void remove() {
    }

}
