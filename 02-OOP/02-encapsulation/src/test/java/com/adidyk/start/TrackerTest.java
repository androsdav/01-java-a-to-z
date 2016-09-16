package com.adidyk.start;

import com.adidyk.models.Item;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void addItemTest() {
        Item item = new Item("task", "description", 1);
        Tracker track = new Tracker();
        assertThat(track.addItem(item), is(item));
    }

    @Test
    public void getItemTest() {
        Item item1 = new Item("task1", "description1", 1);
        Item item2 = new Item("task2", "description2", 2);
        Item item3 = new Item("task3", "description3", 3);
        Item item4 = new Item("task4", "description1", 4);
        Item[] items = {item1, item2, item3, item4};
        Tracker track = new Tracker();
        track.addItem(item1);
        track.addItem(item2);
        track.addItem(item3);
        track.addItem(item4);
        assertThat(items, is(track.getAllItem()));
    }
}
