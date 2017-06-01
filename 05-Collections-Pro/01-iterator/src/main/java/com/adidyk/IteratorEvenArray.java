package com.adidyk;

import java.util.Iterator;

public class IteratorEvenArray implements Iterator {

    private final int[] array;
    private int indexFirst = 0;
    private int index = 0;
    private int shift = 0;

    IteratorEvenArray(final int[] array) {
        this.array = array;
    }

    private void evenNext() {
        while (this.array[this.index] % 2 != 0 && this.index < this.array.length - 1) {
            this.index++;
        }
        this.indexFirst = this.index;
        this.index++;
        while (this.array[this.index] % 2 != 0 && this.index < this.array.length - 1) {
            this.index++;
        }
        if (this.index == this.array.length - 1) {
            this.shift = 0;
        } else {
            this.shift = this.index - this.indexFirst;
        }
    }

    public boolean hasNext() {
        return this.shift != 0;
    }

    public Object next() {
        this.evenNext();
        return this.array[this.indexFirst + this.shift];
    }

    public void remove() {
    }

}
