package com.adidyk;

//import java.util.Iterator;
import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;

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
        Cache<Integer, User> map = new Cache<>();
        System.out.println(map.add(1, new User(1, "Bob", "operator")));
        System.out.println(map.add(2, new User(2, "Adam", "animal")));
        System.out.println(map.add(3, new User(3, "Dilan", "administrator")));
        System.out.println(map.add(4, new User(4, "Amanda", "doc")));
        System.out.println(map.add(5, new User(5, "Bil", "actor")));
        System.out.println(map.add(6, new User(6, "Tom", "murder")));
        System.out.println(map.add(7, new User(7, "Adolf", "cop")));
        System.out.println(map.add(8, new User(8, "Kruger", "kok")));
        System.out.println(map.add(4, new User(4, "Amanda", "doc")));
        System.out.println(map.add(7, new User(7, "Adolf", "cop")));
        System.out.println();
        System.out.println(map.delete(4));
        System.out.println(map.delete(1));
        System.out.println(map.delete(8));
        System.out.println(map.delete(9));
        System.out.println();
        System.out.println(map.get(5));
        System.out.println();
        for (Map.Entry<Integer, User> item : map.getAll().entrySet()) {
            System.out.println("key: " + item.getKey() + " value:  " + item.getValue());
        }
        System.out.println();
        User user = map.get(1);
        //user.
        /*
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