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
        this.actions.add(4, new ReplenishAccount());
        this.actions.add(5, new DeleteAccountFromUser());
        this.actions.add(6, new GetUserAccount());
        this.actions.add(7, new Exit());
    }

    public void select(int key) {
        System.out.println();
        this.actions.get(key - 1).execute(this.input, this.bank);
    }

    public void show() {
        System.out.println();
        System.out.println(" ----------------BANK-MENU---------------");
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
        System.out.println(" ----------------------------------------");
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
            System.out.print(String.format(" %s%s%s%8s%5s%5s%s%s%s%n",
                    "| ", "#", " |", "NAME", " | ", "PASSPORT", " | ", "ACCOUNT", " |"));
            int number = 1;
            for (Map.Entry<User, List<Account>> item : bank.getUsers().entrySet()) {
                System.out.println(" |---|-----------|----------|---------|");
                System.out.println(String.format(" %s%3s%s%5s%5s",
                        "|", number, item.getKey(), item.getValue().size(), "|"));
                number++;
            }
            System.out.println(" |---|-----------|----------|---------|");
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
            String name = input.ask(" [action] enter user name: ");
            String passport = input.ask(" [action] enter user passport: ");
            bank.addUser(new User(name, passport));
        }
    }

    // DeleteUser - delete user
    private class DeleteUser extends BaseAction {
        // Constructor
        DeleteUser() {
            super(" Delete user.");
        }
        // key = 2
        public int key() {
            return 3;
        }
        // execute - delete user from collection
        public void execute(Input input, Bank bank) {
            String name = input.ask(" [action] enter user name: ");
            String passport = input.ask(" [action] enter user passport: ");
            User user = new User(name, passport);
            if (bank.getUsers().containsKey(user)) {
                bank.deleteUser(user);
            } else {
                System.out.println(" [inform] user not found ... ");
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
            String name = input.ask(" [action] enter user name: ");
            String passport = input.ask(" [action] enter user passport: ");
            User user = new User(name, passport);
            if(bank.getUsers().containsKey(user)) {
                String requisites = input.ask(" [action] enter user requisites: ");
                bank.addAccountToUser(user, new Account(requisites));
            } else {
                System.out.println(" [inform] user not found ... ");
            }
        }
    }

    // ReplenishAccount - replenish account to user
    private class ReplenishAccount extends BaseAction {
        // Constructor
        ReplenishAccount() {
            super(" Replenish account to user.");
        }
        // key = 2
        public int key() {
            return 5;
        }
        // execute - replenish account to user
        public void execute(Input input, Bank bank) {
            String name = input.ask(" [action] enter user name: ");
            String passport = input.ask(" [action] enter user passport: ");
            User user = new User(name, passport);
            if(bank.getUsers().containsKey(user)) {
                String requisites = input.ask(" [action] enter user requisites: ");
                List<Account> accounts = bank.getUserAccounts(user);
                boolean accountTrue = false;
                for (Account item : accounts) {
                    if (item.getRequisites().equals(requisites)) {
                        accountTrue = true;
                        String value = input.ask(" [action] enter value: ");
                        item.setValue(Double.parseDouble(value));
                        break;
                    }
                }
                if (!accountTrue) { System.out.println(" [inform] account not found ... ");}
            } else {
                System.out.println(" [inform] user not found ... ");
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
            return 6;
        }
        // execute - delete account from user
        public void execute(Input input, Bank bank) {
            String name = input.ask(" [action] enter user name: ");
            String passport = input.ask(" [action] enter user passport: ");
            User user = new User(name, passport);
            if (bank.getUsers().containsKey(user)) {
                String requisites = input.ask(" [action] enter user requisites: ");
                Account account = new Account(requisites);
                if (bank.getUserAccounts(user).contains(account)) {
                    bank.deleteAccountFromUser(user, account);
                }else {
                    System.out.println(" [inform] account not found ... ");
                }
            } else {
                System.out.println(" [inform] user not found ... ");
            }
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
            return 7;
        }
        // execute - get user account
        public void execute(Input input, Bank bank) {
            String name = input.ask(" [action] enter user name: ");
            String passport = input.ask(" [action] enter user passport: ");
            System.out.println();
            User user = new User(name, passport);
            if (bank.getUsers().containsKey(user)) {
                if (!bank.getUserAccounts(user).isEmpty()) {
                    System.out.print(String.format(" %s%s%s%8s%5s%5s%s%s%s%n",
                            "| ", "#", " |", "NAME", " | ", "PASSPORT", " | ", "ACCOUNT", " |"));
                    int number1 = 1;
                    for (Map.Entry<User, List<Account>> item : bank.getUsers().entrySet()) {
                        System.out.println(" |---|-----------|----------|---------|");
                        System.out.println(String.format(" %s%3s%s%5s%5s",
                                "|", number1, item.getKey(), item.getValue().size(), "|"));
                        number1++;
                        if (item.getKey().equals(user)) {
                            System.out.println("");
                            System.out.print(String.format("     %s%s%s%9s%4s%10s%7s%n",
                                    "| ", "#", " |", "ACCOUNT", " | ", "VALUE", " | "));
                            int number2 = 1;
                            for (Account account : bank.getUserAccounts(user)) {
                                System.out.println("     |---|-----------|----------------|");
                                System.out.println(String.format("     %s%3s%s",
                                       "|", number2, account));
                                number2++;
                            }
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println(" [inform] account not found ... ");
                }
            } else {
                System.out.println(" [inform] user not found ... ");
            }
        }
    }

    // Exit - exit program
    private class Exit extends BaseAction {
        // Constructor
        Exit() {
            super(" Exit.");
        }
        // key = 2
        public int key() {
            return 8;
        }
        // execute - add new user to collections
        public void execute(Input input, Bank bank) {
        }
    }

}