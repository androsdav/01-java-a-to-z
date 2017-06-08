package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertIteratorIteratorTest {

    private Iterator<Integer> iteratorExpected;

    @Before
    public void init() {
        Iterator<Integer> it1 = Arrays.asList(1, 2).iterator();
        Iterator<Integer> it2 = Arrays.asList(3, 4, 5, 6, 7).iterator();
        Iterator<Integer> it3 = Collections.singletonList(8).iterator();
        Iterator<Integer> it4 = Arrays.asList(9, 10, 11).iterator();
        ConvertIteratorIterator itAll = new ConvertIteratorIterator();
        this.iteratorExpected = itAll.convert(Arrays.asList(it1, it2, it3, it4).iterator());
    }

    @Test
    public void nextTest() {
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        int result = this.iteratorExpected.next();
        assertThat(result, is(4));
    }

    @Test
    public void hasNextTrue() {
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        boolean result = this.iteratorExpected.hasNext();
        assertThat(result, is(true));
    }

    @Test
    public void hasNextFalseTest() {
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.next();
        this.iteratorExpected.hasNext();
        boolean result = this.iteratorExpected.hasNext();
        assertThat(result, is(false));
    }

    @Test
    public void loopTest() {
        int[] resultActual = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] resultExpected = new int[11];
        int index = 0;
        while(this.iteratorExpected.hasNext()) {
            resultExpected[index] = this.iteratorExpected.next();
            index++;
        }
        assertThat(resultActual, is(resultExpected));
    }

}