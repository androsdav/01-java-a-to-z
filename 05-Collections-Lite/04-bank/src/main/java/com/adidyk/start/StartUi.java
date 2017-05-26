package com.adidyk.start;

import com.adidyk.models.User;

public class StartUi {

    private Input input;
    private Bank bank;

    private StartUi(Input input) {
        this.input = input;
        this.bank = new Bank();
        this.bank.addUser(new User("Adolf", "16375"));
        this.bank.addUser(new User("Rudolf", "22445"));
        this.bank.addUser(new User("Bob", "35336"));
    }

    private void init() {
        MenuBank menu = new MenuBank(this.input, this.bank);
        menu.fillAction();
        while(true) {
            menu.show();
            int key = this.input.ask(" Choose key: ", menu.getIndexActions());
            menu.select(key);
            if (key == 9) break;
        }
    }

    // just main ;)
    public static void main(String[] arg) {
        Input input = new ValidateInput();
        new StartUi(input).init();

    }

}