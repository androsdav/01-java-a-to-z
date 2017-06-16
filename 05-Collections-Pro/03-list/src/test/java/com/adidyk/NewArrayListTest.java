package com.adidyk;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NewArrayListTest {

    private NewArrayList<User> list = new NewArrayList<>();
    private User tom;
    private User bill;
    private User bob;

    @Before
    public void init() {
        this.tom = new User("1", "Tom", 17);
        this.bill = new User("2", "Bill", 18);
        this.bob = new User("3", "Bob", 20);
        this.list.add(new User("1", "Tom", 17));
        this.list.add(new User("2", "Bill", 18));
        this.list.add(new User("3", "Bob", 20));
    }

    @Test
    public void addTest() {
        Object[] objects = new Object[] {this.tom, this.bill, this.bob};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void getTest() {
        assertThat(new User("3", "Bob", 20), is(this.list.get(2)));
    }

    @Test
    public void getAllTest() {
        User evan = new User("6", "Evan", 33);
        this.list.add(new User("6", "Evan", 33));
        Object[] objects = new Object[] {this.tom, this.bill, this.bob, evan};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void sizeTest() {
        assertThat(3, is(this.list.size()));
    }



}