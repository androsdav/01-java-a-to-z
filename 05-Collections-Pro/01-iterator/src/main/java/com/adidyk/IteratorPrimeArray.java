package com.adidyk;

import java.util.Iterator;

public class IteratorPrimeArray implements Iterator {

    private final int[] array;
    private int indexFirst = 0;
    private int index = 0;

    IteratorPrimeArray(final int[] array) {
        this.array = array;
    }

    private boolean primeSearch() {
        boolean isPrime = true;
        for (int index = 0; index < this.array[this.index]; index++) {
            if (this.array[this.index] % index == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    private void primeNext() {
        while (this.primeSearch() && this.index < this.array.length - 1) {
            this.index++;
        }
        this.indexFirst = this.index;
        if (this.index < this.array.length - 1) {
            this.index++;
        }
        while (this.primeSearch() && this.index < this.array.length) {
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
        this.primeNext();
        return this.array[this.indexFirst];
    }

    public void remove() {
    }
}
