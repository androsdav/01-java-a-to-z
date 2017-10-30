package com.adidyk;

/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class Order {

    /**
     * book - is identification action.
     */
    private String book;

    /**
     * operation - is type operation: buy or sell.
     */
    private String operation;

    /**
     * price - is price.
     */
    private double price;

    /**
     * volume - is volume of application, how many lots(shares) to buy / sell.
     */
    private int volume;

    /**
     * id - is id.
     */
    private int id;

    /**
     * Constructor - is constructor.
     * @param book is book.
     * @param operation is operation.
     * @param price is price.
     * @param volume is volume.
     * @param id is id.
     */
    Order(String book, String operation, double price, int volume, int id) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.id = id;
    }

}