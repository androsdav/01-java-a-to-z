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
        Order order = this.purse(string, true);
        this.orders.put(order.getId(), order);
    }

    /**
     *
     * @param string is string.
     */
    private void delOrder(String string) {
        Order order = this.purse(string, false);
        this.orders.remove(order.getId());
    }

    /**
     * @param string is string.
     * @param addTrue is true or false.
     * @return is object by class Order.
     */
    private Order purse(String string, boolean addTrue) {
        int start = 0;
        int position = 0;
        boolean startAdd = false;
        String[] value = new String[5];
        for (int index = 0; index < string.length(); index++) {
            if (!startAdd && string.charAt(index) == '"') {
                startAdd = true;
                start = index + 1;
            }
            if (startAdd && string.charAt(index + 1) == '"') {
                startAdd = false;
                value[position++] = string.substring(start, index + 1).trim();
                index++;
            }

        }
        if (addTrue) {
            return new Order(value[0], value[1], Double.valueOf(value[2]), Integer.valueOf(value[3]), value[4]);
        } else {
            return new Order(value[0], null, 0, 0,  value[1]);
        }
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