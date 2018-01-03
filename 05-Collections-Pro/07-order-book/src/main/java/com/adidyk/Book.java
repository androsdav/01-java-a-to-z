package com.adidyk;

import java.io.File;
import java.util.HashMap;

/**
 * --------------------------------------------------------------------------------------------------------------
 * Class Book contains a container for storing orders.
 * Container is HashMap that contains books. Each book contains two HashMap - sell and buy.
 * HashMap sell and buy contains object of class Order (value) and key, where key is id of object of class Order.
 * --------------------------------------------------------------------------------------------------------------
 * Class Book has next method:
 * -> readerSAX  - reads all information from xml-file using SAX-purser;
 * -> readerUser - reads all information from xml-file using User-purser;
 * -> show       - shows all orders off map.
 * --------------------------------------------------------------------------------------------------------------
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
class Book {

    /**
     * @param book - link variable on container HashMap<String, HashMap<String, HashMap<Integer, Order>>>.
     */
    private HashMap<String, HashMap<String, HashMap<Integer, Order>>> book = new HashMap<>();

    /**
     * readerSAX - reads all information from xml-file using SAX-purser.
     * @param file - is pathname to file in format xml.
     */
    void readerSAX(File file) {
        System.out.println("\n\n -============{ SAX PURSER }============-");
        long start = System.nanoTime();
        PurserSAX purser = new PurserSAX(file);
        purser.purserSAX();
        this.book = purser.getBook();
        new OrderBook(this.book);
        long finish = System.nanoTime();
        System.out.println("\n\n ----------- TIME FOR PURSER -----------");
        System.out.printf(String.format("%n %s%4.7s%s%n", "t = ", (finish - start) / Math.pow(10, 9), " [s]"));
    }

    /**
     * readerUser - reads all information from xml-file using User-purser.
     * @param file - is pathname to file in format xml.
     */
    void readerUser(File file) {
        System.out.println("\n\n -============{ USER PURSER }============-");
        long start = System.nanoTime();
        PurserUser purser = new PurserUser(file);
        purser.purseUser();
        this.book = purser.getBook();
        new OrderBook(this.book);
        long finish = System.nanoTime();
        System.out.println("\n\n ----------- TIME FOR PURSER -----------");
        System.out.printf(String.format("%n %s%4.7s%s%n", "t = ", (finish - start) / Math.pow(10, 9), " [s]"));
    }

    /*
    /**
     * show - shows all orders off map.
     */
    /*
    private void show() {
        System.out.println("\n\n ------------------- ORDER BOOK STEP #1 -------------------");
        for (Map.Entry<String, HashMap<String, HashMap<Integer, Order>>> book : this.book.entrySet()) {
            System.out.println(String.format("%n %s", book.getKey()));
            for (Map.Entry<String, HashMap<Integer, Order>> operation : book.getValue().entrySet()) {
                System.out.println(String.format("%n  %s%n %27s", operation.getKey(), "----------------------------"));
                System.out.println(String.format(" %9s%9s%9s%n %27s", "id", "   V", "  P", "----------------------------"));
                for (Map.Entry<Integer, Order> iOrder : operation.getValue().entrySet()) {
                    System.out.println(String.format(" %9s%s", iOrder.getKey(), iOrder.getValue()));
                }
            }
        }
    }
    */

}