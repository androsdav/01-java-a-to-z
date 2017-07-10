package com.adidyk;

import java.util.Set;
import java.util.TreeSet;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {
        System.out.println("SimpleSetArrays, SimpleSetLinkedList");

//        User user = new User("1", "Bill", 10);
//        User user1 = new User("1", "Bill", 11);

//        System.out.println(user);
  //      System.out.println(user1);

        System.out.println("Its my collections");
        SimpleSetArray<User> set = new SimpleSetArray<>();
        set.add(new User("0", "bob", 0));
        set.add(new User("1", "bib", 1));
        set.add(new User("2", "neo", 2));

        for (User item : set) {
            System.out.println(item);
        }

        System.out.println("Comparable");
        Set<User> test = new TreeSet<>();
        test.add(new User("0", "bob", 0));
        test.add(new User("1", "bib", 1));
        test.add(new User("2", "neo", 2));
        test.add(new User("1", "bib", 1));
        test.add(new User("1", "bib", 1));
        test.add(new User("1", "bib", 1));
        for(User item : test) {
            System.out.println(item);
        }


    }

}