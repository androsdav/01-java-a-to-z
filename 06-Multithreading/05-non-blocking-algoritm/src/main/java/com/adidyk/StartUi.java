package com.adidyk;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 05.05.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        System.out.println("Non blocking algoritm");
        Cache<String, String> map = new Cache<>();
        map.add("1", "first");
        map.add("2", "second");
        map.add("3", "third");
        ConcurrentHashMap<String, String> result = map.getAll();
        for (Map.Entry<String, String> item : result.entrySet()) {
            System.out.println("key: " + item.getKey() + "value:  " + item.getValue());
        }
        User user = new User(1, "Adam", "operator");
        System.out.println(user);
        user.setRole("administrator");
        System.out.println(user);

        /*
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "First");
        map.put("2", "Second");
        for (Map.Entry<String, String> temp : map.entrySet()) {
            System.out.println(temp.getKey() + temp.getValue());

        }
        */
    }

}