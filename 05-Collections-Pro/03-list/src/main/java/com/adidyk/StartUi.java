package com.adidyk;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {
        System.out.println("NewArrayList and Comparable");
        System.out.println("Its only for github");
        System.out.println("Its may second bad days for Java coding");


        SimpleLinkedList list = new SimpleLinkedList();

        list.add("test");

        System.out.println("Prev: " +list.getLast().getPrev());
        System.out.println("Item: " +list.getLast().getItem());
        System.out.println("Next: " +list.getLast().getNext());
    }
}