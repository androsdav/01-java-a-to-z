package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import static com.adidyk.setup.Constant.*;

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
        this.actions.add(1, new ShowAllItemWithComments());
        this.actions.add(2, new AddItem());
        this.actions.add(3, new SearchItemById());
        this.actions.add(4, new SearchItemByName());
        this.actions.add(5, new SearchItemByDescription());
        this.actions.add(6, new RemoveItemById());
        this.actions.add(7, new UpdateItemById());
        this.actions.add(8, new AddCommentById());
        this.actions.add(9, new Exit());
    }

    // select - select action
    void select(int key) throws SQLException {
        this.actions.get(key - 1).execute(this.input, this.tracker);
    }

    // show - show all menu
    void show() {
        menuTable();
        for (UserAction action: this.actions) {
            System.out.println(action.info());
        }
        menuSeparator();
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
     * @param tracker  - is tracker.
     * @throws SQLException - is exception.
     */
    private void outputAllItem(Tracker tracker, boolean getComments) throws SQLException {
        itemTable();
        for (Item item : tracker.getAllItem()) {
            System.out.println(item);
            itemSeparator();
            if (getComments) {
                if (tracker.searchCommentByItemId(item.getId()).size() != 0) {
                    this.outputAllComments(tracker, item);
                }
            }
        }
    }

    private void outputAllComments(Tracker tracker, Item item) throws SQLException {
        commentTable();
        for (Comment comment : tracker.searchCommentByItemId(item.getId())) {
            System.out.println(comment);
            commentSeparator();
        }
        System.out.println();
    }

     /**
     * Class ShowAllItem.
     */
    private class  ShowAllItem extends BaseAction {
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
            outputAllItem(tracker, false);
        }
    }

    /**
     * Class ShowAllItem.
     */
    private class ShowAllItemWithComments extends BaseAction {
        /**
         * Constructor.
         */
        private ShowAllItemWithComments() {
            super(" Show all item with comments.");
        }
        /**
         * key - returns key.
         * @return - returns key.
         */
        public int key() {
            return 2;
        }
        /**
         * execute - return all item, show all item.
         * @param input - is input.
         * @param tracker - is track.
         * @throws SQLException - is exception.
         */
        public void execute(Input input, Tracker tracker) throws SQLException {
            outputAllItem(tracker, true);
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
            return 3;
        }
        /**
         * execute - execute.
         * @param input - is input.
         * @param tracker - is tracker.
         * @throws SQLException - is exception.
         */
        public void execute(Input input, Tracker tracker) throws SQLException {
            String name = input.ask(" [action] input name item: ");
            String desc = input.ask(" [action] input desc item: ");
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
            return 4;
        }
        // execute - search item by id, key = 3
        public void execute(Input input, Tracker tracker) throws SQLException {
            String id = input.ask(" [action] input id: ");
            Item item = tracker.searchItemById(id);
            if (item != null) {
                itemTable();
                System.out.println(item);
                itemSeparator();
                if (tracker.searchCommentByItemId(item.getId()).size() != 0) {
                    outputAllComments(tracker, item);
                }
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
            return 5;
        }
        // execute - search item by name, key = 4
        public void execute(Input input, Tracker track) throws SQLException {
            String name = input.ask(" [action] input name item: ");
            boolean search = false;
            for (Item item : track.getAllItem()) {
                if (item.getName().equals(name)) {
                    search = true;
                    itemTable();
                    System.out.println(item);
                    itemSeparator();
                }
            }
            if(!search) {
                System.out.println(" [info] not result by name ...");
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
            return 6;
        }
        // execute - search item by description, key = 5
        public void execute(Input input, Tracker track) throws SQLException {
            String desc = input.ask(" [action] input desc item: ");
            boolean search = false;
            for (Item item : track.getAllItem()) {
                if (item.getDescription().contains(desc)) {
                    search = true;
                    itemTable();
                    System.out.println(item);
                }
                itemSeparator();
            }
            if (!search) {
                System.out.println(" [info] Not result by description");
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
            return 7;
        }
        // execute - remove item by id, key = 6
        public void execute(Input input, Tracker tracker) throws SQLException {
            String id = input.ask(" Input id: ");
            if (tracker.searchItemById(id) != null) {
                tracker.removeItemById(id);
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
            return 8;
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
            return 9;
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
            return 10;
        }
        // execute - exit, key = 9
        public void execute(Input input, Tracker track) {
        }
    }

}