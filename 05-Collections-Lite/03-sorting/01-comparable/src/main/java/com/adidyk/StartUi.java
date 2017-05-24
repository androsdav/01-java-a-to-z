package com.adidyk;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StartUi {

    public static void main(String[] arg) {

        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();

        users.add(new User("antony", 32));
        users.add(new User("bill", 45));
        users.add(new User("bob", 15));
        users.add(new User("smith", 5));
        users.add(new User("will", 10));
        users.add(new User("andrey", 35));

        Set<User> resultFirst = sortUser.sortAddUserByFor(users);

        System.out.println();
        System.out.println(" Result treeSet -> (used add user in for):");
        System.out.println();
        for (User user : resultFirst) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println(" Result treeSet -> (used addAll user in for)");
        Set<User> resultSecond = sortUser.sortAddUserByAddAll(users);
        System.out.println();
        for (User user : resultSecond) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println(" Result treeSet -> (used addAll user in for)");
        Set<User> resultThird = sortUser.sortAddUserByConstructor(users);
        System.out.println();
        for (User user : resultThird) {
            System.out.println(user);
        }
    }

}