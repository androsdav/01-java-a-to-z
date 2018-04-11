package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CounterTest does testing of class Counter.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.04.2018.
 * @version 1.0.
 */
public class CounterTest {

    /**
     * addCounterTest - test method addCounter of class Counter.
     */
    @Test
    public void addCounterTest() {
        final Counter counter = new Counter();
        counter.addCounter();
        assertThat(1, is(counter.getCounter()));
    }

    /**
     * getCounterTest - test method getCounter of class Counter.
     */
    @Test
    public void getCounterTest() {
        final Counter counter = new Counter();
        counter.addCounter();
        assertThat(1, is(counter.getCounter()));
    }

}