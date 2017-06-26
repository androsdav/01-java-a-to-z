package com.adidyk;

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
        System.out.println(list.getSize());

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(4));



    }
}