package com.adidyk;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    private Set<User> result = new TreeSet<>();

    public Set<User> sortAddUserByFor(List<User> users) {
        for (User user : users) {
            this.result.add(user);
        }
        return this.result;
    }

    public Set<User> sortAddUserByAddAll(List<User> users) {
        this.result.addAll(users);
        return this.result;
    }

    public Set<User> sortAddUserByConstructor(List<User> users) {
        return new TreeSet<>(users);
    }

}