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
        if (this.position == this.item.length)
        {
            Item[] itemTemp = new Item[2 * this.item.length];
            System.arraycopy(this.item, 0, itemTemp, 0, this.item.length);
            this.item = itemTemp;
        }
        this.item[this.position++] = item;
        return item;
    }

    public Item[] getAllItem() {
        Item[] result = new Item[this.position];
        System.arraycopy(this.item, 0, result, 0, this.position);
        return result;
    }
}
