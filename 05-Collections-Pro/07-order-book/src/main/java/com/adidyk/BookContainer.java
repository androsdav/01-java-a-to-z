package com.adidyk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * --------------------------------------------------------------------------------------------------------------
 * Class BookContainer contains a container for storing orders.
 * Container is HashMap that contains books. Each book contains two HashMap - sell and buy.
 * HashMap sell and buy contains object of class Order (value) and key, where key is id of object of class Order.
 * Class BookContainer contains structure following order storage structure:
 * -> HashMap<String, HashMap<String, HashMap<Integer, Order>>> book
 * Class BookContainer read xml-file,
 * --------------------------------------------------------------------------------------------------------------
 * Class BookContainer has next method:
 * -> readerXML - reads first line (one order) from file and calls method to addOrder or delOrder
 *                depending on the type order, after that reads second line (one order) and loop is repeated
 *                while lines will not finished;
 * -> addOrder  - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 *                (SELL or BUY) in map and adds new order to map by id order;
 * -> delOrder  - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 *                (SELL or BUY) in map and remove order from map by id order.
 * -> purse     - purse one string? creates new object of class Order and returns new object.
 * -> show      - shows all orders off map.
 * book
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
class BookContainer {

    /**
     * @param book is link variable on container HashMap<String, HashMap<String, HashMap<Integer, Order>>>.
     */
    private final HashMap<String, HashMap<String, HashMap<Integer, Order>>> book = new HashMap<>();

    /**
     * readerXML - reads first line (one order) from file and calls method to addOrder or delOrder
     * depending on the type order, after that reads second line (one order) and loop is repeated
     * while lines will not finished.
     * @param file is pathname to file in format xml.
     */
    void readerXML(File file) {
        long start = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String string;
            while ((string = br.readLine()) != null) {
                if (string.startsWith("<A")) {
                    this.addOrder(string);
                } else if (string.startsWith("<D")) {
                    this.delOrder(string);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        new BookCalculate(this.book);
        long finish = System.nanoTime();
        System.out.println("\n\n --------------- TIME FOR PROGRAM EXECUTION ---------------");
        System.out.printf(String.format("%n %s%4.7s%s%n", "t = ", (finish - start) / Math.pow(10, 9), " [s]"));
    }

    /**
     * @param string is string.
     */
    private void addOrder(String string) {
        Order order = this.purse(string, true);
        this.book.computeIfAbsent(order.getBook(), k -> new HashMap<>());
        this.book.get(order.getBook()).computeIfAbsent(order.getOperation(), k -> new HashMap<>());
        this.book.get(order.getBook()).get(order.getOperation()).put(order.getId(), order);
    }

    /**
     * @param string is string.
     */
    private void delOrder(String string) {
        Order order = this.purse(string, false);
        this.book.get(order.getBook()).get("SELL").remove(order.getId());
        this.book.get(order.getBook()).get("BUY").remove(order.getId());
    }

    /**
     * @param string is string.
     * @param addTrue is true or false.
     * @return is object by class Order.
     */
    private Order purse(String string, boolean addTrue) {
        int start = 0;
        int position = 0;
        boolean addStart = false;
        String[] value = new String[5];
        for (int index = 0; index < string.length(); index++) {
            if (!addStart && string.charAt(index) == '"') {
                addStart = true;
                start = index + 1;
            }
            if (addStart && string.charAt(index + 1) == '"') {
                addStart = false;
                value[position++] = string.substring(start, index + 1).trim();
                index++;
            }
        }
        if (addTrue) {
            return new Order(value[0], value[1], Double.valueOf(value[2]), Integer.valueOf(value[3]), Integer.valueOf(value[4]));
        } else {
            return new Order(value[0], null, 0, 0,  Integer.valueOf(value[1]));
        }
    }

    /**
     * view is view.
     */
    private void showAllOrder() {
        System.out.println("\n\n ------------------- ORDERS BOOK STEP #1 -------------------");
        for (Map.Entry<String, HashMap<String, HashMap<Integer, Order>>> iBook : this.book.entrySet()) {
            System.out.println(String.format("%n %s", iBook.getKey()));
            for (Map.Entry<String, HashMap<Integer, Order>> iOperation : iBook.getValue().entrySet()) {
                System.out.println(String.format("%n  %s%n %27s", iOperation.getKey(), "----------------------------"));
                System.out.println(String.format(" %9s%9s%9s%n %27s", "id", "   V", "  P", "----------------------------"));
                for (Map.Entry<Integer, Order> iOrder : iOperation.getValue().entrySet()) {
                    System.out.println(String.format(" %9s%s", iOrder.getKey(), iOrder.getValue()));
                }
            }
        }
    }

}