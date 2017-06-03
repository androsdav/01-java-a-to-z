package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorPrimeArrayTest {

    private final IteratorPrimeArray it = new IteratorPrimeArray(new int[]{1, 2, 3, 4, 4, 3, 7, 13, 13, 11, 4, 10, 131});

    @Test
    public void nextTest() {
        this.it.next();
        this.it.next();
        this.it.next();
        int result = (Integer)this.it.next();
        assertThat(result, is(7));
    }

    @Test
    public void hasNextTrue() {
        this.it.next();
        boolean result = this.it.hasNext();
        assertThat(result, is(true));
    }

    @Test
    public void hasNextFalseTest() {
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        boolean result = this.it.hasNext();
        assertThat(result, is(false));
    }

    @Test
    public void loopTest() {
        int[] resultActual = new int[]{2, 3, 3, 7, 13, 13, 11, 131};
        int[] resultExpected = new int[8];
        int index = 0;
        while(this.it.hasNext()) {
            resultExpected[index] = (Integer)this.it.next();
            index++;
        }
        assertThat(resultActual, is(resultExpected));
    }

}