package com.adidyk.start;

import com.adidyk.models.Item;
import java.util.*;

public class StartUi {

    Tracker track = new Tracker();
    Date date = new Date();

    // Main
    public static void main(String[] arg) {
        System.out.println();
        System.out.println(" ------------------------ Show all methods of class Tracker ------------------------");
        StartUi start = new StartUi();
        start.addItemTest();
        start.searchItemByIdTest();
        start.searchItemByNameTest();
        start.searchItemByDescriptionTest();
        start.searchItemByCreateTest();
        start.removeItemByIdTest();
        start.updateItemByIdTest();
        start.addCommentByIdTest();
        System.out.println(" -----------------------------------------------------------------------------------");
    }

    // Testing method addItem
    private void addItemTest() {
        System.out.println();
        System.out.println(" 1) Testing method addItem:");
        System.out.println(" -----------------------------------------------------------------------------------");
        this.track.addItem(new Item("task1", "description1", this.date.getTime()));
        this.track.addItem(new Item("task2", "description1", this.date.getTime()));
        this.track.addItem(new Item("task3", "description3", this.date.getTime()));
        this.track.addItem(new Item("task1", "description1", this.date.getTime()));
        this.track.addItem(new Item("task4", "description4", this.date.getTime()));
        this.track.addItem(new Item("task2", "description1", this.date.getTime()));
        this.track.addItem(new Item("task2", "description5", this.date.getTime()));
        Item[] result = this.track.getAllItem();
        for (Item item : result) {
            System.out.println(" - [name]: " +item.getName() +" [desc]:  " + item.getDescription() +" [create]: " +item.getCreate() +" [id]: " +item.getId());
        }
        System.out.println(" -----------------------------------------------------------------------------------");
    }

    // Testing method searchItemById
    private void searchItemByIdTest() {
        System.out.println();
        System.out.println(" 2) Testing method searchItemById:");
        System.out.println(" -----------------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id = items[3].getId();
        System.out.println(" -> Search by [id]: " +id);
       // System.out.println();
        Item result = this.track.searchItemById(id);
        System.out.println(" - [name]: " +result.getName() +" [desc]:  " + result.getDescription() +" [create]: " +result.getCreate() +" [id]: " +result.getId());
        System.out.println(" -----------------------------------------------------------------------------------");
    }

    // Testing method searchItemByName
    private void searchItemByNameTest() {
        System.out.println();
        System.out.println(" 3) Testing method searchItemByName:");
        System.out.println(" -----------------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String name = items[1].getName();
        System.out.println(" -> Search by [name]: " +name);
        //System.out.println();
        Item[] result = track.searchItemByName(name);
        for (Item item : result) {
            System.out.println(" - [name]: " +item.getName() +" [desc]:  " + item.getDescription() +" [create]: " +item.getCreate() +" [id]: " +item.getId());
        }
        System.out.println(" -----------------------------------------------------------------------------------");

    }

    //Testing method searchItemByDescription
    private void searchItemByDescriptionTest() {
        System.out.println();
        System.out.println(" 4) Testing method searchItemByDescription:");
        System.out.println(" -----------------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String description = items[0].getDescription();
        System.out.println( "-> Search by [desc]: " +description);
        //System.out.println();
        Item[] result = track.searchItemByDescription(description);
        for (Item item : result) {
            System.out.println(" - [name]: " +item.getName() +" [desc]:  " + item.getDescription() +" [create]: " +item.getCreate() +" [id]: " +item.getId());
        }
        System.out.println(" -----------------------------------------------------------------------------------");
    }

    // Testing method searchItemByDescription
    private void searchItemByCreateTest() {
        System.out.println();
        System.out.println(" 5) Testing method searchItemByCreate:");
        System.out.println(" -----------------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        long create = items[0].getCreate();
        System.out.println(" -> Search by [create]: " +create);
        //System.out.println();
        Item result = track.searchItemByCreate(create);
        System.out.println(" - [name]: " +result.getName() +" [desc]:  " + result.getDescription() +" [create]: " +result.getCreate() +" [id]: " +result.getId());
        System.out.println(" -----------------------------------------------------------------------------------");
    }

    // Testing method removeItemById
    private void removeItemByIdTest() {
        System.out.println();
        System.out.println(" 6) Testing method removeItemById:");
        System.out.println(" -----------------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id = items[4].getId();
        System.out.println(" -> Remove by [id]: " +id);
        //System.out.println();
        track.removeItemById(id);
        Item[] result = this.track.getAllItem();
        for (Item item : result) {
            System.out.println(" - [name]: " +item.getName() +" [desc]:  " + item.getDescription() +" [create]: " +item.getCreate() +" [id]: " +item.getId());
        }
        System.out.println(" -----------------------------------------------------------------------------------");
    }

    // Testing method updateItemById
    private void updateItemByIdTest() {
        System.out.println();
        System.out.println(" 7) Testing method updateItemById:");
        System.out.println(" -----------------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id = items[4].getId();
        System.out.println(" -> Update by [id]: " +id);
        Item itemUpdate = new Item("task9", "description9", this.date.getTime());
        itemUpdate.setId(id);
        track.updateItemById(itemUpdate);
        Item[] result = track.getAllItem();
        for (Item item : result) {
            System.out.println(" - [name]: " +item.getName() +" [desc]:  " + item.getDescription() +" [create]: " +item.getCreate() +" [id]: " +item.getId());
        }
    }

    // Testing method addCommentById
    private void addCommentByIdTest() {
        System.out.println();
        System.out.println(" 8) Testing method addCommentById:");
        System.out.println("-----------------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id1 = items[1].getId();
        String id2 = items[4].getId();
        System.out.println(" -> Update by [id]: " +id1 +" and " +" [id]: " +id2);
        track.addCommentById(id1, "comment1");
        track.addCommentById(id1, "comment2");
        track.addCommentById(id1, "comment3");
        track.addCommentById(id1, "comment4");
        track.addCommentById(id2, "comment1");
        track.addCommentById(id2, "comment2");
        track.addCommentById(id2, "comment3");
        Item[] result = track.getAllItem();
        for (Item item : result) {
            System.out.println(" - [name]: " +item.getName() +" [desc]:  " + item.getDescription() +" [create]: " +item.getCreate() +" [id]: " +item.getId());
            if(item.getAllComment() != null) {
                String[] comments = item.getAllComment();
                for (String comm : comments) {
                    System.out.println("   - [comment]:" +comm);
                }
            }
        }
    }

}
