package com.adidyk;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import static com.adidyk.Constant.SELL;
import static com.adidyk.Constant.BUY;
import static com.adidyk.Constant.ADD;
import static com.adidyk.Constant.DEL;
import static com.adidyk.Constant.TAG;
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
    private final HashMap<String, HashMap<String, HashMap<Integer, Order>>> book = new HashMap<>();

    void purseSAX(File file) {
        try {
            File inputFile = new File("orders.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
                if (string.startsWith(ADD)) {
                    this.addOrder(string);
                } else if (string.startsWith(DEL)) {
                    this.delOrder(string);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //this.show();
        new OrderBook(this.book);
        long finish = System.nanoTime();
        System.out.println("\n\n --------------- TIME FOR PROGRAM EXECUTION ---------------");
        System.out.printf(String.format("%n %s%4.7s%s%n", "t = ", (finish - start) / Math.pow(10, 9), " [s]"));
    }

    /**
     * addOrder - do searches needed book (book-1 or book-2 or book-3) in map, after that do
     * searches needed operation (SELL or BUY) in map and adds new order to map by id order.
     * @param string is one string from xml-file.
     */
    private void addOrder(String string) {
        Order order = this.purse(string, true);
        this.book.computeIfAbsent(order.getBook(), k -> new HashMap<>());
        this.book.get(order.getBook()).computeIfAbsent(order.getOperation(), k -> new HashMap<>());
        this.book.get(order.getBook()).get(order.getOperation()).put(order.getId(), order);
    }

    /**
     * delOrder  - do searches needed book (book-1 or book-2 or book-3) in map, after that do
     * searches needed operation (SELL or BUY) in map and remove order from map by id order.
     * @param string is one string from xml-file.
     */
    private void delOrder(String string) {
        Order order = this.purse(string, false);
        this.book.get(order.getBook()).get(SELL).remove(order.getId());
        this.book.get(order.getBook()).get(BUY).remove(order.getId());
    }

    /**
     * purse - purse one string? creates new object of class Order and returns new object.
     * @param string is string from xml-file.
     * @param addTrue if need to adds in map - addTrue = true, if need to remove from map addTrue = false.
     * @return is object by class Order.
     */
    private Order purse(String string, boolean addTrue) {
        int start = 0;
        int position = 0;
        boolean addStart = false;
        String[] value = new String[5];
        for (int index = 0; index < string.length(); index++) {
            if (!addStart && string.charAt(index) == TAG) {
                addStart = true;
                start = index + 1;
            }
            if (addStart && string.charAt(index + 1) == TAG) {
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
     * show - shows all orders off map.
     */
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

}