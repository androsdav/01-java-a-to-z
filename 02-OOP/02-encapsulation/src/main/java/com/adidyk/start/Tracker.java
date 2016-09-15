package com.adidyk.start;
import com.adidyk.models.Item;

public class Tracker {

    public Item[] item = new Item[1];
    public int position = 0;

    public static void main(String[] arg) {
        //Item item = new Item("Andrey", "proverka text", 01);
        //System.out.println(item.getName() +" " +item.getDescription() +" " +item.getCreate());
        System.out.println("Hello world");
    }

    public Item addItem(Item item) {
        this.item[this.position] = item;
        return item;
    }

    public Item[] getItem() {
        return this.item;
    }
}
