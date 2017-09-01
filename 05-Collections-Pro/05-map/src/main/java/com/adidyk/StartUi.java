package com.adidyk;

import java.util.GregorianCalendar;

/**
 * Class "StartUi" for create Map and puts key = user and value = new Object().
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - creates map and puts two element in map - first, new Object()
     * and second, new Object().
     * @param arg nothing
     */
    public static void main(String[] arg) {

        User bill  = new User("Bill", 3, new GregorianCalendar(1982, 2, 2));
        User bob = new User("Bob", 3, new GregorianCalendar(1922, 4, 6));
        User dilan = new User("Dilan", 4, new GregorianCalendar(1980, 1, 1));
        User donald = new User("Donald", 1, new GregorianCalendar(1880, 11, 11));
        User amanda = new User("Amanda", 10, new GregorianCalendar(2000, 6, 6));
        User adolf = new User("Adolf", 101, new GregorianCalendar(1945, 4, 3));
        User brendon = new User("Brendon", 111, new GregorianCalendar(1933, 4, 7));
        User ken = new User("Ken", 111, new GregorianCalendar(1933, 4, 7));
        User kelly = new User("Kelly", 111, new GregorianCalendar(1933, 4, 7));
        User will = new User("Will", 111, new GregorianCalendar(1933, 4, 7));

        SimpleHashMap<User, String> map = new SimpleHashMap<>();
        map.put(bill, "Bill");
        map.put(bob, "Bob");
        map.put(dilan, "Dilan");
        map.put(amanda, "Amanda");
        map.put(donald, "Donald");
        map.put(adolf, "Adolf");
        map.put(brendon, "Brendon");
        map.put(ken, "Ken");
        map.put(kelly, "Kelly");
        map.put(will, "Will");

        System.out.println(map.put(adolf, "!!!!!!! NEW Adolf !!!!!!!"));
        System.out.println(map.put(brendon, "BRENDON"));

        System.out.println();
        System.out.println("1. All Node in HashMap: ");
        for (int index = 0; index < map.size(); index++) {
            System.out.println("[" + index  + "]  " + map.getIndex(index));
        }

        System.out.println();
        System.out.println("2. Get all Node: ");
        System.out.println(map.get(bill));
        System.out.println(map.get(bob));
        System.out.println(map.get(dilan));
        System.out.println(map.get(amanda));
        System.out.println(map.get(donald));
        System.out.println(map.get(adolf));
        System.out.println(map.get(brendon));
    }

}