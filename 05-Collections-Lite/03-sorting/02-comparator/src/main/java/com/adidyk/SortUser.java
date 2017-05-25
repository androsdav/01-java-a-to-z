package com.adidyk;

import java.util.*;

public class SortUser {

    public Set<User> sortAddUserByConstructor(List<User> users) {
        return new TreeSet<>(users);
    }

    public List<User> sortHash(List<User> users) {
        Collections.sort(users, new UserHashCodeComparator());
        return users;
    }

    public List<User> sortLength(List<User> users) {
        Collections.sort(users, new UserNameByLengthComparator());
        return users;
    }

}
