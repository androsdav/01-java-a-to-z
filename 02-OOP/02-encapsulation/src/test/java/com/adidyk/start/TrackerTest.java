package com.adidyk.start;

import com.adidyk.models.Item;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void addItemTest() {
      //  Item[] itemActual = new Item[1];
      //  itemActual[0].setName("bag");
      //  itemActual[0].setDescription("It doesn't work");
      //  itemActual[0].setCreate(300);


        Item item = new Item("bg", "It doesn't work", 1);
        Item itemActual = new Item("bag", "It doesn't work", 300);

        Tracker track = new Tracker();
        Item result = track.addItem(item);
        assertThat(result, is(itemActual));


/*        Item[] itemActual = new Item[1];
        itemActual[0].setName("bag");
        itemActual[0].setDescription("It doesn't work");
        itemActual[0].setCreate(300);

        Item item = new Item("bag", "It doesn't work", 300);
        Tracker tracker = new Tracker();
        tracker.addItem(item);

        Item[] result = tracker.getItem();
        assertThat(result, is(itemActual));*/

    }
}
