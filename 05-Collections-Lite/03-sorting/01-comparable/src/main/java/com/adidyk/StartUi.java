package com.adidyk;

import java.util.Set;
import java.util.TreeSet;

public class StartUi {

    public static void main(String[] arg) {

        Set<User> users = new TreeSet<>();
        users.add(new User("antony", 32));
        users.add(new User("bill", 45));
        users.add(new User("bob", 15));
        users.add(new User("smith", 5));
        users.add(new User("will", 10));
        users.add(new User("andrey", 35));


        System.out.println();

        System.out.println("Classic loop for-ich");
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println();

        System.out.println("Classic loop for-ich with toString");
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println(users);

    }

}