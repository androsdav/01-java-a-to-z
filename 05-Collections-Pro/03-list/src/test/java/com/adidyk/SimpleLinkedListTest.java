package com.adidyk;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {

    private SimpleLinkedList<User> list = new SimpleLinkedList<>();
    private SimpleLinkedList<User> listExpected = new SimpleLinkedList<>();
    private User tom;
    private User bill;
    private User bob;



    @Before
    public void init() {
        list.add(new User("0", "Bob", 10));
        list.add(new User("1", "Matilda", 11));
        list.add(new User("2", "Bill", 12));
        list.add(new User("3", "Donald", 13));
        list.add(new User("4", "Argon", 14));
        list.add(new User("5", "Will", 15));
        list.add(new User("6", "Amanda", 16));
        list.add(new User("7", "Sabrina", 17));
        listExpected.add(new User("0", "Bob", 10));
        listExpected.add(new User("1", "Matilda", 11));
        listExpected.add(new User("2", "Bill", 12));
        listExpected.add(new User("3", "Donald", 13));
        listExpected.add(new User("4", "Argon", 14));
        listExpected.add(new User("5", "Will", 15));
        listExpected.add(new User("6", "Amanda", 16));
        listExpected.add(new User("7", "Sabrina", 17));
    }

    @Test
    public void addTest() {
        User result = this.list.get(4);
        assertThat(new User("4", "Argon", 14), is(result));
    }


}