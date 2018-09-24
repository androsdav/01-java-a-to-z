package com.adidyk.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void itemTest() {
        Item work = new Item("Work", "I search work", 100);
        work.setId("1");
        Item job = new Item("Work", "I search work", 100);
        job.setId("1");
        assertThat(work, is(job));
    }

    @Test
    public void itemSetIdTest() {
        Item work = new Item("Work", "I search work", 100);
        work.setId("1");
        Item job = new Item("Work", "I search work", 100);
        job.setId("1");
        assertThat(work, is(job));
    }

}