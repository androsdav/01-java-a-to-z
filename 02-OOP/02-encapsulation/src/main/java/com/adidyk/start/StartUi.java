package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;
import java.util.*;

public class StartUi {

    private Tracker track = new Tracker();
    private Date date = new Date();

    // Main
    public static void main(String[] arg) {
        System.out.println();
        System.out.println(" -------------------- Show all methods of class Tracker --------------------");
        StartUi start = new StartUi();
        start.addItemTest();
        start.searchItemByIdTest();
        start.removeItemByIdTest();
        start.updateItemByIdTest();
        start.addCommentByIdTest();
    }

    // Testing method addItem
    private void addItemTest() {
        System.out.println();
        System.out.println(" 1) Testing method addItem:");
        System.out.println(" ---------------------------------------------------------------------------");
        this.track.addItem(new Item("task0", "desc0", this.date.getTime()));
        this.track.addItem(new Item("task1", "desc1", this.date.getTime()));
        this.track.addItem(new Item("task2", "desc2", this.date.getTime()));
        this.track.addItem(new Item("task3", "desc3", this.date.getTime()));
        this.track.addItem(new Item("task4", "desc4", this.date.getTime()));
        this.track.addItem(new Item("task5", "desc5", this.date.getTime()));
        Item[] result = this.track.getAllItem();
        for (Item item : result) {
            if (item != null) {
                System.out.println(item.toString(item));
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // Testing method searchItemById
    private void searchItemByIdTest() {
        System.out.println();
        System.out.println(" 2) Testing method searchItemById:");
        System.out.println(" ---------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id = items[1].getId();
        System.out.println(" -> Search by [id]: " +id);
        Item item = this.track.searchItemById(id);
        System.out.println(item.toString(item));
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // Testing method removeItemById
    private void removeItemByIdTest() {
        System.out.println();
        System.out.println(" 3) Testing method removeItemById:");
        System.out.println(" ---------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id = items[3].getId();
        System.out.println(" -> Remove by [id]: " +id);
        this.track.removeItemById(id);
        Item[] result = this.track.getAllItem();
        for (Item item : result) {
            if (item != null) {
                System.out.println(item.toString(item));
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // Testing method updateItemById
    private void updateItemByIdTest() {
        System.out.println();
        System.out.println(" 4) Testing method updateItemById:");
        System.out.println(" ---------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id = items[1].getId();
        System.out.println(" -> Update by [id]: " +id);
        Item itemUpdate = new Item("task9", "desc9", this.date.getTime());
        itemUpdate.setId(id);
        this.track.updateItemById(itemUpdate);
        Item[] result = this.track.getAllItem();
        for (Item item : result) {
            if (item != null) {
                System.out.println(item.toString(item));
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // Testing method addCommentById
    private void addCommentByIdTest() {
        System.out.println();
        System.out.println(" 5) Testing method addCommentById:");
        System.out.println(" ---------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id1 = items[0].getId();
        String id2 = items[1].getId();
        System.out.println(" -> Add comments by [id]: " +id1 +" and " +" [id]: " +id2);
        this.track.addCommentById(id1, new Comment("comm1"));
        this.track.addCommentById(id1, new Comment("comm2"));
        this.track.addCommentById(id1, new Comment("comm3"));
        this.track.addCommentById(id1, new Comment("comm4"));
        this.track.addCommentById(id2, new Comment("comm3"));
        this.track.addCommentById(id2, new Comment("comm2"));
        this.track.addCommentById(id2, new Comment("comm4"));
        Item[] result = this.track.getAllItem();
        for (Item item : result) {
            if (item != null) {
                System.out.println(item.toString(item));
                for (Comment comm : item.getAllComment()) {
                    if (comm != null) {
                        System.out.println("   - [comm]: " + comm.getComment());
                    }
                }
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

}
