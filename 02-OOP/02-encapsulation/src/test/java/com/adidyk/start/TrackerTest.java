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
    	Item item1 = new Item("task", "description1", 1);
    	Item item2 = new Item("task2", "description2", 2);
    	Item item3 = new Item("task3", "description3", 3);
    	Item item4 = new Item("task", "description4", 4);
    	Item[] items = {item1, item4};
		Tracker track = new Tracker();
    	track.addItem(item1);
    	track.addItem(item2);
    	track.addItem(item3);
    	track.addItem(item4);
    	Item[] result = track.searchItemByName(item1.getName());
    	assertThat(items, is(result));
    }
    
    @Test
    public void searchItemByDescriptionTest() {
    	Item item1 = new Item("task1", "description", 1);
    	Item item2 = new Item("task2", "description1", 2);
    	Item item3 = new Item("task3", "description", 3);
    	Item item4 = new Item("task4", "description", 4);
    	Tracker track = new Tracker();
		Item[] items = {item1, item3, item4};
    	track.addItem(item1);
    	track.addItem(item2);
    	track.addItem(item3);
    	track.addItem(item4);
    	Item[] result = track.searchItemByDescription(item4.getDescription());
    	assertThat(items, is(result));
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
    public void deleteItemByIdTest() {
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
    	track.deleteItemById(item3.getId());
    	Item[] result = track.getAllItem();
    	assertThat(items, is(result));
    }

	@Test
	public void renameItemByNameTest() {
		Item item1 = new Item("taskOld", "description", 1);
		Item item2 = new Item("task2", "description", 2);
		Item item3 = new Item("task3", "description", 3);
		Item item4 = new Item("taskOld", "description", 4);
		Item[] items = {item1, item2, item3, item4};
		Tracker track =new Tracker();
		track.addItem(item1);
		track.addItem(item2);
		track.addItem(item3);
		track.addItem(item4);
		track.searchItemByName("taskOld");
		track.renameItemByName("taskNew");
		Item[] result = track.getAllItem();
		assertThat(items, is(result));
	}

	@Test
	public void renameItemByDescriptionTest() {
		Item item1 = new Item("task1", "descriptionOld", 1);
		Item item2 = new Item("task2", "description", 2);
		Item item3 = new Item("task3", "descriptionOld", 3);
		Item item4 = new Item("task4", "descriptionOld", 4);
		Item[] items = {item1, item2, item3, item4};
		Tracker track =new Tracker();
		track.addItem(item1);
		track.addItem(item2);
		track.addItem(item3);
		track.addItem(item4);
		track.searchItemByDescription("descriptionOld");
		track.renameItemByDescription("descriptionNew");
		Item[] result = track.getAllItem();
		assertThat(items, is(result));
	}

	@Test
	public void updateItemByIdTest() {
		Item item1 = new Item("task", "description", 1);
		Item item2 = new Item("task", "description", 1);
		Item item3 = new Item("task", "description", 1);
		Tracker track = new Tracker();
		track.addItem(item1);
		track.addItem(item2);
		track.addItem(item3);
		item3.setName("task1");
		item3.setDescription("description1");
		item3.setCreate(2);
		Item[] items = {item1, item2, item3};
		track.searchItemById(item3.getId());
		track.updateItemById(item3);
		Item[] result = track.getAllItem();
		assertThat(items, is(result));
	}

	@Test
	public void addCommentByIdTest() {
		Item item1 = new Item("task", "description", 1);
		Item item2 = new Item("task", "description", 2);
		Item item3 = new Item("task", "description", 3);
		Item item4 = new Item("task", "description", 4);
		Item[] items = {item1, item2, item3, item4};
		Tracker track = new Tracker();
		track.addItem(item1);
		track.addItem(item2);
		track.addItem(item3);
		track.addItem(item4);
		track.searchItemById(item3.getId());
		track.addCommentById("comment1");
		track.addCommentById("comment2");
		track.addCommentById("comment3");
		Item[] result = track.getAllItem();
		assertThat(items, is(result));
	}

}
