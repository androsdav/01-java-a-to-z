package com.adidyk.start;
import com.adidyk.models.Item;
import java.util.*;

public class Tracker {

    private Item[] item = new Item[1];
    private int position = 0;
    private static final Random RN = new Random();
	private Item[] itemSearch;
	private Item itemComm;
    
    public static void main(String[] arg) {
        System.out.println("Hello world");
    }

	// addItem - add new Item
    public Item addItem(Item item) {
        if (this.position == this.item.length)
        {
            Item[] itemTemp = new Item[2 * this.item.length];
            System.arraycopy(this.item, 0, itemTemp, 0, this.item.length);
            this.item = itemTemp;
        }
        item.setId(this.generateId());
        this.item[this.position++] = item;
        return item;
    }

    // getAllItem - return all Item
    public Item[] getAllItem() {
        Item[] result = new Item[this.position];
        System.arraycopy(this.item, 0, result, 0, this.position);
        return result;
    }

    // searchItemById - search Item by id
    protected Item searchItemById(String id) {
       	Item result = null;
		for (Item item : this.item) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break; 
			}
		}
		this.itemComm = result;
    	return result;
    }

    // searchItemByName - search Item by name
    protected Item[] searchItemByName(String name) {
		int length = 0;
		for (Item item : this.item) {
			if (item != null && item.getName().equals(name)) {
				length++;
			}
		}
		Item[] result = new Item[length];
		int index = 0;
		for (Item item : this.item) {
			if (item != null && item.getName().equals(name)) {
				result[index++] = item;
			}
		}
		this.itemSearch = result;
		return result;
	}

    // searchItemByDescription - search Item by description
    protected Item[] searchItemByDescription(String description) {
		int length = 0;
		for (Item item : this.item) {
			if (item != null && item.getDescription().equals(description)) {
				length++;
			}
		}
		Item[] result = new Item[length];
		int index = 0;
		for (Item item : this.item) {
			if (item != null && item.getDescription().equals(description)) {
				result[index++] = item;
			}
		}
		this.itemSearch = result;
		return result;
	}

    // searchItemByCreate - search Item by create
    protected Item searchItemByCreate(long create) {
    	Item result = null;
    	for (Item item : this.item) {
    		if (item != null && item.getCreate() == create) {
    			result = item;
    			break;
    		}
    	}
    	return result;
    }

    // deleteItem - delete Item by id
    protected void deleteItemById(String id) {
    	for (int i = 0; i < this.position; i++) {
    		if (this.item[i].getId().equals(id)) {
    			for (int j = i; j < this.position - 1; j++) {
    				this.item[j] = this.item[j + 1];
    			}
    			this.item[this.position - 1] = null;
    			this.position = this.position - 1;
    			break;
    		}
    	}
    }

	// renameItemByName - rename all Item by name
	protected void renameItemByName(String name) {
		for (Item item : this.itemSearch) {
			item.setName(name);
		}
	}

	// renameItemByDescription - rename all Item by description
	protected void renameItemByDescription(String description) {
		for (Item item : this.itemSearch) {
			item.setDescription(description);
		}
	}

    //protected
	protected void addCommentById(String comment) {
		this.itemComm.addComment(comment);
	}


	// generateId - gererate id
    String generateId() {
    	return String.valueOf(System.currentTimeMillis() + this.RN.nextInt());
    }
    
}
