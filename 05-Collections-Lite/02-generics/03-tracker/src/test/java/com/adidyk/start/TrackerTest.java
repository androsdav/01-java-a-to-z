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
		itemActual.setId(itemExpected.getId());
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
		Tracker track = new Tracker();
		track.addItem(item3);
		track.addItem(item4);
		item1.setId(item3.getId());
		item2.setId(item4.getId());
		ArrayList<Item> itemExpected = track.getAllItem();
		assertThat(itemActual, is(itemExpected));
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
		Item itemActual = new Item("task3", "description3", 3);
		itemActual.setId(item3.getId());
		Item itemExpected = track.searchItemById(item3.getId());
		assertThat(itemActual, is(itemExpected));
	}

	@Test
	public void deleteItemByIdTest() {
		Item item1 = new Item("task1", "description1", 1);
		Item item2 = new Item("task2", "description2", 2);
		Item item3 = new Item("task4", "description4", 4);
		ArrayList<Item> itemActual = new ArrayList<>();
		itemActual.add(item1);
		itemActual.add(item2);
		itemActual.add(item3);
		Item item4 = new Item("task1", "description1", 1);
		Item item5 = new Item("task2", "description2", 2);
		Item item6 = new Item("task3", "description3", 3);
		Item item7 = new Item("task4", "description4", 4);
		Tracker track = new Tracker();
		track.addItem(item4);
		track.addItem(item5);
		track.addItem(item6);
		track.addItem(item7);
		item1.setId(item4.getId());
		item2.setId(item5.getId());
		item3.setId(item7.getId());
		track.removeItemById(item6.getId());
		ArrayList<Item> itemExpected = track.getAllItem();
		assertThat(itemActual, is(itemExpected));
	}

	@Test
	public void updateItemByIdTest() {
		Item item1 = new Item("task1", "description1", 1);
		Item item2 = new Item("task5", "description5", 5);
		Item item3 = new Item("task3", "description3", 3);
		ArrayList<Item> itemActual = new ArrayList<>();
		itemActual.add(item1);
		itemActual.add(item2);
		itemActual.add(item3);
		Item item4 = new Item("task1", "description1", 1);
		Item item5 = new Item("task2", "description2", 2);
		Item item6 = new Item("task3", "description3", 3);
		Tracker track = new Tracker();
		track.addItem(item4);
		track.addItem(item5);
		track.addItem(item6);
		item1.setId(item4.getId());
		item3.setId(item6.getId());
		item2.setId(item5.getId());
		Item item7 = new Item("task5", "description5", 5);
		item7.setId(item5.getId());
		track.updateItemById(item7);
		ArrayList<Item> itemExpected = track.getAllItem();
		assertThat(itemActual, is(itemExpected));
	}

	@Test
	public void addCommentByIdTest() {
		Item item1 = new Item("task1", "description1", 1);
		Item item2 = new Item("task2", "description2", 2);
		Comment comment1 = new Comment("comment1");
		Comment comment2 = new Comment("comment2");
		item1.addComment(comment1);
		item2.addComment(comment2);
		ArrayList<Item> itemActual = new ArrayList<>();
		itemActual.add(item1);
		itemActual.add(item2);
		Item item3 = new Item("task1", "description1", 1);
		Item item4 = new Item("task2", "description2", 2);
		Comment comment3 = new Comment("comment1");
		Comment comment4 = new Comment("comment2");
		Tracker track = new Tracker();
		track.addItem(item3);
		track.addItem(item4);
		track.addCommentById(item3.getId(), comment3);
		track.addCommentById(item4.getId(), comment4);
		item1.setId(item3.getId());
		item2.setId(item4.getId());
		ArrayList<Item> itemExpected = track.getAllItem();
		assertThat(itemActual, is(itemExpected));
	}

}