package com.adidyk;

/**
 * --------------------------------------------------------------------------------------------------------------
 * Class Constant OrderBook contains a container for storing orders.
 * Container is HashMap that contains books. Each book contains two HashMap - sell and buy.
 * HashMap sell and buy contains object of class Order (value) and key, where key is price of object of class Order.
 * --------------------------------------------------------------------------------------------------------------
 * Class Book has next method:
 * -> calculate     - runs reads first line (one order) from file and calls method to addOrder or delOrder
 *                    depending on the type order, after that reads second line (one order) and loop is repeated
 *                    while lines will not finished;
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
class Constant {

    /**
     * @param SELL is sell operation.
     */
    static final String SELL = "SELL";

    /**
     * @param BUY is buy operation.
     */
    static final String BUY = "BUY";

    /**
     * @param ADD is added.
     */
    static final String ADD = "<A";

    /**
     * @param DEL is delete.
     */
    static final  String DEL = "<D";

    /**
     * @param TAG is tag.
     */
    static final Character TAG = '"';
}
