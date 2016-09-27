package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;
import java.util.*;

public class StartUi {

    Tracker track = new Tracker();
    Date date = new Date();

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
       // System.out.println();
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
        //System.out.println();
        track.removeItemById(id);
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
        track.updateItemById(itemUpdate);
        Item[] result = track.getAllItem();
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
        Comment comment1 = new Comment("comm1");
        Comment comment2 = new Comment("comm2");
        Comment comment3 = new Comment("comm3");
        Comment comment4 = new Comment("comm4");
        System.out.println(" -> Add comments by [id]: " +id1 +" and " +" [id]: " +id2);
        track.addCommentById(id1, comment1);
        track.addCommentById(id1, comment2);
        track.addCommentById(id1, comment3);
        track.addCommentById(id1, comment4);
        track.addCommentById(id2, comment3);
        track.addCommentById(id2, comment2);
        track.addCommentById(id2, comment4);
        for (Item item : track.getAllItem()) {
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
