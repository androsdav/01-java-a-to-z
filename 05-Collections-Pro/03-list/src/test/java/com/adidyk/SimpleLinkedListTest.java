package com.adidyk;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {

    private SimpleLinkedList<User> listActual = new SimpleLinkedList<>();
    private SimpleLinkedList<User> listExpected = new SimpleLinkedList<>();
    private User tom;
    private User bill;
    private User bob;



    @Before
    public void init() {
        this.listActual.add(new User("0", "Bob", 10));
        this.listActual.add(new User("1", "Matilda", 11));
        this.listActual.add(new User("2", "Bill", 12));
        this.listActual.add(new User("3", "Donald", 13));
        this.listActual.add(new User("4", "Argon", 14));
        this.listActual.add(new User("5", "Will", 15));
        this.listActual.add(new User("6", "Amanda", 16));
        this.listActual.add(new User("7", "Sabrina", 17));
        this.listExpected.add(new User("0", "Bob", 10));
        this.listExpected.add(new User("1", "Matilda", 11));
        this.listExpected.add(new User("2", "Bill", 12));
        this.listExpected.add(new User("3", "Donald", 13));
        this.listExpected.add(new User("4", "Argon", 14));
        this.listExpected.add(new User("5", "Will", 15));
        this.listExpected.add(new User("6", "Amanda", 16));
        this.listExpected.add(new User("7", "Sabrina", 17));
    }

     @Test
    public void addTest() {
        assertThat(this.listActual, is(this.listExpected));
    }

    @Test
    public void getTest() {
        User result = this.listActual.get(4);
        assertThat(new User("4", "Argon", 14), is(result));
    }

    @Test
    public void getFirstTest() {
        User result = this.listActual.getFirst();
        assertThat(new User("0", "Bob", 10), is(result));
    }

    @Test
    public void getLast() {
        User result = this.listActual.getLast();
        assertThat(new User("7", "Sabrina", 17), is(result));
    }


}