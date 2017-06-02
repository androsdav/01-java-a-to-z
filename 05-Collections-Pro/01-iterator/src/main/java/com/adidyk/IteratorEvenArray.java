package com.adidyk;

import java.util.Iterator;

public class IteratorEvenArray implements Iterator {

    private final int[] array;
    private int indexFirst = 0;
    private int index = 0;

    IteratorEvenArray(final int[] array) {
        this.array = array;
    }

    private void evenNext() {
        while (this.array[this.index] % 2 != 0 && this.index < this.array.length - 1) {
            this.index++;
        }
        this.indexFirst = this.index;
        if (this.index < this.array.length - 1) {
            this.index++;
        }
        while (this.array[this.index] % 2 != 0 && this.index < this.array.length) {
            this.index++;
            if (this.index == this.array.length) {
                break;
            }
        }
    }

    public boolean hasNext() {
        return (this.index < this.array.length && this.indexFirst != this.array.length - 1);
    }

    public Object next() {
        this.evenNext();
        return this.array[this.indexFirst];
    }

    public void remove() {
    }

}
