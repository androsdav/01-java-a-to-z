package com.adidyk;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorArrayTest {

    private final IteratorArray it = new IteratorArray(new int[]{12, 22, 32, 42, 52});

    @Test
    public void nextTest() {
        this.it.next();
        this.it.next();
        int result = (Integer)this.it.next();
        assertThat(result, is(32));

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
        boolean result = this.it.hasNext();
        assertThat(result, is(false));
    }

}