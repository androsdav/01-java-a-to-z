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

    // fillAction - array action
    protected void fillAction() {
        this.actions[0] = this.new ShowAllItem();
        this.actions[1] = new AddItem();
        this.actions[2] = new SearchItemById();
        this.actions[3] = new SearchItemByName();
        this.actions[4] = new SearchItemByDescription();
        this.actions[5] = new RemoveItemById();
        this.actions[6] = new UpdateItemById();
        this.actions[7] = new AddCommentById();
        this.actions[8] = new Exit();
    }

    // select - select action
    protected void select(int key) {
        this.actions[key - 1].execute(this.input, this.track);
    }

    // show - show all menu
    protected void show() {
        System.out.println("");
        System.out.println(" ------------------------------Tracker Menu --------------------------------");
        for (UserAction action: this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // getIndexActions - get all index ranges key
    protected int[] getIndexActions() {
        int [] range = new int[this.actions.length];
        for (int index = 0; index < this.actions.length; index++) {
            range[index] = index + 1;
        }
        return range;
    }

    // class ShowAllItem, key = 1
    private class ShowAllItem extends BaseAction {
        public ShowAllItem() {
            super(" Show all item.");
        }
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
    }

    // class AddItem,  key = 2
    private class AddItem extends BaseAction {
        AddItem() {
            super(" Add new item.");
        }
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
    }

    // class SearchItemById, key = 3
    private class SearchItemById extends BaseAction {
        SearchItemById() {
            super(" Search item by id.");
        }
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
                System.out.println(" Not result by id.");
            }
        }
    }

    // class SearchItemByName, key = 4
    private class SearchItemByName extends BaseAction {
        SearchItemByName() {
            super(" Search item by name.");
        }
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
    }

    // class SearchItemByDescription, key = 5
    private class SearchItemByDescription extends BaseAction {
        SearchItemByDescription() {
            super(" Search item by description.");
        }
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
    }

    // class RemoveItemById, key = 6
    private class RemoveItemById extends BaseAction {
        RemoveItemById() {
            super(" Remove item by id.");
        }
        // key = 6
        public int key() {
            return 6;
        }
        // execute - remove item by id, key = 6
        public void execute(Input input, Tracker track) {
            String id = input.ask(" Input id: ");
            track.removeItemById(id);
        }
    }

    // class UpdateItemById, key = 7
    private class UpdateItemById extends BaseAction {
        UpdateItemById() {
            super(" Update item by id.");
        }
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
                    track.addCommentById(id, comm);
                }
            }
        }
    }

    // class AddCommentById, key = 8
    private class AddCommentById extends BaseAction {
        AddCommentById() {
            super(" Add comment by id.");
        }
        // key = 8
        public int key() {
            return 8;
        }
        // execute - add comment by id, key = 8
        public void execute(Input input, Tracker track) {
            String id = input.ask(" Input id: ");
            Comment comment = new Comment(input.ask(" Input comment: "));
            track.addCommentById(id, comment);
        }
    }

    // class Exit, key = 9
    private class Exit extends BaseAction {
        Exit() {
            super(" Exit.");
        }
        // key = 9
        public int key() {
            return 9;
        }
        // execute - exit, key = 9
        public void execute(Input input, Tracker track) {
        }
    }

}
