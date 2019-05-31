package com.adidyk.start;

import com.adidyk.input.Input;
import com.adidyk.models.User;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.adidyk.constant.Constant.*;

/**
 * Class UserStorage used for creates index menu and for work with database base_storage.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class UserStorage {

    /**
     * @param logger - logger (link variable to object of class Logger).
     */
    private static final Logger logger = Logger.getLogger(StartUi.class);

    /**
     * @param input - input (link variable to object of interface Input).
     */
    private Input input;

    /**
     * @param storage - storage (link variable to object of interface Storage).
     */
    private final StorageDAO storage;

    /**
     * @param actions - actions (link variable to object of class ArrayList).
     */
    private ArrayList<BaseAction> actions;

    /**
     * UserStorage - constructor.
     * @param input - input (link variable to object of interface Input).
     * @param storage - storage (link variable to object of interface Storage).
     * @param actions - actions (link variable to object of class ArrayList).
     */
    public UserStorage(Input input, StorageDAO storage, List<BaseAction> actions) {
        this.input = input;
        this.storage = storage;
        this.actions = (ArrayList<BaseAction>) actions;
    }

    /**
     * select - selects action by key.
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
     * Class ShowAllUser shows all user.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    public static class  ShowAllUser extends BaseAction {

        /**
         * ShowAllUser - constructor.
         */
        public ShowAllUser() {
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
         * execute - shows all user.
         * @param input - input (link variable to object of interface Input (ValidateInput)).
         * @param storage - storage (link variable to object of interface Storage (JdbcStorage)).
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
     * Class AddUser adds new user.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    public static class AddUser extends BaseAction {

        /**
         * AddUser - constructor.
         */
        AddUser() {
            super(" Add new user.");
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
         * execute - adds new user.
         * @param input - input (link variable to object of interface Input (ValidateInput)).
         * @param storage - storage (link variable to object of interface Storage (JdbcStorage)).
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
     * SearchUserById shows search result - search user by id.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    public static class SearchUserById extends BaseAction {

        /**
         * SearchUserById - constructor.
         */
        SearchUserById() {
            super(" Search user by id.");
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
         * execute - shows search result - search user by id.
         * @param input - input (link variable to object of interface Input (ValidateInput)).
         * @param storage - storage (link variable to object of interface Storage (JdbcStorage)).
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
     * Class SearchUserByName shows all user by user name.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    public static class SearchUserByName extends BaseAction {

        /**
         * SearchUserByName - constructor.
         */
        SearchUserByName() {
            super(" Search user by name.");
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
         * execute - shows all user by user name.
         * @param input - input (link variable to object of interface Input (ValidateInput)).
         * @param storage - storage (link variable to object of interface Storage (JdbcStorage)).
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
     * Class SearchUserByLogin shows all user by user login.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    public static class SearchUserByLogin extends BaseAction {

        /**
         * SearchUserByLogin - constructor.
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
         * execute - shows all user by user login.
         * @param input - input (link variable to object of interface Input (ValidateInput)).
         * @param storage - storage (link variable to object of interface Storage (JdbcStorage)).
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
     * Class SearchUserByLoginByName shows all user by login and by name.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    public static class SearchUserByLoginByName extends BaseAction {

        /**
         * SearchUserByLoginByName - constructor.
         */
        SearchUserByLoginByName() {
            super(" Search user by login and by name.");
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
         * execute - shows all user by login and by name.
         * @param input - input - input (link variable to object of interface Input (ValidateInput)).
         * @param storage - storage (link variable to object of interface Storage (JdbcStorage)).
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
     * Class UpdateUserById update user by id.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    public static class UpdateUserById extends BaseAction {

        /**
         * UpdateUserById - constructor.
         */
        UpdateUserById() {
            super(" Update user by id.");
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
         * execute - update user by id.
         * @param input - input (link variable to object of interface Input (ValidateInput)).
         * @param storage - storage (link variable to object of interface Storage (JdbcStorage)).
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
            final String id = input.askInt(" [action] input id: ");
            final String login = input.ask(" [action] input new login user: ");
            final String name = input.ask(" [action] input new name user: ");
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
     * Class RemoveUserById remove user by id.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    public static class RemoveUserById extends BaseAction {

        /**
         * RemoveUserByID - constructor.
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
         * execute - remove user by id.
         * @param input - input (link variable to object of interface Input (ValidateInput)).
         * @param storage - storage (link variable to object of interface Storage (JdbcStorage)).
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
            final String id = input.askInt(" [action] input id: ");
            final int result = storage.removeUserById(id);
            if (result == 1) {
                logger.info("user by id removed ...");
            } else if (result == 0) {
                logger.info("user by id not found ...");
            }
        }

    }

    /**
     * Class Exit exits from program.
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 06.08.2018.
     * @version 1.0.
     */
    public static class Exit extends BaseAction {

        /**
         * Exit - constructor.
         */
        Exit() {
            super(" Exit.");
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
         * execute - doing nothing.
         * @param input - input (link variable to object of interface Input (ValidateInput)).
         * @param storage - storage (link variable to object of interface Storage (JdbcStorage)).
         */
        @Override
        public void execute(Input input, StorageDAO storage) {
        }

    }

}