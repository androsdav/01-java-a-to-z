package com.adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest does testing of class Counter.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.01.2018.
 * @version 1.0.
 */
public class CounterTest {

    /**
     * ThreadCount is thread that uses object of class Counter.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 24.01.2018.
     * @version 1.0.
     */
    private class ThreadCount extends Thread {

        /**
         * @param counter - is counter (link variable to object of class Counter).
         */
        private final Counter counter;

        /**
         * ThreadCount - constructor
         * @param counter - is counter (link variable to object of class Counter).
         */
        private ThreadCount(Counter counter) {
            this.counter = counter;
        }

        /**
         * run - runs thread and increase counter by one.
         */
        @Override
        public void run() {
            this.counter.addCounter();
        }
    }

    /**
     * whenExecute3ThreadThen3 - test class Counter.
     * @throws InterruptedException - is interrupted exception.
     */
    @Test
    public void whenExecute3ThreadThen3() throws InterruptedException {
        final Counter counter = new Counter();
        Thread first = new ThreadCount(counter);
        Thread second = new ThreadCount(counter);
        Thread third = new ThreadCount(counter);
        first.start();
        second.start();
        third.start();
        third.join();
        assertThat(counter.getCounter(), is(3));
    }

}