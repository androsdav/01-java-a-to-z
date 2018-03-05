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
        SimpleBlockingQueue<Product> temp = new SimpleBlockingQueue<>(5);
        temp.add(new Product("1", "car"));
        temp.add(new Product("2", "book"));
        temp.add(new Product("3", "pan"));
        temp.add(new Product("4", "table"));
        temp.add(new Product("5", "cat"));
        //temp.add(new Product("6", "dog"));
        System.out.println(temp.get());
        System.out.println(temp.get());
        System.out.println(temp.get());
        System.out.println(temp.get());
        System.out.println(temp.get());
        System.out.println(temp.get());
        System.out.println("finish");
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