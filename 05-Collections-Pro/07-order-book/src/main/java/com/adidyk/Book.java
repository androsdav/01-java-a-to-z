package com.adidyk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class Book {

    /**
     * @param order - is order.
     */
    private HashMap<String, Order> orders = new HashMap<>();
//    private Order order = new Order("book-1", "buy", 100, 200, 1);

    /**
     *
     * @param orders is orders
     */
    void readerXML(File orders) {
        try (BufferedReader br = new BufferedReader(new FileReader(orders))) {
            String string;
            while ((string = br.readLine()) != null) {
                if (string.startsWith("<A")) {
                    this.addOrder(string);
                }
                if (string.startsWith("<D")) {
                    this.delOrder(string);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param string is string.
     */
    private void addOrder(String string) {
        String[] value = this.purse(string);
        Order order = new Order(value[0], value[1], Double.valueOf(value[2]), Integer.valueOf(value[3]), value[4]);
        this.orders.put(order.getId(), order);
    }

    /**
     *
     * @param string is string.
     */
    private void delOrder(String string) {
        String[] value = this.purse(string);
        this.orders.remove(value[1]);
    }

    /**
     * @param string is string.
     * @return is object by class Order.
     */
    private String[] purse(String string) {
        int start = 0;
        int end;
        boolean add = false;
        String[] value = new String[5];
        int position = 0;
        for (int index = 0; index < string.length(); index++) {
            if (!add && string.charAt(index) == '"') {
                add = true;
                start = index + 1;
            }
            if (add && string.charAt(index + 1) == '"') {
                add = false;
                end = index + 1;
                value[position++] = string.substring(start, end).trim();
                index++;
            }
        }
        return value;
    }

    /**
     *
     * @return is size.
     */
    int getSize() {
        return this.orders.size();
    }

    /**
     * view is view.
     */
    void view() {
        for (Map.Entry<String, Order> item : this.orders.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }


    /**
     *
     * @return is string.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s", "Book{", "orders=", this.orders, "}");
    }
}