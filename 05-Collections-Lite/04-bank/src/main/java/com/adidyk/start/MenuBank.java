package com.adidyk.start;

import com.adidyk.models.Account;
import com.adidyk.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuBank {

    private Input input;
    private Bank bank;
    private ArrayList<UserAction> actions = new ArrayList<>();

    MenuBank(Input input, Bank bank) {
        this.input = input;
        this.bank = bank;
    }

    public void fillAction() {
        this.actions.add(0, new ShowAllUser());
        this.actions.add(1, new AddUser());
        this.actions.add(2, new DeleteUser());
        this.actions.add(3, new AddAccountToUser());
        this.actions.add(4, new DeleteAccountFromUser());
        this.actions.add(5, new GetUserAccount());
        this.actions.add(6, new Exit());
    }

    public void select(int key) {
        System.out.println();
        this.actions.get(key - 1).execute(this.input, this.bank);
    }

    public void show() {
        System.out.println();
        System.out.println(" ----------------BANK----------------");
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
        System.out.println(" ------------------------------------");
    }

    public int[] getIndexActions() {
        int [] range = new int[this.actions.size()];
        for (int index = 0; index < this.actions.size(); index++) {
            range[index] = index + 1;
        }
        return range;
    }

    // ShowAllUser - shows all user form list
    private class ShowAllUser extends BaseAction {
        // Constructor
        ShowAllUser() {
            super(" Show all user.");
        }
        // key = 1
        public int key() {
            return 1;
        }
        // execute - show all user, key = 1
        public void execute(Input input, Bank bank) {
            System.out.println(" |                 USERS                   | ACCOUNT |");
            for (Map.Entry<User, List<Account>> item : bank.getUsers().entrySet()) {
                System.out.println(" -----------------------------------------------------");
                System.out.println(item.getKey() +String.format("%5s%s", String.valueOf(item.getValue().size()), "|"));
            }
            System.out.println(" -----------------------------------------------------");

        }

    }

    // AddUser - add new user to list
    private class AddUser extends BaseAction {
        // Constructor
        AddUser() {
            super(" Add new user.");
        }
        // key = 2
        public int key() {
            return 2;
        }
        // execute - add new user to collections
        public void execute(Input input, Bank bank) {
            String name = input.ask(" Enter name new user: ");
            String passport = input.ask(" Enter passport serial for new user: ");
            bank.addUser(new User(name, passport));
        }
    }

    // DeleteUser - delete user
    private class DeleteUser extends BaseAction {
        // Constructor
        DeleteUser() {
            super(" Delete user by name user.");
        }
        // key = 2
        public int key() {
            return 3;
        }
        // execute - delete user from collection
        public void execute(Input input, Bank bank) {
            String name = input.ask(" Enter name of user wants to delete: ");
            String passport = input.ask("Enter passport serial: ");
            if (bank.getUsers().containsKey(new User(name, passport))) {
                bank.deleteUser(new User(name, passport));
            } else {
                System.out.println("User not found");
            }
        }
    }

    // AddAccountToUser - add account to user
    private class AddAccountToUser extends BaseAction {
        // Constructor
        AddAccountToUser() {
            super(" Add account to user.");
        }
        // key = 2
        public int key() {
            return 4;
        }
        // execute - add account to user
        public void execute(Input input, Bank bank) {
            String name = input.ask(" Enter username for add account: ");
            String passport = input.ask("Enter serial of user passport: ");
            User user = new User(name, passport);
            if(bank.getUsers().containsKey(user)) {
                String requisites = input.ask("Enter requisites of account: ");
                bank.addAccountToUser(user, new Account(requisites));
            } else {
                System.out.println("User not found");
            }
        }
    }

    // DeleteAccountFromUser - delete account from user
    private class DeleteAccountFromUser extends BaseAction {
        // Constructor
        DeleteAccountFromUser() {
            super(" Delete account from user.");
        }
        // key = 2
        public int key() {
            return 5;
        }
        // execute - add account to user
        public void execute(Input input, Bank bank) {
        }
    }

    // AddAccountToUser - get user account
    private class GetUserAccount extends BaseAction {
        // Constructor
        GetUserAccount() {
            super(" Get user account.");
        }
        // key = 2
        public int key() {
            return 6;
        }
        // execute - get user account
        public void execute(Input input, Bank bank) {
            String name = input.ask(" Enter username for add account: ");
            String passport = input.ask("Enter serial of user passport: ");
            User user = new User(name, passport);
            if (bank.getUsers().containsKey(user)) {
                System.out.println(user);
                if (!bank.getUserAccounts(user).isEmpty()) {
                    for (Account account : bank.getUserAccounts(user)) {
                        System.out.println(account);
                    }
                } else {
                    System.out.println("Account not found");
                }
            } else {
                System.out.println(" User not found");
            }

        }
    }

    // Exit -
    private class Exit extends BaseAction {
        // Constructor
        Exit() {
            super(" Exit.");
        }
        // key = 2
        public int key() {
            return 7;
        }
        // execute - add new user to collections
        public void execute(Input input, Bank bank) {
        }
    }

}