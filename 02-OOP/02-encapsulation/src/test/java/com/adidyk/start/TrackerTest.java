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
		Item result = track.addItem(item);
		assertThat(result, is(item));
	}

	@Test
	public void getAllItemTest() {
		Item item1 = new Item("task1", "description1", 1);
		Item item2 = new Item("task2", "description2", 2);
		Item item3 = new Item("task3", "description3", 3);
		Item item4 = new Item("task4", "description4", 4);
		Item[] items = {item1, item2, item3, item4, null, null, null, null, null, null};
		Tracker track = new Tracker();
		track.addItem(item1);
		track.addItem(item2);
		track.addItem(item3);
		track.addItem(item4);
		Item[] result = track.getAllItem();
		assertThat(result, is(items));
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
		assertThat(result, is(item3));
	}

	@Test
	public void deleteItemByIdTest() {
		Item item1 = new Item("task1", "description1", 1);
		Item item2 = new Item("task2", "description2", 2);
		Item item3 = new Item("task3", "description3", 3);
		Item item4 = new Item("task4", "description4", 4);
		Item[] items = {item1, item2, null, item4, null, null, null, null, null, null};
		Tracker track = new Tracker();
		track.addItem(item1);
		track.addItem(item2);
		track.addItem(item3);
		track.addItem(item4);
		track.removeItemById(item3.getId());
		Item[] result = track.getAllItem();
		assertThat(result, is(items));
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
		Item[] items = {item1, item2, item3, null, null, null, null, null, null, null,};
		track.updateItemById(item3);
		Item[] result = track.getAllItem();
		assertThat(result, is(items));
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

		track.addCommentById(item3.getId(), "comment1");
		track.addCommentById(item3.getId(), "comment2");
		track.addCommentById(item3.getId(), "comment3");
		Item[] result = track.getAllItem();
		assertThat(result, is(items));
	}

}
