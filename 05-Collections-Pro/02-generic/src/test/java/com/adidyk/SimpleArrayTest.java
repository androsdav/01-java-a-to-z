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
    public void setTest() {
        this.list.set(0, "test1");
        this.list.set(2, "test2");
        this.list.set(4, "test3");
        Object[] objects = new Object[]{"test1", "2", "test2", "4","test3"};
        assertThat(objects, is(this.list.getAll()));
    }



}