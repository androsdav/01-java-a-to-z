package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {

    private RoleStore<Role> list = new RoleStore<>();
    private Role tom;
    private Role bill;
    private Role bob;

    @Before
    public void init() {
        this.tom = new Role("1", "Tom");
        this.bill = new Role("2", "Bill");
        this.bob = new Role("3", "Bob");
        this.list.add(new Role("1", "Tom"));
        this.list.add(new Role("2", "Bill"));
        this.list.add(new Role("3", "Bob"));
    }

    @Test
    public void addTest() {
        Object[] objects = new Object[] {this.tom, this.bill, this.bob};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void addByIndexTest() {
        Role felix = new Role("5", "Felix");
        Role rory = new  Role("8", "Rory");
        this.list.add(0, new Role("5", "Felix"));
        this.list.add(3, new Role("8", "Rory"));
        Object[] objects = new Object[] {felix, this.tom, this.bill, rory, this.bob};
        assertThat(objects, is(this.list.getAll()));

    }

    @Test
    public void setTest() {
        Role amanda = new Role("7", "Amanda");
        this.list.set(1, new Role("7", "Amanda"));
        Object[] objects = new Object[] {this.tom, amanda, this.bob};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void removeByObjectTest(){
        this.list.remove(new Role("3", "Bob"));
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
        assertThat(new Role("3", "Bob"), is(this.list.get(2)));
    }

    @Test
    public void getAllTest() {
        Role evan = new Role("6", "Evan");
        this.list.add(new Role("6", "Evan"));
        Object[] objects = new Object[] {this.tom, this.bill, this.bob, evan};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void sizeTest() {
        assertThat(3, is(this.list.size()));
    }

}