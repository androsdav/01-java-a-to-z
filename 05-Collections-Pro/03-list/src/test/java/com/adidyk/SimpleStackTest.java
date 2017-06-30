package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {

    private SimpleStack<User> stack = new SimpleStack<>();
    private User bob = new User("0", "Bob", 10);
    private User neo = new User("1", "Neo", 11);
    private User bill = new User("2", "Bill", 12);
    private User will = new User("3", "Will", 13);

    @Before
    public void init() {
        this.stack.push(new User("0", "Bob", 10));
        this.stack.push(new User("1", "Neo", 11));
        this.stack.push(new User("2", "Bill", 12));
        this.stack.push(new User("3", "Will", 13));
    }

    @Test
    public void emptyTrueTest() {
        SimpleStack<User> stack = new SimpleStack<>();
        assertThat(true, is(stack.empty()));
    }

    @Test
    public void emptyFalseTest() {
        SimpleStack<User> stack = new SimpleStack<>();
        stack.push(this.bob);
        assertThat(false, is(stack.empty()));
    }

    @Test
    public void peekTest() {
        assertThat(new User("3", "Will", 13), is(this.stack.peek()));
    }

    @Test
    public void popTest() {
        assertThat(new User("3", "Will", 13), is(this.stack.pop()));
        assertThat(new User("2", "Bill", 12), is(this.stack.peek()));
    }

    @Test
    public void searchTrueTest() {
        assertThat(1, is(this.stack.search(new User("3", "Will", 13))));
        assertThat(4, is(this.stack.search(new User("0", "Bob", 10))));
    }

    @Test
    public void searchFalseTest() {
        assertThat(-1, is(this.stack.search(new User("12", "Amanda", 66))));
    }

    @Test
    public void sizeTest() {
        assertThat(4, is(this.stack.size()));
    }

    @Test
    public void forEachTest() {
        Object[] resultActual = new Object[] {this.will, this.bill, this.neo, this.bob};
        Object[] resultExpected = new Object[4];
        int index = 0;
        for (User user : this.stack) {
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

        private Iterator<User> it = stack.iterator();

        @Before
        public void init() {
            init();
        }

        @Test
        private void nextTest() {
            this.it.next();
            this.it.next();
            assertThat(new User("1", "Neo", 11), is(this.it.next()));
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
            Object[] resultActual = new Object[] {will, bill, neo, bob};
            Object[] resultExpected = new Object[4];
            int index = 0;
            while(this.it.hasNext()) {
                resultExpected[index++] = this.it.next();
            }
            assertThat(resultActual, is(resultExpected));
        }

    }

}