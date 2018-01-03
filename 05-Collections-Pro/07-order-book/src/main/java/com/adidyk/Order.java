package com.adidyk;

/**
 * Class Order for create order (object) with params: book, operation, price, volume, id.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class Order {

    /**
     * @param book - identification action.
     */
    private String book;

    /**
     * @param operation - type operation: buy or sell.
     */
    private String operation;

    /**
     * @param price - price order.
     */
    private Double price;

    /**
     * @param volume - volume of application, how many lots(shares) to buy / sell.
     */
    private int volume;

    /**
     * @param id - id order.
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
     * @param book - book number.
     */
    void setBook(String book) {
        this.book = book;
    }

    /**
     * setOperation - sets operation order.
     * @param operation - sell or buy order.
     */
    void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * setPrice - sets price order.
     * @param price - price order.
     */
    void setPrice(Double price) {
        this.price = price;
    }

    /**
     * setVolume - sets volume order.
     * @param volume - volume order.
     */
    void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * setId - sets id order.
     * @param id - id order.
     */
    void setId(Integer id) {
        this.id = id;
    }

    /**
     * getBook - gets book number.
     * @return - returns book number.
     */
    String getBook() {
        return book;
    }

    /**
     * getOperation - gets operation order.
     * @return - returns operation order.
     */
    String getOperation() {
        return operation;
    }

    /**
     * getPrice - gets price order.
     * @return - returns price order.
     */
    Double getPrice() {
        return price;
    }

    /**
     * getVolume - gets volume order.
     * @return - returns volume order.
     */
    int getVolume() {
        return volume;
    }

    /**
     * getId - gets id order.
     * @return - returns id order.
     */
    Integer getId() {
        return id;
    }

    /**
     * equals - returns boolean result.
     * @param obj - object of class Order.
     * @return - returns boolean result "true" if name and number of children and birthday
     * users is same, and return "false" if all params users isn`t same.
     **/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Order order = (Order) obj;
        if (this.volume != order.volume) {
            return false;
        }
        if (!this.book.equals(order.book)) {
            return false;
        }
        if (!this.operation.equals(order.operation)) {
            return false;
        }
        if (!this.price.equals(order.price)) {
            return false;
        }
        return this.id.equals(order.id);
    }

    /**
     * hashCode - returns hashCode for order.
     * @return - returns hashCode for order.
     */
    @Override
    public int hashCode() {
        int result = book.hashCode();
        result = 31 * result + operation.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + volume;
        result = 31 * result + id.hashCode();
        return result;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for order.
     */
    @Override
    public String toString() {
        return String.format("%9s%9s", this.volume, this.price);
    }

}