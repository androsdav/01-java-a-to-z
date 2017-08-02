package com.adidyk;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

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
        User first  = new User("Bob", 3, new GregorianCalendar(1992, 2, 2));
        User second = new User("Bob", 3, new GregorianCalendar(1992, 2, 2));
        Map<User, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
        //
        //
        Integer a = 10;
        Double b = 10.5;
        String c = "string";
        System.out.println("HashCode: " + a.hashCode());
        System.out.println("HashCode: " + b.hashCode());
        System.out.println("HashCode: " + c.hashCode());
    }

}