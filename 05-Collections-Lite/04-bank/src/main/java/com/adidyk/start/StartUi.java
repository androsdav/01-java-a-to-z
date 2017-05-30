package com.adidyk.start;

import com.adidyk.models.Account;
import com.adidyk.models.User;

public class StartUi {

    private Input input;
    private Bank bank;

    private StartUi(Input input) {
        this.input = input;
        this.bank = new Bank();
        this.bank.addUser(new User("1", "1"));
        this.bank.addUser(new User("2", "2"));
        this.bank.addAccountToUser(new User("1", "1"), new Account("1"));
        this.bank.addAccountToUser(new User("2", "2"), new Account("2"));
        this.bank.addUser(new User("Logan", "16375"));
        this.bank.addUser(new User("Russell", "22445"));
        this.bank.addUser(new User("Jordan", "35336"));
        this.bank.addUser(new User("Bruce", "35336"));
    }

    private void init() {
        MenuBank menu = new MenuBank(this.input, this.bank);
        menu.fillAction();
        while(true) {
            menu.show();
            int key = this.input.ask(" Choose key: ", menu.getIndexActions());
            menu.select(key);
            if (key == menu.getIndexActions().length) break;
        }
    }

    // just main ;)
    public static void main(String[] arg) {
        Input input = new ValidateInput();
        new StartUi(input).init();

    }

}