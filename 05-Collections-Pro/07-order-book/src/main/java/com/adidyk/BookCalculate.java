package com.adidyk;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class BookCalculate {

    /**
     * book is book. book and operation.
     */
    private HashMap<String, HashMap<String, TreeMap<Double, Order>>> list = new HashMap<>();

    /**
     * book is book. book and operation.
     */
    private HashMap<String, HashMap<String, HashMap<Integer, Order>>> book;

    /**
     * BookContainer is constructor.
     * @param book is book.
     */
    BookCalculate(HashMap<String, HashMap<String, HashMap<Integer, Order>>> book) {
        this.book = book;
        this.addTree();
        this.view();
    }

    /**
     * addTree is new tree container.
     */
    private void addTree() {
        for (Map.Entry<String, HashMap<String, HashMap<Integer, Order>>> iBook : this.book.entrySet()) {
            if (this.list.get(iBook.getKey()) == null) {
                this.list.put(iBook.getKey(), new HashMap<>());
            }

            for (Map.Entry<String, HashMap<Integer, Order>> iOperation : iBook.getValue().entrySet()) {
                if (this.list.get(iBook.getKey()).get(iOperation.getKey()) == null) {
                    this.list.get(iBook.getKey()).put(iOperation.getKey(), new TreeMap<>());
                }
                for (Map.Entry<Integer, Order> iOrder : iOperation.getValue().entrySet()) {
                    this.list.get(iBook.getKey()).get(iOperation.getKey()).put(iOrder.getValue().getPrice(), iOrder.getValue());
                }
            }
        }
    }

    /**
     * view is view.
     */
    private void view() {
        for (Map.Entry<String, HashMap<String, TreeMap<Double, Order>>> iBook : this.list.entrySet()) {
            System.out.println(iBook.getKey());
            for (Map.Entry<String, TreeMap<Double, Order>> iOperation : iBook.getValue().entrySet()) {
                System.out.println(iOperation.getKey());
                for (Map.Entry<Double, Order> iOrder : iOperation.getValue().entrySet()) {
                    System.out.println(String.format("%s%8s%s", "id:", iOrder.getKey(), iOrder.getValue()));
                }
            }
        }
    }


}
