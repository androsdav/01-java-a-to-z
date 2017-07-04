package com.adidyk;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CycleTest {

    private SimpleNode<User> user5 = new SimpleNode<>(new User("5", "Sem", 15), null);
    private SimpleNode<User> user4 = new SimpleNode<>(new User("4", "Deon", 14), this.user5);
    private SimpleNode<User> user3 = new SimpleNode<>(new User("0", "Bob", 10), this.user4);
    private SimpleNode<User> user2 = new SimpleNode<>(new User("2", "Will", 12), this.user3);
    private SimpleNode<User> user1 = new SimpleNode<>(new User("1", "Bill", 11), this.user2);
    private SimpleNode<User> user0 = new SimpleNode<>(new User("0", "Bob", 10), this.user1);
    private Cycle cycle = new Cycle();

    @Test
    public void hasCycleFalseTest() {
        this.cycle.hasCycle(user0);
        assertThat(false, is(this.cycle.hasCycle(this.user0)));

    }

    @Test
    public void hasCycleTrueTest() {
        this.user5.next = this.user0;
        assertThat(true, is(this.cycle.hasCycle(this.user0)));
    }

}