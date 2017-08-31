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

        SimpleHashMap<User, String> map = new SimpleHashMap<>();
        map.put(bill, "Bill");
        map.put(bob, "Bob");
        map.put(dilan, "Dilan");

        for (int index = 0; index < map.getSize(); index++) {
            System.out.println("[" + index  + "]  " + map.getIndex(index));
        }

    }

}