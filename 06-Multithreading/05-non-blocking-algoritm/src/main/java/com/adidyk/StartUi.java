package com.adidyk;

//import java.util.Iterator;
//import java.util.Map;
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
        Cache cache = new Cache();
        System.out.println(cache.add(1, new User(1, "Bob", "operator")));
        System.out.println(cache.add(2, new User(2, "Adam", "animal")));
        System.out.println(cache.add(3, new User(3, "Dilan", "administrator")));
        System.out.println(cache.add(4, new User(4, "Amanda", "doc")));
        System.out.println(cache.add(5, new User(5, "Bil", "actor")));
        System.out.println(cache.add(6, new User(6, "Tom", "murder")));
        System.out.println(cache.add(7, new User(7, "Adolf", "cop")));
        System.out.println(cache.add(8, new User(8, "Kruger", "kok")));
        System.out.println(cache.add(4, new User(4, "Amanda", "doc")));
        System.out.println(cache.add(7, new User(7, "Adolf", "cop")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread first = new Thread(new MyThreadFirst(cache));
        Thread second = new Thread(new MyThreadSecond(cache));
        first.start();
        second.start();
        /*
        for (Map.Entry<Integer, User> item : cache.getAll().entrySet()) {
            System.out.println("key: " + item.getKey() + " value:  " + item.getValue());
        }
        System.out.println();
        System.out.println();
        System.out.println(cache.get(5));
        System.out.println(cache.update(5, "test"));
        System.out.println(cache.get(5));
        //User temp = cache.get(5);
        //System.out.println(temp.getName());
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