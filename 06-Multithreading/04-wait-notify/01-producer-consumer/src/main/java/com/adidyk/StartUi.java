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
        System.out.println("Producer-Consumer");
        SimpleBlockingQueue<Product> queue = new SimpleBlockingQueue<>(5);
        //SimpleQueue<String> temp = new SimpleQueue<>();
        //System.out.println("Queue is empty: " + temp.empty());
        //temp.push("1");
        //temp.push("2");
        //temp.push("3");
        //System.out.println("Queue is not empty: " + temp.empty());
        //System.out.println(temp.pop());
        //System.out.println(temp.pop());
        //System.out.println(temp.pop());
        //System.out.println("Queue is empty: " + temp.empty());
        //temp.push("4");
        //temp.push("5");
        //temp.push("6");
        //temp.push("7");
        //for (String item : temp) {
        //    System.out.println(item);
        //}
        //System.out.println(temp.pop());
        //System.out.println("Queue is not empty: " + temp.empty());
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        consumer.start();
        producer.start();
        //temp.add(new Product("1", "car"));
        //temp.add(new Product("2", "book"));
        //temp.add(new Product("3", "pan"));
        //temp.add(new Product("4", "table"));
        //temp.add(new Product("5", "cat"));
        //temp.add(new Product("6", "dog"));
        //System.out.println(temp.get());
        //System.out.println(temp.get());
        //System.out.println(temp.get());
        //System.out.println(temp.get());
        //System.out.println(temp.get());
        //System.out.println(temp.get());
        //System.out.println("finish");
        //temp.add(new Product("7", "bag"));
        //temp.add(new Product("8", "animal"));
        //temp.add(new Product("8", "animal"));
        //temp.add(new Product("8", "animal"));
        //temp.add(new Product("8", "animal"));
        /*
        System.out.println(temp.get());
        System.out.println(temp.get());
        System.out.println(temp.get());
        */
        /*
        for (Product product : temp.getAll()) {
            System.out.println(product);
        }
        */

    }

}