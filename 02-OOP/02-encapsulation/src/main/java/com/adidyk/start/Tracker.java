package com.adidyk.start;
import com.adidyk.models.Item;
import java.util.*;

public class Tracker {

    private Item[] item = new Item[1];
    private int position = 0;
    private static final Random RN = new Random();
    
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
    	return result;
    }
    // searchItemByName - search Item by name
    protected Item searchItemByName(String name) {
    	Item result = null;
    	for (Item item : this.item) {
    		if (item != null && item.getName().equals(name)) {
    			result = item;
    		}
    	}
    	return result;
    }
    // searchItemByDescription - search Item by description
    protected Item searchItemByDescription(String description) {
    	Item result = null;
    	for (Item item : this.item) {
    		if (item != null && item.getDescription().equals(description)) {
    			result = item;
    		}
    	}
    	return result;
    }
    // searchItemByCreate - search Item by create
    protected Item searchItemByCreate(long create) {
    	Item result = null;
    	for (Item item : this.item) {
    		if (item != null && item.getCreate() == create) {
    			result = item;
    		}
    	}
    	return result;
    }
    // generateId - gererate id
    String generateId() {
    	return String.valueOf(System.currentTimeMillis() + this.RN.nextInt());
    }
    
}
