package com.adidyk;

//import static org.junit.Assert.*;

/**
 * CounterTest
 */
public class CounterTest {

    private class ThreadCount extends Thread {

        /**
         * @param counter - is counter.
         */
        private final Counter counter;

        /**
         *
         * @param counter - is counter.
         */
        private ThreadCount(Counter counter) {
            this.counter = counter;
        }
    }

}