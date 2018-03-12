package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleBlockingQueueTest does testing method of class SimpleBlockingQueue.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.03.2018.
 * @version 1.0.
 */
public class SimpleBlockingQueueTest {

    /**
     * @param queue - reference variable to object of class SimpleBlockingQueue.
     */
    private SimpleBlockingQueue<Product> queueActual = new SimpleBlockingQueue<>(3);

    /**
     * @param queue - reference variable to object of class SimpleBlockingQueue.
     */
    private SimpleBlockingQueue<Product> queueExpected = new SimpleBlockingQueue<>(3);

    /**
     * init - initialisation all parameters and adds new products to container bounded blocking queue.
     */
    @Before
    public void init() {
        queueActual.add(new Product("1", "product1"));
        queueActual.add(new Product("2", "product2"));
        queueActual.add(new Product("3", "product3"));
        queueExpected.add(new Product("1", "product1"));
        queueExpected.add(new Product("2", "product2"));
        queueExpected.add(new Product("3", "product3"));
    }

    /**
     * addTest - tests method add of class SimpleBlockingQueue.
     */
    @Test
    public void addTest() {
        assertThat(this.queueActual, is(this.queueExpected));
    }

    /**
     * getTest - tests methos get of class SimpleBlockingQueue.
     */
    @Test
    public void getTest() {
        assertThat(new Product("1", "product1"), is(this.queueActual.get()));
        assertThat(new Product("2", "product2"), is(this.queueActual.get()));
        assertThat(new Product("3", "product3"), is(this.queueActual.get()));
    }

}