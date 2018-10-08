package com.adidyk.start;

import com.adidyk.input.Input;
import com.adidyk.models.Comment;
import com.adidyk.models.Item;
import org.slf4j.LoggerFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import static com.adidyk.setup.Constant.*;

/**
 * Class MenuTracker used for creates index menu and for work with database base_tracker.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
class MenuTracker {

    /**
     * @param input - link variable to object of class ValidateInput.
     */
    private Input input;

    /**
     * @param tracker - link variable to object of class Tracker.
     */
    private Tracker tracker;

    /**
     * @param action - link variable to ArrayList<UserAction>.
     */
    private ArrayList<UserAction> actions = new ArrayList<>();

    /**
     * @param log - link variable to object of class Logger.
     */
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(MenuTracker.class);

    /**
     * MenuTracker - constructor.
     * @param input - link variable to object of class ValidateInput.
     * @param tracker - link variable to object of class Tracker.
     */
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * fillAction - adds to array list (menu) objects of class ShowAllItem, ShowAllItemWithComments, AddItem,
     * SearchItemById, SearchItemByName, SearchItemByDescription, RemoveItemById, UpdateItemById, AddCommentById, Exit.
     */
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

    /**
     * select - selects action (мфдгу) by key.
     * @param key - key of index menu.
     */
    void select(int key) {
        try {
            this.actions.get(key - 1).execute(this.input, this.tracker);
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * show - show all information about method of execute and number of index menu.
     */
    void show() {
        menuTable();
        for (UserAction action: this.actions) {
            System.out.println(action.info());
        }
        menuSeparator();
    }

    /**
     * getIndexActions - returns array of all numbers of index menu.
     * @return - returns array of all numbers of index menu.
     */
    int[] getIndexActions() {
        int[] range = new int[this.actions.size()];
        for (int index = 0; index < this.actions.size(); index++) {
            range[index] = index + 1;
        }
        return range;
    }

    /**
     * outputAllItem - shows all items with comments if getComments = true or without comments
     * if getComments = false.
     * @param tracker - link variable to object of class Tracker.
     * @param getComments - if getComments = true comments are showed,
     * if getComments = false comments are not showed.
     */
    private void outputAllItem(Tracker tracker, boolean getComments) {
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

    /**
     * outputAllComments - shows all comments for item by id.
     * @param tracker - link variable to object of class Tracker.
     * @param item - link variable to object of class Item.
     */
    private void outputAllComments(Tracker tracker, Item item) {
        commentTable();
        for (Comment comment : tracker.searchCommentByItemId(item.getId())) {
            System.out.println(comment);
            commentSeparator();
        }
        System.out.println();
    }

    /**
     * Class ShowAllItem shows all items without comments.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class  ShowAllItem extends BaseAction {

        /**
         * ShowAllItem - constructor.
         */
        private ShowAllItem() {
            super(" Show all item.");
        }

        /**
         * key - returns number of index of menu (1).
         * @return - returns number of index of menu (1).
         */
        @Override
        public int key() {
            return 1;
        }

        /**
         * execute - shows all items without comments.
         * @param input - link variable to object of class ValidateInput.
         * @param tracker - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            outputAllItem(tracker, false);
        }

    }

    /**
     * Class ShowAllItemWithComments shows all item with comments.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class ShowAllItemWithComments extends BaseAction {

        /**
         * ShowAllItemWithComments - constructor.
         */
        private ShowAllItemWithComments() {
            super(" Show all item with comments.");
        }

        /**
         * key - returns number of index of menu (2).
         * @return - returns number of index of menu (2).
         */
        @Override
        public int key() {
            return 2;
        }

        /**
         * execute - shows all items with comments.
         * @param input - link variable to object of class ValidateInput.
         * @param tracker - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            outputAllItem(tracker, true);
        }

    }

    /**
     * Class AddItem adds new item.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class AddItem extends BaseAction {

        /**
         * AddItem - constructor.
         */
        AddItem() {
            super(" Add new item.");
        }

        /**
         * key - returns number of index of menu (3).
         * @return - returns number of index of menu (3).
         */
        @Override
        public int key() {
            return 3;
        }

        /**
         * execute - adds new item.
         * @param input - link variable to object of class ValidateInput.
         * @param tracker - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask(" [action] input name item: ");
            String desc = input.ask(" [action] input desc item: ");
            tracker.addItem(new Item(name, desc,  new Date().getTime()));
        }

    }

    /**
     * SearchItemById shows search result - search item by id.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class SearchItemById extends BaseAction {

        /**
         * SearchItemById - constructor.
         */
        SearchItemById() {
            super(" Search item by id.");
        }

        /**
         * key - returns number of index of menu (4).
         * @return - returns number of index of menu (4).
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * execute - shows search result - search item by id.
         * @param input - link variable to object of class ValidateInput.
         * @param tracker - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.askInt(" [action] input id: ");
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

    /**
     * Class SearchItemByName shows all items for set name.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class SearchItemByName extends BaseAction {

        /**
         * SearchItemByName - constructor.
         */
        SearchItemByName() {
            super(" Search item by name.");
        }

        /**
         * key - returns number of index of menu (5).
         * @return - returns number of index of menu (5).
         */
        @Override
        public int key() {
            return 5;
        }

        /**
         * execute - shows all items for set name.
         * @param input - link variable to object of class ValidateInput.
         * @param tracker - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask(" [action] input name item: ");
            boolean search = false;
            for (Item item : tracker.getAllItem()) {
                if (name.equals(item.getName())) {
                    if (!search) {
                        itemTable();
                    }
                    System.out.println(item);
                    itemSeparator();
                    search = true;
                }
            }
            if (!search) {
                System.out.println(" [info] not result by name ...");
            }
        }

    }

    /**
     * Class SearchItemByDescription shows all items for set description item (sets substring description).
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class SearchItemByDescription extends BaseAction {

        /**
         * SearchItemByDescription - constructor.
         */
        SearchItemByDescription() {
            super(" Search item by description.");
        }

        /**
         * key - returns number of index of menu (6).
         * @return - returns number of index of menu (6).
         */
        @Override
        public int key() {
            return 6;
        }

        /**
         * execute - shows all items for set description.
         * @param input - link variable to object of class ValidateInput.
         * @param tracker - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String desc = input.ask(" [action] input desc item: ");
            boolean search = false;
            for (Item item : tracker.getAllItem()) {
                if (item.getDescription().contains(desc)) {
                    if (!search) {
                        itemTable();
                    }
                    System.out.println(item);
                    itemSeparator();
                    search = true;
                }
            }
            if (!search) {
                System.out.println(" [info] not result by description ... ");
            }
        }

    }

    /**
     * Class RemoveItemById removes item by id.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class RemoveItemById extends BaseAction {

        /**
         * RemoveItemById - constructor.
         */
        RemoveItemById() {
            super(" Remove item by id.");
        }

        /**
         * key - returns number of index of menu (7).
         * @return - returns number of index of menu (7).
         */
        @Override
        public int key() {
            return 7;
        }

        /**
         * execute - removes item by id.
         * @param input - link variable to object of class ValidateInput.
         * @param tracker - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.askInt(" [action] input id: ");
            if (tracker.searchItemById(id) != null) {
                tracker.removeItemById(id);
            } else {
                System.out.println(" [info] not result by id ... ");
            }
        }

    }

    /**
     * Class UpdateItemById updates item by id.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class UpdateItemById extends BaseAction {

        /**
         * UpdateItemById - constructor.
         */
        UpdateItemById() {
            super(" Update item by id.");
        }

        /**
         * key - returns number of index of menu (8).
         * @return - returns number of index of menu (8).
         */
        @Override
        public int key() {
            return 8;
        }

        /**
         * execute - update item by id.
         * @param input - link variable to object of class ValidateInput.
         * @param tracker - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.askInt(" [action] input id: ");
            if (tracker.searchItemById(id) != null) {
                String name = input.ask(" [action] input new name item: ");
                String description = input.ask(" [action] input new description item: ");
                long create = new Date().getTime();
                Item item = new Item(name, description, create);
                item.setId(id);
                tracker.updateItemById(item);
            } else {
                System.out.println(" [info] not result by id ... ");
            }
        }

    }

    /**
     * Class AddCommentById adds comment by item id.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class AddCommentById extends BaseAction {

        /**
         * AddCommentById - constructor.
         */
        AddCommentById() {
            super(" Add comment by id.");
        }

        /**
         * key - returns number of index of menu (9).
         * @return - returns number of index of menu (9).
         */
        @Override
        public int key() {
            return 9;
        }

        /**
         * execute - adds comment by item id..
         * @param input - link variable to object of class ValidateInput.
         * @param tracker - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.askInt(" [action] input id: ");
            if (tracker.searchItemById(id) != null) {
                String name = input.ask(" [action] input name comment: ");
                String desc = input.ask(" [action] input desc comment: ");
                tracker.addCommentById(id, new Comment(name, desc, new Date().getTime()));
            } else {
                System.out.println(" [info] not result by id ... ");
            }
        }

    }

    /**
     * Class Exit exits from program.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class Exit extends BaseAction {

        /**
         * Exit - constructor.
         */
        Exit() {
            super(" Exit.");
        }

        /**
         * key - returns number of index of menu (10).
         * @return - returns number of index of menu (10).
         */
        @Override
        public int key() {
            return 10;
        }

        /**
         * execute - doing nothing.
         * @param input - link variable to object of class ValidateInput.
         * @param tracker - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
        }

    }

}