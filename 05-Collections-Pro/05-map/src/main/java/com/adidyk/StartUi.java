package com.adidyk;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class StartUi {

    /**
     * @param arg 1
     */
    // main - its only for compile jar file
    public static void main(String[] arg) {
        User first  = new User("Bob", 4, new GregorianCalendar(1992, 2, 2));
        User second = new User("Bob", 4, new GregorianCalendar(1992, 2, 2));
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
        if (first.hashCode() == second.hashCode()) {
            System.out.println("true");
        } else {
            System.out.println("false, Its bad Ass");
        }
        Map<User, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
        System.out.println("Test");
        String name = "A";
        String name1 = "A";
        int hash = name.hashCode();
        int hash1 = name1.hashCode();
        System.out.println("HashCode: " + hash);
        System.out.println("HashCode: " + hash1);
    }

}