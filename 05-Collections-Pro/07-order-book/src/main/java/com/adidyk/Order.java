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
    private Double price;

    /**
     * volume - is volume of application, how many lots(shares) to buy / sell.
     */
    private int volume;

    /**
     * id - is id.
     */
    private Integer id;

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

    /**
     *
     * @param book is set.
     */
    public void setBook(String book) {
        this.book = book;
    }

    /**
     *
     * @param operation is set.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     *
     * @param price is set.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     *
     * @param volume is set.
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     *
     * @param id is set.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return is get.
     */
    public String getBook() {
        return book;
    }

    /**
     *
     * @return is get.
     */
    public String getOperation() {
        return operation;
    }

    /**
     *
     * @return is get.
     */
    public Double getPrice() {
        return price;
    }

    /**
     *
     * @return is get.
     */
    public int getVolume() {
        return volume;
    }

    /**
     *
     * @return is get.
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @return all param for Order
     */
    @Override
    public String toString() {
        return String.format("%7s%10s%5s", this.operation, this.price, this.volume);
    }

}