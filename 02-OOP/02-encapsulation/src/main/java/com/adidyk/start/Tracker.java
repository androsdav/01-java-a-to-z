package com.adidyk.start;
import com.adidyk.models.Item;

public class Tracker {

    public static void main(String[] arg) {
        Item item = new Item("Andrey", "proverka text", 01);
        System.out.println(item.getName() +" " +item.getDescription() +" " +item.getCreate());
    }
}
