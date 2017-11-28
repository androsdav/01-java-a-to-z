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
    private HashMap<String, HashMap<String, TreeMap<Integer, Order>>> list = new HashMap<>();

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
    }

    public void addTree() {
        for (Map.Entry<String, HashMap<String, HashMap<Integer, Order>>> iBook : this.book.entrySet()) {
            this.list.put(iBook.getKey(), new HashMap<>());
            for (Map.Entry<String, HashMap<Integer, Order>> iOperation : iBook.getValue().entrySet()) {
                this.list.get(iBook.getKey()).put(iOperation.getKey(), new TreeMap<>());
                for (Map.Entry<Integer, Order> iOrder : iOperation.getValue().entrySet()) {
                    this.list.get(iBook).get(iOperation);
                }
            }
        }
    }


}
