package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;

import java.util.Date;

class MenuTracker {

    private Input input;
    private Tracker track;
    private UserAction[] actions = new UserAction[9];

    MenuTracker(Input input, Tracker track) {
        this.input = input;
        this.track = track;
    }

    void fillAction() {
        this.actions[0] = new ShowAllItem();
        this.actions[1] = new AddItem();
        this.actions[2] = new SearchItemById();
        this.actions[3] = new SearchItemByName();
        this.actions[4] = new SearchItemByDescription();
        this.actions[5] = new RemoveItemById();
        this.actions[6] = new UpdateItemById();
        this.actions[7] = new AddCommentById();
        this.actions[8] = new Exit();
    }

    void select(int key) {
        this.actions[key - 1].execute(this.input, this.track);
    }

    void show() {
        System.out.println("");
        System.out.println(" ------------------------------Tracker Menu --------------------------------");
        for (UserAction action: this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
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
                            System.out.println(comm.toString());
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

    // class AddItem,  key = 2
    private class AddItem implements UserAction {
        // key = 2
        public int key() {
            return 2;
        }
        // execute - add new item, key = 2
        public void execute(Input input, Tracker track) {
            String name = input.ask(" Input name item: ");
            String desc = input.ask(" Input description item: ");
            track.addItem(new Item(name, desc,  new Date().getTime()));
        }
        // info - menu item " Add new item."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Add new item.");
        }
    }

    // class SearchItemById, key = 3
    private class SearchItemById implements UserAction {
        // key = 3
        public int key() {
            return 3;
        }
        // execute - search item by id, key = 3
        public void execute(Input input, Tracker track) {
            String id = input.ask(" Input id: ");
            Item item = track.searchItemById(id);
            if (item != null) {
                System.out.println(item.toString());
                for (Comment comm : item.getAllComment()) {
                    if (comm != null) {
                        System.out.println(comm.toString());
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

    // class SearchItemByName, key = 4
    private class SearchItemByName implements UserAction {
        // key = 4
        public int key() {
            return 4;
        }
        // execute - search item by name, key = 4
        public void execute(Input input, Tracker track) {
            String name = input.ask(" Input name: ");
            for (Item item : track.getAllItem()) {
                if (item != null && item.getName().equals(name)) {
                    System.out.println(item.toString());
                    for (Comment comm : item.getAllComment()) {
                        if (comm != null) {
                            System.out.println(comm.toString());
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

    // class SearchItemByDescription, key = 5
    private class SearchItemByDescription implements UserAction {
        // key = 5
        public int key() {
            return 5;
        }
        // execute - search item by description, key = 5
        public void execute(Input input, Tracker track) {
            String desc = input.ask(" Input description: ");
            for (Item item : track.getAllItem()) {
                if (item != null && item.getDescription().contains(desc)) {
                    System.out.println(item.toString());
                    for (Comment comm : item.getAllComment()) {
                        if (comm != null) {
                            System.out.println(comm.toString());
                        }
                    }
                }
            }
        }
        // info - menu item " Search item by description."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Search item by description.");
        }
    }

    // class RemoveItemById, key = 6
    private class RemoveItemById implements UserAction {
        // key = 6
        public int key() {
            return 6;
        }
        // execute - remove item by id, key = 6
        public void execute(Input input, Tracker track) {
            String id = input.ask(" Input id: ");
            track.removeItemById(id);
        }
        // info - menu item " Remove item by id."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Remove item by id.");
        }
    }

    // class UpdateItemById, key = 7
    private class UpdateItemById implements UserAction {
        // key = 7
        public int key() {
            return 7;
        }
        // execute - update item by id, key = 7
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
                    item.addComment(comm);
                }
            }
        }
        // info - menu item " Update item by id."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Update item by id.");
        }
    }

    // class AddCommentById, key = 8
    private class AddCommentById implements UserAction {
        // key = 8
        public int key() {
            return 8;
        }
        // execute - add comment by id, key = 8
        public void execute(Input input, Tracker track) {
            String id = input.ask(" Input id: ");
            Comment comment = new Comment(input.ask(" Input comment: "));
            Item item = track.searchItemById(id);
            item.addComment(comment);
        }
        // info - menu item " Add comment by id."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Add comment by id.");
        }
    }

    // class Exit, key = 9
    private class Exit implements UserAction {
        // key = 9
        public int key() {
            return 9;
        }
        // execute - exit, key = 9
        public void execute(Input input, Tracker track) {
        }
        // info - menu item " Exit."
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Exit.");
        }
    }

}
