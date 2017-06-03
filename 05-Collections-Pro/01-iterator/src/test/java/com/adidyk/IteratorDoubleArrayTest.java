package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorDoubleArrayTest {

    private final IteratorDoubleArray it = new IteratorDoubleArray(new int[][]{
            {11, 22, 33},
            {66, 77, 88},
            {91, 95, 98}
    });

    @Test
    public void nextTest() {
        this.it.next();
        this.it.next();
        int result = (Integer)this.it.next();
        assertThat(result, is(33));
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
        this.it.next();
        boolean result = this.it.hasNext();
        assertThat(result, is(false));
    }

    @Test
    public void loopTest() {
        int[] resultActual = new int[]{11, 22, 33, 66, 77, 88, 91, 95, 98};
        int[] resultExpected = new int[9];
        int index = 0;
        while(this.it.hasNext()) {
            resultExpected[index] = (Integer)this.it.next();
            index++;
        }
        assertThat(resultActual, is(resultExpected));
    }

}