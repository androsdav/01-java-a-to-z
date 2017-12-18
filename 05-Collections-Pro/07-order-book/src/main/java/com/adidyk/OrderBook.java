package com.adidyk;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedList;

/**
 * --------------------------------------------------------------------------------------------------------------
 * Class OrderBook contains a container for storing orders.
 * Container is HashMap that contains books. Each book contains two HashMap - sell and buy.
 * HashMap sell and buy contains object of class Order (value) and key, where key is price of object of class Order.
 * --------------------------------------------------------------------------------------------------------------
 * Class Book has next method:
 * -> calculate     - reads first line (one order) from file and calls method to addOrder or delOrder
 *                    depending on the type order, after that reads second line (one order) and loop is repeated
 *                    while lines will not finished;
 * -> addOrderBook  - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 *                    (SELL or BUY) in map and adds new order to map by id order;
 * -> getOrderBook  - delOrder  - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 *                    (SELL or BUY) in map and remove order from map by id order.
 * -> showOrderBook - purse one string? creates new object of class Order and returns new object.
 * -> show          - shows all orders off map.
 * -> showInfo      - book
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
class OrderBook {

    /**
     * book is book. book and operation.
     */
    private HashMap<String, HashMap<String, HashMap<Integer, Order>>> book;

    /**
     * book is book. book and operation.
     */
    private HashMap<String, HashMap<String, TreeMap<Double, Order>>> orderBook;

    /**
     * Book is constructor.
     * @param book is book.
     */
    OrderBook(HashMap<String, HashMap<String, HashMap<Integer, Order>>> book) {
        this.book = book;
        this.orderBook = new HashMap<>();
    }

    /**
     * is calculate.
     */
    void calculate() {
        this.addOrderBook();
        this.show();
        this.getOrderBook();
    }

    /**
     * addTree is new tree container.
     */
    private void addOrderBook() {
        for (Map.Entry<String, HashMap<String, HashMap<Integer, Order>>> iBook : this.book.entrySet()) {
            this.orderBook.computeIfAbsent(iBook.getKey(), k -> new HashMap<>());
            for (Map.Entry<String, HashMap<Integer, Order>> iOperation : iBook.getValue().entrySet()) {
                if (this.orderBook.get(iBook.getKey()).get(iOperation.getKey()) == null) {
                    if (iOperation.getKey().equals("SELL")) {
                        this.orderBook.get(iBook.getKey()).put(iOperation.getKey(), new TreeMap<>(new OrderSellComparator()));
                    } else if (iOperation.getKey().equals("BUY")) {
                        this.orderBook.get(iBook.getKey()).put(iOperation.getKey(), new TreeMap<>(new OrderBuyComparator()));
                    }
                }
                for (Map.Entry<Integer, Order> iOrder : iOperation.getValue().entrySet()) {
                    if (this.orderBook.get(iBook.getKey()).get(iOperation.getKey()).containsKey(iOrder.getValue().getPrice())) {
                        Order order = this.orderBook.get(iBook.getKey()).get(iOperation.getKey()).get(iOrder.getValue().getPrice());
                        order.setVolume(order.getVolume() + iOrder.getValue().getVolume());
                    } else {
                        this.orderBook.get(iBook.getKey()).get(iOperation.getKey()).put(iOrder.getValue().getPrice(), iOrder.getValue());
                    }
                }
            }
        }
    }

    /**
     * glass is glass.
     */
    private void getOrderBook() {
        System.out.println("\n\n ------------------- ORDER BOOK STEP #3 -------------------");
        LinkedList<Order> sellList = null;
        LinkedList<Order> buyList = null;
        for (Map.Entry<String, HashMap<String, TreeMap<Double, Order>>> iBook : this.orderBook.entrySet()) {
            for (Map.Entry<String, TreeMap<Double, Order>> iOperation : iBook.getValue().entrySet()) {
                if (iOperation.getKey().equals("SELL")) {
                    sellList = new LinkedList<>(iOperation.getValue().values());
                    } else if (iOperation.getKey().equals("BUY")) {
                    buyList = new LinkedList<>(iOperation.getValue().values());
                }
            }
            this.showOrderBook(iBook.getKey(), sellList, buyList);
        }
    }

    /**
     * temp is temp.
     * @param sellList is List.
     * @param buyList is List.
     * @param iBook is book.
     */
    private void showOrderBook(String iBook, LinkedList<Order> sellList, LinkedList<Order> buyList) {
        this.showInfo(iBook);
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
    private void show() {
        System.out.println("\n\n ------------------- ORDER BOOK STEP #2 -------------------");
        for (Map.Entry<String, HashMap<String, TreeMap<Double, Order>>> iBook : this.orderBook.entrySet()) {
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

    /**
     *
     * @param iBook is string.
     */
    private void showInfo(String iBook) {
        System.out.println(String.format("%n %s", iBook));
        System.out.println(String.format("%n  %s%22s", "BUY", "SELL"));
        System.out.println(String.format(" %27s", "-------------------  -------------------"));
        System.out.println(String.format(" %9s%9s%12s%9s", "V", "   P", "  V", "  P"));
        System.out.println(String.format(" %27s", "-------------------  -------------------"));
    }

}