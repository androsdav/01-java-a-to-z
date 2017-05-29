package com.adidyk;

import java.util.*;

public class SortUser {

    public Set<User> sortAddUserByConstructor(List<User> users) {
        return new TreeSet<>(users);
    }

    public List<User> sortHash(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.hashCode() > o2.hashCode())
                    return 1;
                else if (o1.hashCode() < o2.hashCode())
                    return -1;
                else
                    return 0;
            }
        });
        return users;
    }

    public List<User> sortLength(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return users;
    }

}
