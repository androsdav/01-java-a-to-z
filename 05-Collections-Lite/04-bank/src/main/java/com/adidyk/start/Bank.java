package com.adidyk.start;

import com.adidyk.models.Account;
import com.adidyk.models.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private Map<User, List<Account>> user = new HashMap<>();

    public void addUser(User user) {
        this.user.put(user, null);
    }

    public void addAccountToUser(User user, Account account) {
        this.user.put(user, (List<Account>) account);

    }
}
