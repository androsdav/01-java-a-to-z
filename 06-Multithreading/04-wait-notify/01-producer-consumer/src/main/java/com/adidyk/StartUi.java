package com.adidyk;

import java.util.LinkedList;

/** Class StartUi for create jar file.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - just main.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        System.out.println("SimpleArrayList, SimpleLinkedList - thread safe");
        SimpleQueue<User> queue = new SimpleQueue<>();
        queue.push(new User("1", "Tom", 10));
        queue.push(new User("2", "Bob", 20));
        queue.push(new User("3", "Bil", 30));
        queue.push(new User("4", "Ben", 40));
        for (User user : queue) {
            System.out.println(user);
        }
        System.out.println();
        System.out.println("First user: " + queue.peek());
        System.out.println();
        System.out.println("First user pop: " + queue.pop());
        for (User user : queue) {
            System.out.println(user);
        }
        System.out.println();
        System.out.println("First user pop: " + queue.pop());
        for (User user : queue) {
            System.out.println(user);
        }
        System.out.println();
        System.out.println("First user pop: " + queue.pop());
        for (User user : queue) {
            System.out.println(user);
        }
        System.out.println();
        System.out.println("First user pop: " + queue.pop());
        for (User user : queue) {
            System.out.println(user + "test");
        }
    }

}