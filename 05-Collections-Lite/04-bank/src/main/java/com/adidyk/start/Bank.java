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

    public void deleteAccountFromUseer(User user, Account account) {
        this.user.get(user).remove(account);
    }

    public Map<User, List<Account>> getUsers() {
        return this.user;
    }

    public List<Account> getUserAcounts(User user) {
        return this.user.get(user);
    }

}
