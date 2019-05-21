package com.adidyk.start;

import com.adidyk.input.Input;
import com.adidyk.models.User;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.adidyk.models.Constant.*;

/**
 * Class UserStorage defines next method for container of users: add.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class UserStorage {

    /**
     * @param logger - link variable to object of class Logger.
     */
    private static final Logger logger = Logger.getLogger(StartUi.class);

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
        this.actions.add(5, new SearchUserByLoginByName());
        this.actions.add(6, new UpdateUserById());
        this.actions.add(7, new RemoveUserById());
        this.actions.add(8, new Exit());
    }

    /**
     * select - selects action (мфдгу) by key.
     * @param key - key of index menu.
     */
    void select(int key) {
        try {
            this.actions.get(key - 1).execute(this.input, this.storage);
        } catch (SQLException ex) {
            ex.printStackTrace();
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
            super(" Show all user.");
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
            userTable();
            for (User user : storage.getAllUser()) {
                System.out.println(user);
            }
            userSeparator();
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
            super(" Add new user.");
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
            final String login = input.ask(" [action] input login user: ");
            final String name = input.ask(" [action] input name user: ");
            final int result = storage.addUser(new User(login, name));
            if (result == 1) {
                logger.info("new user added to storage ...");
            } else if (result == 0) {
                logger.info("new user not added to storage ...");
            }
        }

    }

    /**
     * SearchItemById shows search result - search item by id.dfsdfsdf
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class SearchUserById extends BaseAction {

        /**
         * SearchItemById - constructor.
         */
        SearchUserById() {
            super(" Search user by id.");
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
            final String id = input.askInt(" [action] input id: ");
            try {
                User user = storage.searchUserById(id);
                userTable();
                System.out.println(user);
                userSeparator();
            } catch (EmptyResultDataAccessException ex) {
                logger.info("there isn`t result for entered id ...");
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
            super(" Search user by name.");
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
            final String name = input.ask(" [action] input name user: ");
            final List<User> result = storage.searchUserByName(new User(null, name));
            if (!result.isEmpty()) {
                userTable();
                for (User user : result) {
                    System.out.println(user);
                }
                userSeparator();
            } else {
                logger.info("there isn`t result by entered name ...");
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
            super(" Search user by login.");
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
            final String login = input.ask(" [action] input login user: ");
            final List<User> result = storage.searchUserByLogin(new User(login, null));
            if (!result.isEmpty()) {
                userTable();
                for (User user : result) {
                    System.out.println(user);
                }
                userSeparator();
            } else {
                logger.info("there isn`t result by entered login ...");
            }
        }

    }

    /**
     * Class SearchItemByName shows all items for set name.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class SearchUserByLoginByName extends BaseAction {

        /**
         * SearchItemByName - constructor.
         */
        SearchUserByLoginByName() {
            super(" Search user by login and by name.");
        }

        /**
         * key - returns number of index of menu (5).
         * @return - returns number of index of menu (5).
         */
        @Override
        public int key() {
            return 6;
        }

        /**
         * execute - shows all items for set name.
         * @param input - link variable to object of class ValidateInput.
         * @param storage - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
            final String login = input.ask(" [action] input login user: ");
            final String name = input.ask(" [action] input name user: ");
            final List<User> result = storage.searchUserByLoginByName(new User(login, name));
            if (!result.isEmpty()) {
                userTable();
                for (User user : result) {
                    System.out.println(user);
                }
                userSeparator();
            } else {
                logger.info("there isn`t result by login and by name ...");
            }
        }

    }

    /**
     * Class SearchItemByName shows all items for set name.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class UpdateUserById extends BaseAction {

        /**
         * SearchItemByName - constructor.
         */
        UpdateUserById() {
            super(" Update user by id.");
        }

        /**
         * key - returns number of index of menu (5).
         * @return - returns number of index of menu (5).
         */
        @Override
        public int key() {
            return 7;
        }

        /**
         * execute - shows all items for set name.
         * @param input - link variable to object of class ValidateInput.
         * @param storage - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
            final String id = input.ask("[action] input id: ");
            final String login = input.ask("[action] input new login user: ");
            final String name = input.ask("[action] input new name user: ");
            final User user = new User(login, name);
            user.setId(id);
            final int result = storage.updateUserById(user);
            if (result == 1) {
                logger.info("user by id updated ...");
            } else if (result == 0) {
                logger.info("user by id not found ...");
            }
        }

    }

    /**
     * Class AddItem adds new item.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    private class RemoveUserById extends BaseAction {

        /**
         * AddItem - constructor.
         */
        RemoveUserById() {
            super(" Remove user by id.");
        }

        /**
         * key - returns number of index of menu (3).
         * @return - returns number of index of menu (3).
         */
        @Override
        public int key() {
            return 8;
        }

        /**
         * execute - adds new item.
         * @param input - link variable to object of class ValidateInput.
         * @param storage - link variable to object of class Tracker.
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
            final String id = input.ask("[action] input id: ");
            final int result = storage.removeUserById(id);
            if (result == 1) {
                logger.info("user by id deleted ...");
            } else if (result == 0) {
                logger.info("user by id not found ..");
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
            return 9;
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

}