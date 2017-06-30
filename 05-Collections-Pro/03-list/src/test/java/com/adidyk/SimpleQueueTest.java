package com.adidyk;

import org.junit.Before;
import org.junit.Test;

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

}