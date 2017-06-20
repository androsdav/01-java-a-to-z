package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserStoreTest {

    private UserStore<User> list = new UserStore<>();
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
    public void setByObjectTest() {
        User bill = new User("2", "Bill", 18);
        User amanda = new User("7", "Amanda", 25);
        this.list.set(bill, amanda);
        Object[] objects = new Object[] {this.tom, new User("7", "Amanda", 25), this.bob};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void removeByObjectTest(){
        this.list.remove(new User("3", "Bob", 20));
        Object[] objects = new Object[] {this.tom, this.bill};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void getAllTest() {
        User evan = new User("6", "Evan", 33);
        this.list.add(new User("6", "Evan", 33));
        Object[] objects = new Object[] {this.tom, this.bill, this.bob, evan};
        assertThat(objects, is(this.list.getAll()));
    }

}