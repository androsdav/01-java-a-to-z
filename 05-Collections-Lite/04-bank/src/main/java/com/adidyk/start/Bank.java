package com.adidyk.start;

import com.adidyk.models.Account;
import com.adidyk.models.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private Map<User, List<Account>> user = new HashMap<>();

    public void addUser(User user) {
        this.user.put(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        this.user.remove(user);
    }

    public void addAccountToUser(User user, Account account) {
        this.user.get(user).add(account);
    }

    public void deleteAccountFromUser(User user, Account account) {
        this.user.get(user).remove(account);
    }

    public List<Account> getUserAccounts(User user) {
        return this.user.get(user);
    }

    public boolean transferMoney(User srcUser, Account strAccount, User dstUser, Account dstAccount, double amount) {



        return false;
    }

    public Map<User, List<Account>> getUsers() {
        return this.user;
    }

}
