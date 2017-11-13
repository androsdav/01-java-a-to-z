package com.adidyk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

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
    private HashMap<String, Order> order = new HashMap<>();
//    private Order order = new Order("book-1", "buy", 100, 200, 1);

    /**
     *
     * @param orders is orders
     */
    void readerXML(File orders) {
        try (BufferedReader br = new BufferedReader(new FileReader(orders))) {
            String string;
            while ((string = br.readLine()) != null) {
 //               System.out.println(line);
                if (string.startsWith("<A")) {
                    this.purse(string);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param string is string.
     */
    private void addOrder(String string) {
    }

    /**
     *
     * @param string is string.
     */
    private void delOrder(String string) {
    }

    /**
     *
     * @param string is string.
     */
    private void purse(String string) {
        int start = 0;
        int end;
        boolean add = false;
        String[] order = new String[5];
        int position = 0;
        for (int index = 0; index < string.length(); index++) {
            if (!add && string.charAt(index) == '"') {
                add = true;
                start = index + 1;
            }
            if (add && string.charAt(index + 1) == '"') {
                add = false;
                end = index + 1;
                order[position++] = string.substring(start, end).trim();
                index++;
            }
        }
        for (String anOrder : order) {
            System.out.println(anOrder);
        }
        System.out.println();
    }
}