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
 * -> readerXML - reads first line (one order) from file and calls method to addOrder or delOrder
 *                depending on the type order, after that reads second line (one order) and loop is repeated
 *                while lines will not finished;
 * -> addOrder  - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 *                (SELL or BUY) in map and adds new order to map by id order;
 * -> delOrder  - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 *                (SELL or BUY) in map and remove order from map by id order.
 * -> purse     - purse one string? creates new object of class Order and returns new object.
 * -> show      - shows all orders off map.
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
     * reader SAX is SAX.
     * @param file is file name.
     */
    void readerSAX(File file) {
        System.out.println("\n\n -============{ SAX PURSER }============-");
        long start = System.nanoTime();
        PurserSAX purser = new PurserSAX(file);
        purser.purserSAX();
        this.book = purser.getOrder();
        new OrderBook(this.book);
        long finish = System.nanoTime();
        System.out.println("\n\n ----------- TIME FOR PURSER -----------");
        System.out.printf(String.format("%n %s%4.7s%s%n", "t = ", (finish - start) / Math.pow(10, 9), " [s]"));
    }

    /**
     * readerXML - reads first line (one order) from file and calls method to addOrder or delOrder
     * depending on the type order, after that reads second line (one order) and loop is repeated
     * while lines will not finished.
     * @param file is pathname to file in format xml.
     */
    void readerXML(File file) {
        System.out.println("\n\n -============{ USER PURSER }============-");
        long start = System.nanoTime();
        PurserUser purser = new PurserUser(file);
        purser.purseUser();
        this.book = purser.getOrder();
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