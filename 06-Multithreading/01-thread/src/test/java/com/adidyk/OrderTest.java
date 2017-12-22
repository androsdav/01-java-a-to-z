package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class OrderTest for testing methods class Order.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class OrderTest {

    /**
     * @param order - object of class Order with params: book, operation, price, volume, id.
     */
    private final Order order = new Order("book-1", "SELL", 100.98, 54, 123);

    /**
     * setBookTest - tests method setBook class Order.
     */
    @Test
    public void setBookTest() {
        this.order.setBook("book-2");
        assertThat("book-2", is(this.order.getBook()));
    }

    /**
     * setOperationTest - tests method setOperation class Order.
     */
    @Test
    public void setOperationTest() {
        this.order.setOperation("BUY");
        assertThat("BUY", is(this.order.getOperation()));
    }

    /**
     * setPriceTest - tests method setPrice class Order.
     */
    @Test
    public void setPriceTest() {
        this.order.setPrice(99.87);
        assertThat(99.87, is(this.order.getPrice()));
    }

    /**
     * setVolumeTest - tests method setVolume class Order.
     */
    @Test
    public void setVolumeTest() {
        this.order.setVolume(100);
        assertThat(100, is(this.order.getVolume()));
    }

    /**
     * setIdTest - tests method setVolume class Order.
     */
    @Test
    public void setIdTest() {
        this.order.setId(1);
        assertThat(1, is(this.order.getId()));
    }

    /**
     * getBookTest - tests method getBook class Order.
     */
    @Test
    public void getBookTest() {
        assertThat("book-1", is(this.order.getBook()));
    }

    /**
     * getOperationTest - tests method getOperation class Order.
     */
    @Test
    public void getOperationTest() {
        assertThat("SELL", is(this.order.getOperation()));
    }

    /**
     * getPriceTest - tests method getPrice class Order.
     */
    @Test
    public void getPriceTest() {
        assertThat(100.98, is(this.order.getPrice()));
    }

    /**
     * getVolumeTest - tests method getVolume class Order.
     */
    @Test
    public void getVolumeTest() {
        assertThat(54, is(this.order.getVolume()));
    }

    /**
     * getIdTest - tests method getId class Order.
     */
    @Test
    public void getIdTest() {
        assertThat(123, is(this.order.getId()));
    }

}