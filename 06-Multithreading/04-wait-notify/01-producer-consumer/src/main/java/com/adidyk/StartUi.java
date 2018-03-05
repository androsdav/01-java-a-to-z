package com.adidyk;

//import java.util.LinkedList;

/** Class StartUi for create jar file.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.03.2018.
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
        SimpleBlockingQueue<String> temp = new SimpleBlockingQueue<>();
        temp.push("1", 2);
        temp.push("2", 3);


        for (String anTemp : temp) {
            System.out.println(anTemp);
        }

        Product product = new Product("1", "phone");
        System.out.println(product);
    }

}