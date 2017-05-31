package com.adidyk;

public class StartUi {

    public static void main(String[] args) {
        System.out.println("Test output word");

        IteratorArray it = new IteratorArray(new int[]{1, 2, 3});

        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.hasNext());

    }
}
