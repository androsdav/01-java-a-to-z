package com.adidyk;

import java.util.Map;

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
        System.out.println(cache.add(new User(1, "Bob1", "operator1")));
        System.out.println(cache.add(new User(1, "NewBob", "NewOperator")));
        System.out.println(cache.add(new User(2, "Adam", "animal")));
        System.out.println(cache.add(new User(3, "Dilan", "administrator")));
        Thread first = new Thread(new MyThreadFirst(cache));
        Thread second = new Thread(new MyThreadSecond(cache));
        first.start();
        second.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Integer, User> item : cache.getAll().entrySet()) {
            System.out.println("key: " + item.getKey() + " value: " + item.getValue());
        }
        /*
        cache.update(new User(2, "Adam", "human"));
        System.out.println();
        for (Map.Entry<Integer, User> item : cache.getAll().entrySet()) {
            System.out.println("key: " + item.getKey() + " value: " + item.getValue());
        }
        /*
        System.out.println(cache.add(new User(4, "Amanda", "doc")));
        System.out.println(cache.add(new User(5, "Bil", "actor")));
        System.out.println(cache.add(new User(6, "Tom", "murder")));
        System.out.println(cache.add(new User(7, "Adolf", "cop")));
        System.out.println(cache.add(new User(8, "Kruger", "kok")));
        System.out.println(cache.add(new User(4, "Amanda", "doc")));
        System.out.println(cache.add(new User(7, "Adolf", "cop")));
        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread first = new Thread(new MyThreadFirst(cache));
        Thread second = new Thread(new MyThreadSecond(cache));
        first.start();
        second.start();
        */

    }

}