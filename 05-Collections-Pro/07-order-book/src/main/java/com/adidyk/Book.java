package com.adidyk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class Book {

    /**
     *
     */
    private OrderComparator comparator = new OrderComparator();
    /**
     * @param book is book. book and operation
     */
    private HashMap<String, HashMap<String, TreeMap<Integer, Order>>> book = new HashMap<>();

    /**
     * Is may first git huk in new ubuntu.
     * @param orders is orders
     */
    void readerXML(File orders) {
        //long start = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new FileReader(orders))) {
            String string;
            while ((string = br.readLine()) != null) {
                if (string.startsWith("<A")) {
                    System.out.println("add");
                    this.addOrder(string);
                } else if (string.startsWith("<D")) {
                    this.delOrder(string);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //long end = System.nanoTime();
        // System.out.println("Productivity:" + (end - start));
    }

    /**
     * @param string is string.
     */
    private void addOrder(String string) {
        Order order = this.purse(string, true);
        if (this.book.get(order.getBook()) == null) {
            this.book.put(order.getBook(), new HashMap<>());
        }
        if (this.book.get(order.getBook()).get(order.getOperation()) == null) {
            TreeMap<Integer, Order> orders = new TreeMap<>();
            Comparator comp = orders.comparator();
            this.book.get(order.getBook()).put(order.getOperation(), new TreeMap<>(comp));
        }
        this.book.get(order.getBook()).get(order.getOperation()).put(order.getId(), order);

        //if (this.book.get(order.getBook()) == null) {
        //    this.book.put(order.getBook(), new HashMap<>());
        //}
        //this.book.get(order.getBook()).put(order.getId(), order);
        //this.book.computeIfAbsent(order.getBook(), k -> new HashMap<>());
        //this.book.get(order.getBook()).put(order.getId(), order);
    }

    /**
     * @param string is string.
     */
    private void delOrder(String string) {
        Order order = this.purse(string, false);
        //this.book.get(order.getBook()).get(order.getOperation()).remove(order.getId());
        //this.book.get(order.getBook()).get(order.getOperation()).remove(order.getId());
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
    void view() {
        for (Map.Entry<String, HashMap<String, TreeMap<Integer, Order>>> iBook : this.book.entrySet()) {
            System.out.println(iBook.getKey());
            for (Map.Entry<String, TreeMap<Integer, Order>> iOperation : iBook.getValue().entrySet()) {
                System.out.println(iOperation.getKey());
                for (Map.Entry<Integer, Order> iOrder : iOperation.getValue().entrySet()) {
                    System.out.println(String.format("%s%8s%s", "id:", iOrder.getKey(), iOrder.getValue()));
                }
            }
            System.out.println();
        }
    }

    /**
     * @return is string.
     */
    @Override
    public String toString() {
        return String.format("%s", this.book);
    }

}