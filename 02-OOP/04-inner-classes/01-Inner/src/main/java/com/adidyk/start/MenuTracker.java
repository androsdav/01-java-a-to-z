package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;

import java.util.Date;

public class MenuTracker {

    private Input input;
    private Tracker track;
    private UserAction[] actions = new UserAction[5];

    public MenuTracker(Input input, Tracker track) {
        this.input = input;
        this.track = track;
    }

    public void fillAction() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItem();
        this.actions[2] = new SearchItemById();
        this.actions[3] = new SearchItemByName();
//        System.out.println(this.actions[0]);
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.track);
    }

    public void show() {
        System.out.println(" ------------------------------Tracker Menu --------------------------------");
        for (UserAction action: this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // class AddItem,  key = 0
    private class AddItem implements UserAction {
        // key = 0
        public int key() {
            return 0;
        }
        // execute - add new item, key = 0
        public void execute(Input input, Tracker track) {
            String name = input.ask(" Input name item: ");
            String desc = input.ask(" Input desc item: ");
            track.addItem(new Item(name, desc,  new Date().getTime()));
        }
        // info - Add new item
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Add new item.");
        }
    }

    // class ShowAllItem, key = 1
    private class ShowAllItem implements UserAction {
        // key = 1
        public int key() {
            return 1;
        }
        // execute - show all item, key = 1
        public void execute(Input input, Tracker track) {
            for (Item item : track.getAllItem()) {
                if (item != null) {
                    System.out.println(item.toString());
                    for (Comment comm : item.getAllComment()) {
                        if (comm != null) {
                            System.out.println("- [comm]: " +comm.getComment());
                        }
                    }
                }
            }
        }
        // info - menu item " Show all item."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Show all item.");
        }
    }

    // class SearchItemById, key = 2
    private class SearchItemById implements UserAction {
        // key = 2
        public int key() {
            return 2;
        }
        // execute - search item by id, key = 3
        public void execute(Input input, Tracker track) {
            String id = input.ask(" Input id: ");
            Item item = track.searchItemById(id);
            if (item != null) {
                System.out.println(item.toString());
                for (Comment comm : item.getAllComment()) {
                    if (comm != null) {
                        System.out.println("   - [comm]: " + comm.getComment());
                    }
                }
            } else {
                System.out.println(" No result by id");
            }
        }
        // info - menu item " Search item by id."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Search item by id.");
        }
    }

    // class SearchItemByName, key = 3
    private class SearchItemByName implements UserAction {
        // key = 3
        public int key() {
            return 3;
        }
        // execute - search item by name, key = 3
        public void execute(Input input, Tracker track) {
            String name = input.ask(" Input name: ");
            for (Item item : track.getAllItem()) {
                if (item != null && item.getName().equals(name)) {
                    System.out.println(item.toString());
                    for (Comment comm : item.getAllComment()) {
                        if (comm != null) {
                            System.out.println("   - [comm]: " + comm.getComment());
                        }
                    }
                }
            }
        }
        // info - menu item " Search item by name."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Search item by name.");
        }
    }




}
