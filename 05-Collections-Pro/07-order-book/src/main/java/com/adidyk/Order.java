package com.adidyk;

/**
 * Class Order for create order (object) with params: book, operation, price, volume, id.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class Order {

    /**
     * book - identification action.
     */
    private String book;

    /**
     * operation - type operation: buy or sell.
     */
    private String operation;

    /**
     * price - price order.
     */
    private Double price;

    /**
     * volume - volume of application, how many lots(shares) to buy / sell.
     */
    private int volume;

    /**
     * id - id order.
     */
    private Integer id;

    /**
     * Constructor - constructor.
     * @param book - book number.
     * @param operation - operation: sell or buy order.
     * @param price - price order.
     * @param volume - volume order.
     * @param id - id order.
     */
    Order(String book, String operation, double price, int volume, int id) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.id = id;
    }

    /**
     * setBook - sets book number.
     * @param book book number.
     */
    public void setBook(String book) {
        this.book = book;
    }

    /**
     * setOperation - sets operation order.
     * @param operation sell or buy order.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * setPrice - sets price order.
     * @param price is set.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * setVolume - sets volume order.
     * @param volume is set.
     */
    void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * setId - sets id order.
     * @param id id order.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getBook - gets book number.
     * @return book number.
     */
    String getBook() {
        return book;
    }

    /**
     * getOperation - gets operation order.
     * @return operation order.
     */
    String getOperation() {
        return operation;
    }

    /**
     * getPrice - gets price order.
     * @return price order.
     */
    Double getPrice() {
        return price;
    }

    /**
     * getVolume - gets volume order.
     * @return volume order.
     */
    int getVolume() {
        return volume;
    }

    /**
     * getId - gets id order.
     * @return id order.
     */
    Integer getId() {
        return id;
    }

    /**
     *
     * @return all param for Order
     */
    @Override
    public String toString() {
        return String.format("%9s%9s", this.volume, this.price);
    }

}