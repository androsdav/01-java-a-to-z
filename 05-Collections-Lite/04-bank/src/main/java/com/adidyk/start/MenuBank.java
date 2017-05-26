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
    }

    public void select(int key) {
        this.actions.get(key - 1).execute(this.input, this.bank);
    }

    public void show() {
        System.out.println();
        System.out.println("----------------BANK----------------");
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
        System.out.println("------------------------------------");
    }

    public int[] getIndexActions() {
        int [] range = new int[this.actions.size()];
        for (int index = 0; index < this.actions.size(); index++) {
            range[index] = index + 1;
        }
        return range;
    }

    private class ShowAllUser extends BaseAction {
        // Constructor
        private ShowAllUser() {
            super(" Show all user.");
        }
        // key = 1
        public int key() {
            return 1;
        }
        // execute - show all user, key = 1
        public void execute(Input input, Bank bank) {
            for (Map.Entry<User, List<Account>> item : bank.getUsers().entrySet()) {
                System.out.println(item.getKey());
            }
        }

    }


}
