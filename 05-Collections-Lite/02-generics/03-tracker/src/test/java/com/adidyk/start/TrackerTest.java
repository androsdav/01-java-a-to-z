package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

	@Test
	public void addItemTest() {
		Item item = new Item("task", "description", 1);
		Item itemActual = new Item("task", "description", 1);
		Tracker track = new Tracker();
		Item itemExpected = track.addItem(item);
		assertThat(itemActual, is(itemExpected));
	}

	@Test
	public void getAllItemTest() {
		Item item1 = new Item("task1", "description1", 1);
		Item item2 = new Item("task2", "description2", 2);
		ArrayList<Item> itemActual = new ArrayList<>();
		itemActual.add(item1);
		itemActual.add(item2);

		Item item3 = new Item("task1", "description1", 1);
		Item item4 = new Item("task2", "description2", 2);

		//Item[] items = {item1, item2, item3, item4};
		Tracker track = new Tracker();
		track.addItem(item3);
		track.addItem(item4);
		ArrayList<Item> itemExpected = this.track.getAllItem();
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
		Item[] items = {item1, item2, item4};
		Tracker track = new Tracker();
		track.addItem(item1);
		track.addItem(item2);
		track.addItem(item3);
		track.addItem(item4);
		track.removeItemById(item3.getId());
		Item[] result = this.getAllItemWithoutNull(track.getAllItem());
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
		Item[] items = {item1, item2, item3};
		track.updateItemById(item3);
		Item[] result = this.getAllItemWithoutNull(track.getAllItem());
		assertThat(result, is(items));
	}

	@Test
	public void addCommentByIdTest() {
		Item item1 = new Item("task", "description", 1);
		Item item2 = new Item("task", "description", 2);
		Item item3 = new Item("task", "description", 3);
		Item item4 = new Item("task", "description", 4);
		Comment comment1 = new Comment("comment1");
		Comment comment2 = new Comment("comment2");
		Comment comment3 = new Comment("comment3");
		Comment comment4 = new Comment("comment4");
		Item[] items = {item1, item2, item3, item4};
		Tracker track = new Tracker();
		track.addItem(item1);
		track.addItem(item2);
		track.addItem(item3);
		track.addItem(item4);
		track.addCommentById(item1.getId(), comment1);
		track.addCommentById(item1.getId(), comment2);
		track.addCommentById(item1.getId(), comment3);
		track.addCommentById(item4.getId(), comment4);
		Item[] result = this.getAllItemWithoutNull(track.getAllItem());
		assertThat(result, is(items));

	}
	// getAllItemWithoutNull - method return all []item without null
	public Item[] getAllItemWithoutNull(Item[] resultAll) {
		int length = 0;
		for (Item item : resultAll) {
			if (item != null) {
				length++;
			}
		}
		Item[] resultWithoutNull = new Item[length];
		int index = 0;
		for (Item item : resultAll) {
			if (item != null) {
				resultWithoutNull[index++] = item;
			}
		}
		return resultWithoutNull;
	}

}
