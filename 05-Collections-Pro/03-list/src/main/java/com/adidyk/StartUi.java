package com.adidyk;

import java.util.Iterator;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {
        System.out.println("NewArrayList and Comparable");
        System.out.println("Its only for github");
        System.out.println("Its may second bad days for Java coding");


        SimpleLinkedList<User> list = new SimpleLinkedList<>();

        list.add(new User("0", "Bob", 10));
        list.add(new User("1", "Matilda", 11));
        list.add(new User("2", "Bill", 12));
        list.add(new User("3", "Donald", 13));
        list.add(new User("4", "Argon", 14));
        list.add(new User("5", "Will", 15));
        list.add(new User("6", "Amanda", 16));
        list.add(new User("7", "Sabrina", 17));

        System.out.println();
        System.out.println(list.size());

        System.out.println("Index = 0 :" +list.get(0));
        System.out.println("Index = 1 :" +list.get(1));
        System.out.println("Index = 2 :" +list.get(2));
        System.out.println("Index = 3 :" +list.get(3));
        System.out.println("Index = 4 :" +list.get(4));
        System.out.println("Index = 5 :" +list.get(5));
        System.out.println("Index = 6 :" +list.get(6));
        System.out.println("Index = 7 :" +list.get(7));

        Iterator<User> it = list.iterator();

        System.out.println("Its test iterator: ");
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Its output forEch: ");
        for (User item : list) {
            System.out.println(item);
        }




    }
}