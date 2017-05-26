package com.adidyk.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String passport;
    private List<Account> account = new ArrayList<>();

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return this.name;
    }

    public String getRassport() {
        return this.passport;
    }

    public void addAccount(Account account) {
        this.account.add(account);
    }

    public List<Account> getAccount() {
        return this.account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (passport != null ? !passport.equals(user.passport) : user.passport != null) return false;
        return account != null ? account.equals(user.account) : user.account == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s%13s%s%3s",
                " Name: ", this.getName(), "  passport: ", this.passport);
    }

}