package com.adidyk.start;

import com.adidyk.input.Input;
import com.adidyk.models.User;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.adidyk.setup.Constant.menuSeparator;
import static com.adidyk.setup.Constant.menuTable;

/**
 * Class UserStorage defines next method for container of users: add.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class UserStorage {

    /**
     * @param storage - storage (link variable to object of interface Storage).
     */
    private final StorageDAO storage;

    /**
     *
     */
    private Input input;

    /**
     *
     */
    private ArrayList<UserAction> actions = new ArrayList<>();

    /**
     * UserStorage - constructor.
     * @param storage - storage (link variable to object of interface Storage).
     */
    public UserStorage(Input input, StorageDAO storage) {
        this.input = input;
        this.storage = storage;
    }

    /**
     * fillAction - adds to array list (menu) objects of class ShowAllItem, ShowAllItemWithComments, AddItem,
     * SearchItemById, SearchItemByName, SearchItemByDescription, RemoveItemById, UpdateItemById, AddCommentById, Exit.
     */
    void fillAction() {
        this.actions.add(0, new ShowAllUser());
        this.actions.add(1, new AddUser());
        this.actions.add(2, new SearchUserById());
        this.actions.add(3, new SearchUserByName());
        this.actions.add(4, new SearchUserByLogin());
        this.actions.add(5, new Exit());

        /*this.actions.add(1, new ShowAllItemWithComments());
        this.actions.add(2, new AddItem());
        this.actions.add(3, new SearchItemById());
        this.actions.add(4, new SearchItemByName());
        this.actions.add(5, new SearchItemByDescription());
        this.actions.add(6, new RemoveItemById());
        this.actions.add(7, new UpdateItemById());
        this.actions.add(8, new AddCommentById());
        this.actions.add(9, new Exit());
        */
    }

    /**
     * select - selects action (мфдгу) by key.
     * @param key - key of index menu.
     */
    void select(int key) {
        try {
            this.actions.get(key - 1).execute(this.input, this.storage);
        } catch (SQLException ex) {


            //log.error(ex.getMessage(), ex);
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
     * Class ShowAllItem shows all items without comments.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class  ShowAllUser extends BaseAction {

        /**
         * ShowAllItem - constructor.
         */
        private ShowAllUser() {
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
         * @param storage - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
            for (User user : storage.getAllUser()) {
                System.out.println(user);
            }
        }

    }

    /**
     * Class AddItem adds new item.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class AddUser extends BaseAction {

        /**
         * AddItem - constructor.
         */
        AddUser() {
            super(" Add new item.");
        }

        /**
         * key - returns number of index of menu (3).
         * @return - returns number of index of menu (3).
         */
        @Override
        public int key() {
            return 2;
        }

        /**
         * execute - adds new item.
         * @param input - link variable to object of class ValidateInput.
         * @param storage - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
            String login = input.ask(" [action] input login user: ");
            String name = input.ask(" [action] input name item: ");
            storage.addUser(new User(login, name));
        }

    }

    /**
     * SearchItemById shows search result - search item by id.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class SearchUserById extends BaseAction {

        /**
         * SearchItemById - constructor.
         */
        SearchUserById() {
            super(" Search item by id.");
        }

        /**
         * key - returns number of index of menu (4).
         * @return - returns number of index of menu (4).
         */
        @Override
        public int key() {
            return 3;
        }

        /**
         * execute - shows search result - search item by id.
         * @param input - link variable to object of class ValidateInput.
         * @param storage - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
            String id = input.askInt(" [action] input id: ");
            User user = storage.searchUserById(id);
            if (user != null) {
                //itemTable();
                System.out.println(user);
                //itemSeparator();
                /*
                if (tracker.searchCommentByItemId(item.getId()).size() != 0) {
                    outputAllComments(tracker, item);
                }*/
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
    private class SearchUserByName extends BaseAction {

        /**
         * SearchItemByName - constructor.
         */
        SearchUserByName() {
            super(" Search item by name.");
        }

        /**
         * key - returns number of index of menu (5).
         * @return - returns number of index of menu (5).
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * execute - shows all items for set name.
         * @param input - link variable to object of class ValidateInput.
         * @param storage - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
            String name = input.ask(" [action] input name user: ");
            for (User user : storage.getAllUserByName(name)) {
                System.out.println(user);
            }

        }

    }


    /**
     * Class SearchItemByName shows all items for set name.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class SearchUserByLogin extends BaseAction {

        /**
         * SearchItemByName - constructor.
         */
        SearchUserByLogin() {
            super(" Search item by login.");
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
         * @param storage - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
            String name = input.ask(" [action] input login user: ");
            for (User user : storage.getAllUserByLogin(name)) {
                System.out.println(user);
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
            return 6;
        }

        /**
         * execute - doing nothing.
         * @param input - link variable to object of class ValidateInput.
         * @param storage - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
        }

    }

/*

    /**
     * add - adds user to container.
     * @param user - user (link variable to object of class User).
     */
    /*
    void addUser(User user) {
        this.storage.addUser(user);
    }

    /**
     *
     * @param id
     * @return
     */
    /*
    User getUserById(String id) {
        return this.storage.searchUserById(id);
    }

    /**
     *
     * @param user - user.
     */

    /*
    void updateUserById(User user) {
        this.storage.updateUserById(user);
    }

    /**
     *
     * @param id - id.
     */
    /*
    void removeUserById(String id) {
        this.storage.removeUserById(id);
    }

    /**
     *
     * @return - return.
     */
    /*
    List<User> getAllUser() {
        return this.storage.getAllUser();
    }

    /**
     *
     * @param login - login.
     * @return - return - login.
     */
    /*
    List<User> getAllUserByLogin(String login) {
        return this.storage.getAllUserByLogin(login);
    }

    /**
     *
     * @param name - name.
     * @return - name.
     */
    /*
    List<User> getAllUserByName(String name) {
        return this.storage.getAllUserByName(name);
    }

    /**
     *
     * @param login - login.
     * @param name - name.
     * @return - list.
     */
    /*
    public List<User> getAllUserByLoginByName(String login, String name) {
        return this.storage.getAllUserByLoginByName(login, name);
    }
    */

}