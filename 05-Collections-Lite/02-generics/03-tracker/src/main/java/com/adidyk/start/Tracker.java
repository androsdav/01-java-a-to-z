package com.adidyk.start;

import com.adidyk.models.*;
import java.util.*;

class Tracker {

	private ArrayList<Item> item = new ArrayList<>();
	private static final Random RN = new Random();

	// addItem - add new item in []item
	protected Item addItem(Item item) {
	    item.setId(this.generateId());
	    this.item.add(item);
		return item;
	}

	// getAllItem - return all []item
	protected ArrayList<Item> getAllItem() {
		return this.item;
	}

	// searchItemById - search item by id in []item
	protected Item searchItemById(String id) {
		Item result = null;
		for (Item item : this.item) {
			if (item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

	// deleteItem - delete item by id in []item
	protected void removeItemById(String id) {
		for (int index = 0; index < this.item.size(); index++) {
			if (this.item.get(index).getId().equals(id)) {
			    this.item.remove(index);
				break;
			}
		}
	}

	// updateItemById - update name, description, create in item by id
	protected void updateItemById(Item item) {
		for (int index = 0; index < this.item.size(); index++) {
			if (this.item.get(index).getId().equals(item.getId())) {
				this.item.set(index, item);
				break;
			}
		}
	}

	// addCommentById - add comment in item by id
	protected void addCommentById(String id, Comment comment) {
		for (Item item : this.item)
			if (item.getId().equals(id)) {
				item.addComment(comment);
				break;
			}
	}

	// generateId - generate id for item
	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}

}