package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    private SimpleArray<String> list;

    @Before
    public void init() {
        this.list = new SimpleArray<>(1);
        this.list.add("1");
        this.list.add("2");
        this.list.add("3");
        this.list.add("4");
        this.list.add("5");
    }

    @Test
    public void addTest() {
        Object[] objects = new Object[]{"1", "2", "3", "4", "5"};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void addByIndexTest() {
        this.list.add(0, "test1");
        this.list.add(2, "test2");
        this.list.add(6, "test3");
        Object[] objects = new Object[]{"test1", "1", "test2", "2", "3", "4", "test3", "5"};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void setByIndexTest() {
        this.list.set(0, "test1");
        this.list.set(2, "test2");
        this.list.set(4, "test3");
        Object[] objects = new Object[]{"test1", "2", "test2", "4","test3"};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void setByObjectTest() {
        this.list.set("1", "10");
        this.list.set("3", "30");
        this.list.set("5", "50");
        Object[] objects= new Object[] {"10", "2", "30", "4", "50"};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void removeByObjectTest() {
        this.list.remove("1");
        this.list.remove("5");
        Object[] objects = new Object[]{"2", "3", "4"};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void removeByIndexTEst() {
        this.list.remove(1);
        Object[] objects = new Object[]{"1", "3", "4", "5"};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void getTest() {
        assertThat("4", is(this.list.get(3)));
    }

    @Test
    public void getAllTest() {
        Object[] objects = new Object[]{"1", "2", "3", "4", "5"};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void sizeTest() {
        this.list.add(0, "test1");
        this.list.add(2, "test2");
        this.list.add(6, "test3");
        this.list.add("7");
        this.list.add("8");
        assertThat(10, is(this.list.size()));
    }

}