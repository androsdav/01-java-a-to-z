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
    public void addByIndexTest() {
        User felix = new User("5", "Felix", 5);
        User rory = new  User("8", "Rory", 6);
        this.list.add(0, new User("5", "Felix", 5));
        this.list.add(3, new User("8", "Rory", 6));
        Object[] objects = new Object[] {felix, this.tom, this.bill, rory, this.bob};
        assertThat(objects, is(this.list.getAll()));

    }

    @Test
    public void setTest() {
        User amanda = new User("7", "Amanda", 25);
        this.list.set(1, new User("7", "Amanda", 25));
        Object[] objects = new Object[] {this.tom, amanda, this.bob};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void removeByObjectTest(){
        this.list.remove(new User("3", "Bob", 20));
        for (Object item : this.list.getAll()) {
            System.out.println(item);
        }
        Object[] objects = new Object[] {this.tom, this.bill};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void removeByIndexTest() {
        this.list.remove(0);
        Object[] objects = new Object[] {this.bill, this.bob};
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