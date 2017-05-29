package com.adidyk;

import java.util.*;

public class SortUser {

    public Set<User> sortAddUserByConstructor(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortHash(List<User> list) {
        Collections.sort(list,(user1, user2) -> Integer.valueOf(user1.hashCode()).compareTo(user2.hashCode()));
        return list;
    }

    public List<User> sortLength(List<User> list) {
        Collections.sort(list, (User user1, User user2) -> user1.getName().length() - user2.getName().length());
        return list;
    }

}
