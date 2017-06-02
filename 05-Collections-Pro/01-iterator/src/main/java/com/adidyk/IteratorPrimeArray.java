package com.adidyk;

import java.util.Iterator;
import static java.lang.Math.round;

public class IteratorPrimeArray implements Iterator {

    private final int[] array;
    private int indexFirst = 0;
    private int index = 0;

    IteratorPrimeArray(final int[] array) {
        this.array = array;
    }

    private boolean primeSearch() {
        boolean isPrime = true;
        if (this.array[this.index] > 1) {
            for (int index = 2; index < round(this.array[this.index] / 2); index++) {
                if (this.array[this.index] % index == 0) {
                    isPrime = false;
                    break;
                }
            }
        } else {
            isPrime = false;
        }
        return isPrime;
    }

    private void primeNext() {
        while (!this.primeSearch() && this.index < this.array.length - 1) {
            this.index++;
        }
        this.indexFirst = this.index;
        if (this.index < this.array.length - 1) {
            this.index++;
        }
        while (!this.primeSearch() && this.index < this.array.length) {
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
