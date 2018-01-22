package com.adidyk;

import org.junit.Test;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;

/**
 * CounterTest is test counter.
 */
public class CounterTest {

    /**
     * ThreadCount is count.
     */
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

        /**
         * run - is run.
         */
        @Override
        public void run() {
            this.counter.addCounter();
        }
    }

    /**
     *
     * @throws InterruptedException is exception.
     */
    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        final Counter counter = new Counter();
        Thread first = new ThreadCount(counter);
        Thread second = new ThreadCount(counter);
        Thread third = new ThreadCount(counter);
        first.start();
        second.start();
        third.start();
        int result = counter.getCounter();
        System.out.println("Counter: " + counter.getCounter());
        System.out.println("Counter: " + counter.getCounter());
        System.out.println("Counter: " + counter.getCounter());
        System.out.println("Counter: " + result);
        System.out.println("Counter: " + result);
        //third.join();
       // assertThat(counter.getCounter(), is(2));
    }

}