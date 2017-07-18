package com.adidyk;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {
        User first  = new User("Bob", 3, new GregorianCalendar(1992, 1, 1));
        User second = new User("bob", 3, new GregorianCalendar(1992, 1, 1));
        Map<User, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
    }

}