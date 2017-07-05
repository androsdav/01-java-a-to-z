package com.adidyk;

import java.util.Iterator;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {
        SimpleSetArray<User> set = new SimpleSetArray<>();

        System.out.println(set.add(new User("0", "0", 0)));
        System.out.println(set.add(new User("1", "1", 1)));
        System.out.println(set.add(new User("2", "2", 2)));
        System.out.println(set.add(new User("3", "3", 3)));
        System.out.println(set.add(new User("4", "4", 4)));
        System.out.println(set.add(new User("2", "2", 2)));
        System.out.println(set.add(new User("5", "5", 5)));

        System.out.println("Iterator");
        Iterator<User> it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("froEach");
        for(User user : set) {
            System.out.println(user);
        }
    }

}

