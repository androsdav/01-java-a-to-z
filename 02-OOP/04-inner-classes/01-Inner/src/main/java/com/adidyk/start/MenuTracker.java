package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;

import java.util.Date;

public class MenuTracker {

    private Input input;
    private Tracker track;
    private UserAction[] actions = new UserAction[10];

    public MenuTracker(Input input, Tracker track) {
        this.input = input;
        this.track = track;
    }

    public void fillAction() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItem();
        this.actions[2] = new SearchItemById();
        this.actions[3] = new SearchItemByName();
        this.actions[4] = new SearchItemByDescription();
        this.actions[5] = new RemoveItemById();
        this.actions[6] = new UpdateItemById();
        this.actions[7] = new AddCommentById();
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

    // class SearchItemByDescription, key = 4
    private class SearchItemByDescription implements UserAction {
        // key = 4
        public int key() {
            return 4;
        }
        // execute - search item by description, key = 4
        public void execute(Input input, Tracker track) {
            String desc = input.ask(" Input description: ");
            //Item[] result = track.getAllItem();
            for (Item item : track.getAllItem()) {
                if (item != null && item.getDescription().contains(desc)) {
                    System.out.println(item.toString());
                    for (Comment comm : item.getAllComment()) {
                        if (comm != null) {
                            System.out.println("   - [comm]: " + comm.getComment());
                        }
                    }
                }
            }
        }
        // info - menu item " Search item by description."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Search item by name.");
        }
    }

    // class RemoveItemById, key = 5
    private class RemoveItemById implements UserAction {
        // key = 5
        public int key() {
            return 5;
        }
        // execute - remove item by id, key = 5
        public void execute(Input input, Tracker track) {
            String id = input.ask(" Input id: ");
            track.removeItemById(id);
        }
        // info - menu item " Update item by id."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Remove item by id.");
        }
    }

    // class UpdateItemById, key = 6
    private class UpdateItemById implements UserAction {
        // key = 6
        public int key() {
            return 6;
        }
        // execute - update item by id, key = 6
        public void execute(Input input, Tracker track) {
            String id = input.ask(" Input id: ");
            String name = input.ask(" Input new name item: ");
            String description = input.ask(" Input new description: ");
            long create = new Date().getTime();
            Item item = new Item(name, description, create);
            item.setId(id);
            Item result = track.searchItemById(id);
            track.updateItemById(item);
            Comment[] comment = result.getAllComment();
            for (Comment comm : comment) {
                if (comm != null) {
                    track.addCommentById(id, comm);
                }
            }
        }
        // info - menu item " Update item by id."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Update item by id.");
        }
    }

    // class AddCommentById, key = 7
    private class AddCommentById implements UserAction {
        // key = 7
        public int key() {
            return 7;
        }
        // execute - add comment by id, key = 7
        public void execute(Input input, Tracker track) {
            String id = input.ask(" Input id: ");
            Comment comment = new Comment(input.ask(" Input comment: "));
            track.addCommentById(id, comment);
        }
        // info - menu item " Add comment by id."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Add comment by id.");
        }
    }

}
