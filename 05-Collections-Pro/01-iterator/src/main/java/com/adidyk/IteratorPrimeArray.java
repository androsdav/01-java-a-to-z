package com.adidyk;

import java.util.Iterator;
import static java.lang.Math.round;

public class IteratorPrimeArray implements Iterator {

    private final int[] array;
    private int index = 0;

    IteratorPrimeArray(final int[] array) {
        this.array = array;
    }

    private boolean primeSearch() {
        boolean isPrime = true;
        if (this.array[this.index] > 1) {
            for (int index = 2; index <= round(this.array[this.index] / 2); index++) {
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
        if (this.index < this.array.length) {
            while (!this.primeSearch()) {
                this.index++;
                if (this.index == this.array.length) {
                    break;
                }
            }
        }
    }

    public boolean hasNext() {
        this.primeNext();
        return (this.index < this.array.length);
    }

    public Object next() {
        this.primeNext();
        return this.array[this.index++];
    }

    public void remove() {
    }

}
