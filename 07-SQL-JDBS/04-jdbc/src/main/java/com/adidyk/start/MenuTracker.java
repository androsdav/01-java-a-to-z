package com.adidyk.start;

//import com.adidyk.models.Comment;
import com.adidyk.models.Comment;
import com.adidyk.models.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

class MenuTracker {

    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();

    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    // fillAction - array action
    void fillAction() {
        this.actions.add(0, new ShowAllItem());
        this.actions.add(1, new AddItem());
        this.actions.add(2, new SearchItemById());
        this.actions.add(3, new SearchItemByName());
        this.actions.add(4, new SearchItemByDescription());
        this.actions.add(5, new RemoveItemById());
        this.actions.add(6, new UpdateItemById());
        this.actions.add(7, new AddCommentById());
        this.actions.add(8, new Exit());
    }

    // select - select action
    void select(int key) throws SQLException {
        this.actions.get(key - 1).execute(this.input, this.tracker);
    }

    // show - show all menu
    void show() {
        System.out.println();
        System.out.println(" -----------TRACKER-MENU-------------");
        for (UserAction action: this.actions) {
            System.out.println(action.info());
        }
        System.out.println(" -------------------------------------");
    }

    // getIndexActions - get all index ranges key
    int[] getIndexActions() {
        int [] range = new int[this.actions.size()];
        for (int index = 0; index < this.actions.size(); index++) {
            range[index] = index + 1;
        }
        return range;
    }

     /**
     * Class ShowAllItem.
     */
    private class ShowAllItem extends BaseAction {
        /**
         * Constructor.
         */
        private ShowAllItem() {
            super(" Show all item.");
        }
        /**
         * key - returns key.
         * @return - returns key.
         */
        public int key() {
            return 1;
        }
        /**
         * execute - return all item, show all item.
         * @param input - is input.
         * @param tracker - is track.
         * @throws SQLException - is exception.
         */
        public void execute(Input input, Tracker tracker) throws SQLException {
            System.out.print(String.format(" %5s%3s %12s%8s %26s%14s %12s %n",
                    "id", "|", "item name", "|", "description", "|", "data_create"));
            System.out.println(" -------+--------------------+----------------------------------------+---------------");
            for (Item item : tracker.getAllItem()) {
                System.out.println(item);
                if (tracker.searchCommentByItemId(item.getId()).size() != 0) {
                    System.out.print(String.format("\n        %5s%3s %12s%8s %26s%14s %12s %n",
                            "id", "|", "comment name", "|", "description", "|", "data_create"));
                    System.out.println("        -------+--------------------+----------------------------------------+---------------");
                    for (Comment comment : tracker.searchCommentByItemId(item.getId())) {
                        System.out.println(comment);
                    }
                    System.out.println();
                }
            }
        }
    }

    /**
     * AddItem.
     */
    private class AddItem extends BaseAction {
        AddItem() {
            super(" Add new item.");
        }

        /**
         * key - is key.
         * @return key.
         */
        public int key() {
            return 2;
        }
        /**
         *
         * @param input - is input.
         * @param tracker - is tracker.
         * @throws SQLException - is exception.
         */
        public void execute(Input input, Tracker tracker) throws SQLException {
            String name = input.ask(" [action] input name item: ");
            String desc = input.ask(" [action] input description item: ");
            tracker.addItem(new Item(name, desc,  new Date().getTime()));
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
        public void execute(Input input, Tracker track) throws SQLException {
            String id = input.ask(" [action] input id: ");
            Item item = track.searchItemById(id);
            if (item != null) {
                System.out.print(String.format(" %5s%3s %12s%8s %26s%14s %12s %n",
                        "id", "|", "name", "|", "description", "|", "data_create"));
                System.out.println(" -------+--------------------+----------------------------------------+---------------");
                System.out.println(item);
            } else {
                System.out.println(" [info] there isn`t result for entered id ...");
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
        public void execute(Input input, Tracker track) throws SQLException {
            String name = input.ask(" Input name: ");
            boolean flagResult = false;
            for (Item item : track.getAllItem()) {
                if (item.getName().equals(name)) {
                    flagResult = true;
                    System.out.println(item);
                    /*
                    for (Comment comm : item.getAllComment()) {
                        System.out.println(comm);
                    }
                    */
                }
            }
            if(!flagResult) {System.out.println(" Not result by name");}
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
        public void execute(Input input, Tracker track) throws SQLException {
            String desc = input.ask(" Input description: ");
            boolean flagResult = false;
            for (Item item : track.getAllItem()) {
                if (item.getDescription().contains(desc)) {
                    flagResult =true;
                    System.out.println(item);
                    /*
                    for (Comment comm : item.getAllComment()) {
                        System.out.println(comm);
                    }
                    */
                }
            }
            if (!flagResult) {
                System.out.println(" Not result by description");
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
        public void execute(Input input, Tracker track) throws SQLException {
            String id = input.ask(" Input id: ");
            if (track.searchItemById(id) != null) {
                track.removeItemById(id);
            } else {
                System.out.println(" Not result by id");
            }
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
        public void execute(Input input, Tracker track) throws SQLException {
            String id = input.ask(" Input id: ");
            if (track.searchItemById(id) != null) {
                String name = input.ask(" Input new name item: ");
                String description = input.ask(" Input new description: ");
                long create = new Date().getTime();
                Item item = new Item(name, description, create);
                item.setId(id);
                Item result = track.searchItemById(id);
                track.updateItemById(item);
                /*
                ArrayList<Comment> comment = result.getAllComment();
                for (Comment comm : comment) {
                    track.addCommentById(id, comm);
                }
                */
            } else {
                System.out.println(" Not result by id");
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
        public void execute(Input input, Tracker tracker) throws SQLException {
            String id = input.ask(" Input id: ");
            if (tracker.searchItemById(id) != null) {
                String name = input.ask(" [action] input name comment: ");
                String desc = input.ask(" [action] input desc comment: ");
                tracker.addCommentById(id, new Comment(name, desc, new Date().getTime()));
            } else {
                System.out.println(" Not result by id");
            }
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