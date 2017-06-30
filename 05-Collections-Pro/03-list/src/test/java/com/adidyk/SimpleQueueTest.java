package com.adidyk;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    private SimpleQueue<User> queue = new SimpleQueue<>();
    private User bob = new User("0", "Bob", 10);
    private User neo = new User("1", "Neo", 11);
    private User bill = new User("2", "Bill", 12);
    private User will = new User("3", "Will", 13);

    @Before
    public void init() {
        this.queue.push(new User("0", "Bob", 10));
        this.queue.push(new User("1", "Neo", 11));
        this.queue.push(new User("2", "Bill", 12));
        this.queue.push(new User("3", "Will", 13));
    }

    @Test
    public void emptyTrueTest() {
        SimpleQueue<User> queue = new SimpleQueue<>();
        assertThat(true, is(queue.empty()));
    }

    @Test
    public void emptyFalseTest() {
        SimpleQueue<User> queue = new SimpleQueue<>();
        queue.push(this.bob);
        assertThat(false, is(queue.empty()));
    }

    @Test
    public void peekTest() {
        assertThat(new User("0", "Bob", 10), is(this.queue.peek()));
    }

    @Test
    public void popTest() {
        assertThat(new User("0", "Bob", 10), is(this.queue.pop()));
        assertThat(new User("1", "Neo", 11), is(this.queue.peek()));
    }

    @Test
    public void searchTrueTest() {
        assertThat(4, is(this.queue.search(new User("3", "Will", 13))));
        assertThat(1, is(this.queue.search(new User("0", "Bob", 10))));
    }

    @Test
    public void searchFalseTest() {
        assertThat(-1, is(this.queue.search(new User("12", "Amanda", 66))));
    }

    @Test
    public void sizeTest() {
        assertThat(4, is(this.queue.size()));
    }

    @Test
    public void forEachTest() {
        Object[] resultActual = new Object[] {this.bob, this.neo, this.bill, this.will};
        Object[] resultExpected = new Object[4];
        int index = 0;
        for (User user : this.queue) {
            resultExpected[index++] = user;
        }
        assertThat(resultActual, is(resultExpected));
    }

    @Test
    public void iteratorTest() {
        new SimpleIteratorTest().nextTest();
        new SimpleIteratorTest().hasNextTrue();
        new SimpleIteratorTest().hasNextFalse();
        new SimpleIteratorTest().loopTest();
    }

    private class SimpleIteratorTest {

        private Iterator<User> it = queue.iterator();

        @Before
        public void init() {
            init();
        }

        @Test
        private void nextTest() {
            this.it.next();
            this.it.next();
            assertThat(new User("2", "Bill", 12), is(this.it.next()));
        }

        @Test
        private void hasNextTrue() {
            this.it.next();
            this.it.next();
            this.it.hasNext();
            assertThat(true, is(this.it.hasNext()));
        }

        @Test
        private void hasNextFalse() {
            this.it.next();
            this.it.next();
            this.it.next();
            this.it.next();
            this.it.hasNext();
            this.it.hasNext();
            assertThat(false, is(this.it.hasNext()));
        }

        @Test
        private void loopTest() {
            Object[] resultActual = new Object[] {bob, neo, bill, will};
            Object[] resultExpected = new Object[4];
            int index = 0;
            while(this.it.hasNext()) {
                resultExpected[index++] = this.it.next();
            }
            assertThat(resultActual, is(resultExpected));
        }

    }


}