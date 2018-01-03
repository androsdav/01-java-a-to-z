package com.adidyk;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedList;
import static com.adidyk.Constant.SELL;
import static com.adidyk.Constant.BUY;

/**
 * --------------------------------------------------------------------------------------------------------------
 * Class OrderBook contains a container for storing orders.
 * Container is HashMap that contains books. Each book contains two HashMap - sell and buy.
 * HashMap sell and buy contains object of class Order (value) and key, where key is price of object of class Order.
 * --------------------------------------------------------------------------------------------------------------
 * Class OrderBook has next method:
 * -> addOrderBook  - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed
 *                    operation (SELL or BUY) in map and adds new order to map by price order. If the card already
 *                    has order with the same price, then the existing order increases volume by the amount of the
 *                    order to be added.
 * -> getOrderBook - is returns list sell-order and buy-order for each book. for building and output list order-book.
 *                    (SELL or BUY) in map and remove order from map by id order.
 * -> showOrderBook - is building and output (show) list order-book for each book.
 * -> show          - show sell-order and buy-order for each book.
 * -> showInfo      - showInfo - output to console static information for each book.
 * --------------------------------------------------------------------------------------------------------------
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
class OrderBook {

    /**
     * @param book - link variable on container HashMap<String, HashMap<String, HashMap<Integer, Order>>>
     * (key = book -> key = operation -> <key = id, value = order>).
     */
    private HashMap<String, HashMap<String, HashMap<Integer, Order>>> book;

    /**
     * @param orderBook - link variable on container HashMap<String, HashMap<String, HashMap<Integer, Order>>>
     * (key = book -> key = operation ->, <key = price, value = order>).
     */
    private HashMap<String, HashMap<String, TreeMap<Double, Order>>> orderBook;

    /**
     * OrderBook - constructor.
     * @param book  - link variable on container HashMap<String, HashMap<String, HashMap<Integer, Order>>>.
     */
    OrderBook(HashMap<String, HashMap<String, HashMap<Integer, Order>>> book) {
        this.book = book;
        this.orderBook = new HashMap<>();
        this.addOrderBook();
        this.getOrderBook();
    }

    /**
     * addOrderBook - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed
     * operation (SELL or BUY) in map and adds new order to map by price order. If the card already has order with
     * the same price, then the existing order increases volume by the amount of the order to be added. Also all sales
     * orders are sorted by price increase and all buys orders are sorted by price reduction.
     */
    private void addOrderBook() {
        for (Map.Entry<String, HashMap<String, HashMap<Integer, Order>>> book : this.book.entrySet()) {
            this.orderBook.computeIfAbsent(book.getKey(), k -> new HashMap<>());
            for (Map.Entry<String, HashMap<Integer, Order>> operation : book.getValue().entrySet()) {
                if (this.orderBook.get(book.getKey()).get(operation.getKey()) == null) {
                    if (SELL.equals(operation.getKey())) {
                        this.orderBook.get(book.getKey()).put(operation.getKey(), new TreeMap<>(new OrderSellComparator()));
                    } else if (BUY.equals(operation.getKey())) {
                        this.orderBook.get(book.getKey()).put(operation.getKey(), new TreeMap<>(new OrderBuyComparator()));
                    }
                }
                for (Map.Entry<Integer, Order> order : operation.getValue().entrySet()) {
                    if (this.orderBook.get(book.getKey()).get(operation.getKey()).containsKey(order.getValue().getPrice())) {
                        Order newOrder = this.orderBook.get(book.getKey()).get(operation.getKey()).get(order.getValue().getPrice());
                        newOrder.setVolume(newOrder.getVolume() + order.getValue().getVolume());
                    } else {
                        this.orderBook.get(book.getKey()).get(operation.getKey()).put(order.getValue().getPrice(), order.getValue());
                    }
                }
            }
        }
    }

    /**
     * getOrderBook - is returns list sell-order and buy-order for each book. for building and output list order-book.
     */
    private void getOrderBook() {
        LinkedList<Order> sellList = null;
        LinkedList<Order> buyList = null;
        for (Map.Entry<String, HashMap<String, TreeMap<Double, Order>>> book : this.orderBook.entrySet()) {
            for (Map.Entry<String, TreeMap<Double, Order>> operation : book.getValue().entrySet()) {
                if (SELL.equals(operation.getKey())) {
                    sellList = new LinkedList<>(operation.getValue().values());
                    } else if (BUY.equals(operation.getKey())) {
                    buyList = new LinkedList<>(operation.getValue().values());
                }
            }
            this.showOrderBook(book.getKey(), sellList, buyList);
        }
    }

    /**
     * showOrderBook - is building and output (show) list order-book for each book.
     * @param sellList - consist only from sell-order.
     * @param buyList - consist only from buy-order.
     * @param book - book number.
     */
    private void showOrderBook(String book, LinkedList<Order> sellList, LinkedList<Order> buyList) {
        this.showInfo(book);
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
     * showInfo - output to console static information for each book.
     * @param book book number.
     */
    private void showInfo(String book) {
        System.out.println(String.format("%n %s", book));
        System.out.println(String.format("%n  %s%22s", BUY, SELL));
        System.out.println(String.format(" %27s", "-------------------  -------------------"));
        System.out.println(String.format(" %9s%9s%12s%9s", "V", "   P", "  V", "  P"));
        System.out.println(String.format(" %27s", "-------------------  -------------------"));
    }

    /*
    /**
     * show - sell-order and buy-order for each book.
     */
    /*
    private void show() {
        System.out.println("\n\n ------------------- ORDER BOOK STEP #2 -------------------");
        for (Map.Entry<String, HashMap<String, TreeMap<Double, Order>>> book : this.orderBook.entrySet()) {
            System.out.println(String.format("%n %s", book.getKey()));
            for (Map.Entry<String, TreeMap<Double, Order>> operation : book.getValue().entrySet()) {
                System.out.println(String.format("%n  %s%n %19s", operation.getKey(), "-------------------"));
                System.out.println(String.format(" %9s%9s%n %19s", "   V", "  P", "-------------------"));
                for (Map.Entry<Double, Order> order : operation.getValue().entrySet()) {
                    System.out.println(String.format(" %9s", order.getValue()));
                }
            }
        }
    }
    */

}