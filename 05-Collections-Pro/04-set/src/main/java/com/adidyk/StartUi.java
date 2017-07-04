package com.adidyk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StartUi {


    // main - its only for compile jar file
    public static void main(String[] arg) {


        Set<User> set = new HashSet<>();
        System.out.println(set.add(new User("0", "Bill", 0)));
        set.add(new User("1", "Bob", 1));
        set.add(new User("2", "Argon", 2));
        set.add(new User("3", "Fill", 3));
        set.add(new User("4", "Madly", 4));

/*
        for(User user :  set) {
            System.out.println(user + " " + user.hashCode());
        }
*/
        Iterator it = set.iterator();
        while(it.hasNext()) {
            User result = (User) it.next();
            System.out.println(result + " " + result.hashCode());
        }

        System.out.println();

        Set<String> set1 = new HashSet<>();
        set1.add("first");
        set1.add("second");
        set1.add("third");

        for(String str : set1) {
            System.out.println(str + " " + str.hashCode());
        }


    }

}