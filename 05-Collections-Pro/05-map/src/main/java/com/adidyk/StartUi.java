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

        User first  = new User("Bill", 3, new GregorianCalendar(1992, 2, 2));
        User second = new User("Bob", 3, new GregorianCalendar(1992, 2, 2));

        SimpleHashMap<User, String> map = new SimpleHashMap<>();
        map.put(first, "first");
        map.put(second, "second");

        for (int index = 0; index < map.getSize(); index++) {
            System.out.println(map.getIndex(index));
        }

    }

}