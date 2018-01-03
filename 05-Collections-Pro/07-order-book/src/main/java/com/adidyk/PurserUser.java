package com.adidyk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import static com.adidyk.Constant.ADD;
import static com.adidyk.Constant.DEL;
import static com.adidyk.Constant.SELL;
import static com.adidyk.Constant.BUY;
import static com.adidyk.Constant.TAG;

/**
 * --------------------------------------------------------------------------------------------------------------
 * Class PurserUser contains a container for storing orders.
 * Container is HashMap that contains books. Each book contains two HashMap - sell and buy.
 * HashMap sell and buy contains object of class Order (value) and key, where key is id of object of class Order.
 * --------------------------------------------------------------------------------------------------------------
 * Class PurserUser has next method:
 * -> purserUser - reads first line (one order) from file and calls method to addOrder or delOrder
 *                 depending on the type order, after that reads second line (one order) and loop is repeated
 *                 while lines will not finished;
 * -> addOrder   - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 *                 (SELL or BUY) in map and adds new order to map by id order;
 * -> delOrder   - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 *                 (SELL or BUY) in map and remove order from map by id order.
 * -> purse      - purse one string, creates new object of class Order and returns new object.
 * -> getBook    - returns reference variable to book.
 * --------------------------------------------------------------------------------------------------------------
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class PurserUser {

    /**
     * @param book - link variable on container HashMap<String, HashMap<String, HashMap<Integer, Order>>>.
     */
    private final HashMap<String, HashMap<String, HashMap<Integer, Order>>> book = new HashMap<>();

    /**
     * @param file - is pathname to file in format xml.
     */
    private final File file;

    /**
     * PurserUser - constructor.
     * @param file is pathname file in format xml.
     */
    PurserUser(File file) {
        this.file = file;
    }

    /**
     * purserUser - reads first line (one order) from file and calls method to addOrder or delOrder
     * depending on the type order, after that reads second line (one order) and loop is repeated
     * while lines will not finished.
     */
    void purseUser() {
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
    }

    /**
     * addOrder - do searches needed book (book-1 or book-2 or book-3) in map, after that do
     * searches needed operation (SELL or BUY) in map and adds new order to map by id order.
     * @param string - is one string from xml-file.
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
     * @param string - is one string from xml-file.
     */
    private void delOrder(String string) {
        Order order = this.purse(string, false);
        this.book.get(order.getBook()).get(SELL).remove(order.getId());
        this.book.get(order.getBook()).get(BUY).remove(order.getId());
    }

    /**
     * purse - purse one string creates new object of class Order and returns new object.
     * @param string - is string from xml-file.
     * @param addTrue - if need to adds in map - addTrue = true, if need to remove from map addTrue = false.
     * @return - returns new object by class Order.
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
     * getBook - returns reference variable to book.
     * @return - returns reference variable to book.
     */
    public HashMap<String, HashMap<String, HashMap<Integer, Order>>> getBook() {
        return this.book;
    }

}