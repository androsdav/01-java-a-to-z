package com.adidyk.start;

import com.adidyk.models.*;
import java.util.*;

class Tracker {

	private Item[] item = new Item[1];
	private static final Random RN = new Random();

	// addItem - add new item in []item
	Item addItem(Item item) {
		for (int index = 0; index < this.item.length; index++) {
			if (this.item[index] == null) {
				item.setId(this.generateId());
				this.item[index] = item;
				break;
			}
		}
		int length = 0;
		for (Item anItem : this.item) {
			if (anItem != null) {
				length++;
			}
		}
		if (length == this.item.length) {
			Item[] itemTemp = new Item[2 * this.item.length];
			System.arraycopy(this.item, 0, itemTemp, 0, this.item.length);
			this.item = itemTemp;
		}
		return item;
	}

	// getAllItem - return all []item
	Item[] getAllItem() {
		return this.item;
	}

	// searchItemById - search item by id in []item
	Item searchItemById(String id) {
		Item result = null;
		for (Item item : this.item) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

	// deleteItem - delete item by id in []item
	void removeItemById(String id) {
		for (int index = 0; index < this.item.length; index++ ) {
			if (this.item[index] != null && this.item[index].getId().equals(id)) {
				this.item[index] = null;
				break;
			}
		}
	}

	// updateItemById - update name, description, create in item by id
	void updateItemById(Item item) {
		for (int index = 0; index < this.item.length; index++) {
			if (this.item[index] != null && this.item[index].getId().equals(item.getId())) {
				this.item[index] = item;
				break;
			}
		}
	}

	// generateId - generate id for item
	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}

}