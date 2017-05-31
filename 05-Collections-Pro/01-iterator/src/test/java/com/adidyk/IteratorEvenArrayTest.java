package com.adidyk;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorEvenArrayTest {

    private final IteratorEvenArray it = new IteratorEvenArray(new int[]{1, 2, 3, 4, 5, 8, 9, 10});

    @Test
    public void hasNexTrueTest() {
        this.it.next();
        this.it.next();
        boolean result =  this.it.hasNext();
        assertThat(result, is(true));
    }

    @Test
    public void hasNextFalseTest() {
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        boolean result = this.it.hasNext();
        assertThat(result, is(false));
    }

    @Test
    public void nextTest() {
        int result = (Integer) it.next();
        assertThat(result, is(2));
    }

}