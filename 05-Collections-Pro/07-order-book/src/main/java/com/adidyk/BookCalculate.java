package com.adidyk;

//import sun.reflect.generics.tree.Tree;
//import javax.swing.*;
//import java.util.Collection;
//import java.util.*;
//import java.util.*;
//import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedList;

/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class BookCalculate {

    /**
     *  sell is sell.
     */
    private LinkedList<Order> sell;
    //private TreeMap<Double, Order> sell = new TreeMap<>();

    /**
     *  buy is buy.
     */
    private LinkedList<Order> buy;


    /**
     * sell is sell.
     */
    private OrderSellComparator sellComp = new OrderSellComparator();

    /**
     * buy is buy.
     */
    private OrderBuyComparator buyComp = new OrderBuyComparator();

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
        this.glass();
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
                    if (iOperation.getKey().equals("SELL")) {
                        this.list.get(iBook.getKey()).put(iOperation.getKey(), new TreeMap<>(sellComp));
                    } else if (iOperation.getKey().equals("BUY")) {
                        this.list.get(iBook.getKey()).put(iOperation.getKey(), new TreeMap<>(buyComp));
                    }
                }
                for (Map.Entry<Integer, Order> iOrder : iOperation.getValue().entrySet()) {
                    if (this.list.get(iBook.getKey()).get(iOperation.getKey()).containsKey(iOrder.getValue().getPrice())) {
                        Order order = this.list.get(iBook.getKey()).get(iOperation.getKey()).get(iOrder.getValue().getPrice());
                        order.setVolume(order.getVolume() + iOrder.getValue().getVolume());
                    } else {
                        this.list.get(iBook.getKey()).get(iOperation.getKey()).put(iOrder.getValue().getPrice(), iOrder.getValue());
                    }

                }
            }
        }
    }

    /**
     * glass is glass.
     */
    private void glass() {
        System.out.println("--------------GLASS-------------");
        for (Map.Entry<String, HashMap<String, TreeMap<Double, Order>>> iBook : this.list.entrySet()) {
            for (Map.Entry<String, TreeMap<Double, Order>> iOperation : iBook.getValue().entrySet()) {
                if (iOperation.getKey().equals("SELL")) {
                    sell = new LinkedList<>(iOperation.getValue().values());
                    //System.out.println(sell.pollFirst());
                    //for (Object order : sell) {
                    //    System.out.println(order);
                    //}
                    } else if (iOperation.getKey().equals("BUY")) {
                    buy = new LinkedList<>(iOperation.getValue().values());
                    //for (Object order : buy) {
                    //    System.out.println(order);
                    //}
                }
                    //this.temp(sell, buy);
                    //for (Map.Entry<Double, Order> iOrder : iOperation.getValue().values()) {
                    //}
            }
            this.temp(sell, buy);
        }
    }

    /**
     * temp is temp.
     * @param sellList is List.
     * @param buyList is List.
     */
    private void temp(LinkedList<Order> sellList, LinkedList<Order> buyList) {
        Order sell = sellList.pollFirst();
        Order buy = buyList.pollFirst();
        System.out.println();
        System.out.println(String.format("%s%s", sell, buy));
    }
        /*
        do {

        } while (!sell.isEmpty() && !buy.isEmpty());
        */

/*
        int array;
        if (this.sell.size() > this.buy.size()) {
            array = this.sell.size();
        } else {
            array = this.buy.size();
        }

        for (int i = 0; i < array; i++) {
            if (this.buy.get(i).setVolume();) {

            }

                //System.out.println();

        }

    }
*/
    /**
     * view is view.
     */
    private void view() {
        System.out.println("---------------LIST---------------");
        for (Map.Entry<String, HashMap<String, TreeMap<Double, Order>>> iBook : this.list.entrySet()) {
            System.out.println(iBook.getKey());
            for (Map.Entry<String, TreeMap<Double, Order>> iOperation : iBook.getValue().entrySet()) {
                System.out.println(iOperation.getKey());
                for (Map.Entry<Double, Order> iOrder : iOperation.getValue().entrySet()) {
                    System.out.println(String.format("%s%8s%s", "price:", iOrder.getKey(), iOrder.getValue()));
                }
            }
        }
    }


}
