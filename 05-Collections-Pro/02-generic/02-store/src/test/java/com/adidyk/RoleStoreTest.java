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
    public void setByObjectTest() {
        Role amanda = new Role("7", "Amanda");
        Role bob = new Role("3", "Bob");
        this.list.set(bob, amanda);
        Object[] objects = new Object[] {this.tom, this.bill, amanda};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void removeByObjectTest(){
        this.list.remove(new Role("3", "Bob"));
        Object[] objects = new Object[] {this.tom, this.bill};
        assertThat(objects, is(this.list.getAll()));
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