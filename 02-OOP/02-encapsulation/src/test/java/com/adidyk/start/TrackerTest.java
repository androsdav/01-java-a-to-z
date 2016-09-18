package com.adidyk.start;
import com.adidyk.models.Item;
import java.util.*;
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
    public void getAllItemTest() {
        Item item1 = new Item("task1", "description1", 1);
        Item item2 = new Item("task2", "description2", 2);
        Item item3 = new Item("task3", "description3", 3);
        Item item4 = new Item("task4", "description4", 4);
        Item[] items = {item1, item2, item3, item4};
        Tracker track = new Tracker();
        track.addItem(item1);
        track.addItem(item2);
        track.addItem(item3);
        track.addItem(item4);
        assertThat(items, is(track.getAllItem()));
    }
    
    @Test
    public void searchItemByIdTest() {
    	Item item1 = new Item("task1", "description1", 1);
    	Item item2 = new Item("task2", "description2", 2);
    	Item item3 = new Item("task3", "description3", 3);
    	Item item4 = new Item("task4", "description4", 4);
    	Tracker track = new Tracker();
    	track.addItem(item1);
    	track.addItem(item2);
    	track.addItem(item3);
    	track.addItem(item4);
    	Item result = track.searchItemById(item3.getId());
    	assertThat(item3, is(result));
    }
    
    @Test
    public void searchItemByNameTest() {
    	Item item1 = new Item("task1", "description1", 1);
    	Item item2 = new Item("task2", "description2", 2);
    	Item item3 = new Item("task3", "description3", 3);
    	Item item4 = new Item("task4", "description4", 4);
    	Tracker track = new Tracker();
    	track.addItem(item1);
    	track.addItem(item2);
    	track.addItem(item3);
    	track.addItem(item4);
    	Item result = track.searchItemByName(item3.getName());
    	assertThat(item3, is(result));
    }
    
    @Test
    public void searchItemByDescriptionTest() {
    	Item item1 = new Item("task1", "description1", 1);
    	Item item2 = new Item("task2", "description2", 2);
    	Item item3 = new Item("task3", "description3", 3);
    	Item item4 = new Item("task4", "description4", 4);
    	Tracker track = new Tracker();
    	track.addItem(item1);
    	track.addItem(item2);
    	track.addItem(item3);
    	track.addItem(item4);
    	Item result = track.searchItemByDescription(item3.getDescription());
    	assertThat(item3, is(result)); 	
    }
     
    @Test
    public void searchItemByCreateTest() {
    	Item item1 = new Item("task1", "description1", 1);
    	Item item2 = new Item("task2", "description2", 2);
    	Item item3 = new Item("task3", "description3", 3);
    	Item item4 = new Item("task4", "description4", 4);
    	Tracker track = new Tracker();
    	track.addItem(item1);
    	track.addItem(item2);
    	track.addItem(item3);
    	track.addItem(item4);
    	Item result = track.searchItemByCreate(item3.getCreate());
    	assertThat(item3, is(result));
    }
           
    @Test
    public void deleteItemIdTest() {
    	Item item1 = new Item("task1", "description1", 1);
    	Item item2 = new Item("task2", "description2", 2);
    	Item item3 = new Item("task3", "description3", 3);
    	Item item4 = new Item("task4", "description4", 4);
    	Item[] items = {item1, item2, item4};
    	Tracker track = new Tracker();
    	track.addItem(item1);
    	track.addItem(item2);
    	track.addItem(item3);
    	track.addItem(item4);
    	track.deleteItemId(item3.getId());
    	Item[] result = track.getAllItem();
    	assertThat(items, is(result));
    }

}
