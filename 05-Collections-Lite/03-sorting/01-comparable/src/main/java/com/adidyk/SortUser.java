package com.adidyk;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public Set<User> sortAddUserByConstructor(List<User> users) {
        return new TreeSet<>(users);
    }

}