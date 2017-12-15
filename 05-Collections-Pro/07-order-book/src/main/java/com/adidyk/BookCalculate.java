package com.adidyk;

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
        this.view();
        this.glass();
    }

    /**
     * addTree is new tree container.
     */
    private void addTree() {
        for (Map.Entry<String, HashMap<String, HashMap<Integer, Order>>> iBook : this.book.entrySet()) {
            this.list.computeIfAbsent(iBook.getKey(), k -> new HashMap<>());
            for (Map.Entry<String, HashMap<Integer, Order>> iOperation : iBook.getValue().entrySet()) {
                if (this.list.get(iBook.getKey()).get(iOperation.getKey()) == null) {
                    if (iOperation.getKey().equals("SELL")) {
                        this.list.get(iBook.getKey()).put(iOperation.getKey(), new TreeMap<>(this.sellComp));
                    } else if (iOperation.getKey().equals("BUY")) {
                        this.list.get(iBook.getKey()).put(iOperation.getKey(), new TreeMap<>(this.buyComp));
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
        System.out.println("\n\n ------------------- ORDERS BOOK STEP #3 -------------------");
        for (Map.Entry<String, HashMap<String, TreeMap<Double, Order>>> iBook : this.list.entrySet()) {
            for (Map.Entry<String, TreeMap<Double, Order>> iOperation : iBook.getValue().entrySet()) {
                if (iOperation.getKey().equals("SELL")) {
                    this.sell = new LinkedList<>(iOperation.getValue().values());
                    } else if (iOperation.getKey().equals("BUY")) {
                    this.buy = new LinkedList<>(iOperation.getValue().values());
                }
            }
            this.temp(iBook.getKey(), this.sell, this.buy);
        }
    }

    /**
     * temp is temp.
     * @param sellList is List.
     * @param buyList is List.
     * @param iBook is book.
     */
    private void temp(String iBook, LinkedList<Order> sellList, LinkedList<Order> buyList) {
        System.out.println(String.format("%n %s", iBook));
        System.out.println(String.format("%n  %s%22s", "BUY", "SELL"));
        System.out.println(String.format(" %27s", "-------------------  -------------------"));
        System.out.println(String.format(" %9s%9s%12s%9s", "V", "   P", "  V", "  P"));
        System.out.println(String.format(" %27s", "-------------------  -------------------"));
        Order sell = sellList.pollFirst();
        Order buy = buyList.pollFirst();
        boolean work = true;
        do {
            if (sell != null && buy != null) {
                if (buy.getPrice() >= sell.getPrice()) {
                    if (buy.getVolume() > sell.getVolume()) {
                        buy.setVolume(buy.getVolume() - sell.getVolume());
                        sell = sellList.pollFirst();
                    } else if (buy.getVolume() < sell.getVolume()) {
                        sell.setVolume(sell.getVolume() - buy.getVolume());
                        buy = buyList.pollFirst();
                    } else if (buy.getVolume() == sell.getVolume()) {
                        sell = sellList.pollFirst();
                        buy = buyList.pollFirst();
                    }
                } else {
                    System.out.println(String.format(" %9s%21s", buy, sell));
                    sell = sellList.pollFirst();
                    buy = buyList.pollFirst();
                }
            } else if (sell == null && buy != null) {
                System.out.println(String.format(" %9s%21s", buy, "- - - - -    - - -"));
                buy = buyList.pollFirst();
            } else if (sell != null) {
                System.out.println(String.format(" %9s%21s", "- - - - -    - - -", sell));
                sell = sellList.pollFirst();
            } else {
                work = false;
            }
        } while (work);
    }

    /**
     * view is view.
     */
    private void view() {
        System.out.println("\n\n ------------------- ORDERS BOOK STEP #2 -------------------");
        for (Map.Entry<String, HashMap<String, TreeMap<Double, Order>>> iBook : this.list.entrySet()) {
            System.out.println(String.format("%n %s", iBook.getKey()));
            for (Map.Entry<String, TreeMap<Double, Order>> iOperation : iBook.getValue().entrySet()) {
                System.out.println(String.format("%n  %s%n %19s", iOperation.getKey(), "-------------------"));
                System.out.println(String.format(" %9s%9s%n %19s", "   V", "  P", "-------------------"));
                for (Map.Entry<Double, Order> iOrder : iOperation.getValue().entrySet()) {
                    System.out.println(String.format(" %9s", iOrder.getValue()));
                }
            }
        }
    }

}