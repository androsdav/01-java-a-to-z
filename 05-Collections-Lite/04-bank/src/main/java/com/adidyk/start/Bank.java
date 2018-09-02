package com.adidyk.start;

import com.adidyk.models.Account;
import com.adidyk.models.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Bank {

    private Map<User, List<Account>> user = new HashMap<>();

    void addUser(User user) {
        this.user.put(user, new ArrayList<Account>());
    }

    void deleteUser(User user) {
        this.user.remove(user);
    }

    void addAccountToUser(User user, Account account) {
        this.user.get(user).add(account);
    }

    void deleteAccountFromUser(User user, Account account) {
        this.user.get(user).remove(account);
    }

    List<Account> getUserAccounts(User user) {
        return this.user.get(user);
    }

    boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean transfer = true;
        List <Account> srcList = this.user.get(srcUser);
        List <Account> dstList = this.user.get(dstUser);
        if (srcList.contains(srcAccount)) {
            if (srcList.get(srcList.indexOf(srcAccount)).getValue() >= amount) {
                srcList.get(srcList.indexOf(srcAccount)).subValue(amount);
                dstList.get(dstList.indexOf(dstAccount)).addValue(amount);
            } else {
                transfer = false;
            }
        } else {
            transfer = false;
        }
        return transfer;
    }

    Map<User, List<Account>> getUsers() {
        return this.user;
    }

}