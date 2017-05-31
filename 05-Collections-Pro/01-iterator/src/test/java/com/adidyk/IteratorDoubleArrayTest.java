package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorDoubleArrayTest {

    private final IteratorDoubleArray it = new IteratorDoubleArray(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

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
    public void nextTest() {
        this.it.next();
        int result = (Integer) this.it.next();
        assertThat(result, is(2));
    }

}