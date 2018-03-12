package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleQueueTest does testing method of class SimpleQueue.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.03.2018.
 * @version 1.0.
 */
public class SimpleQueueTest {

    /**
     * @param queue - is reference variable to object of class SimpleQueue.
     */
    private SimpleQueue<Product> queue = new SimpleQueue<>();

    /**
     * @param product1 - is reference variable to object of class Product.
     */
    private Product product1 = new Product("1", "product1");

    /**
     * @param product2 - is reference variable to object of class Product.
     */
    private Product product2 = new Product("2", "product2");

    /**
     * @param product3 - is reference variable to object of class Product.
     */
    private Product product3 = new Product("3", "product3");

    /**
     * @param product4 - is reference variable to object of class Product.
     */
    private Product product4 = new Product("4", "product4");

    /**
     * @param it - iterator.
     */
    private Iterator it;

    /**
     * init - initialisation all parameters and adds new products to container queue.
     */
    @Before
    public void init() {
        this.queue.push(new Product("1", "product1"));
        this.queue.push(new Product("2", "product2"));
        this.queue.push(new Product("3", "product3"));
        this.queue.push(new Product("4", "product4"));
        this.it = queue.iterator();
    }

    /**
     * emptyTrueTest - tests method empty of class SimpleQueue when queue is empty.
     */
    @Test
    public void emptyTrueTest() {
        SimpleQueue<Product> queue = new SimpleQueue<>();
        assertThat(true, is(queue.empty()));
    }

    /**
     * emptyTrueTest - tests method empty of class SimpleQueue when queue is not empty.
     */
    @Test
    public void emptyFalseTest() {
        SimpleQueue<Product> queue = new SimpleQueue<>();
        final Product result = queue.push(this.product1);
        assertThat(false, is(queue.empty()));
        assertThat(new Product("1", "product1"), is(result));
    }

    /**
     * peekTest - tests method peek of class SimpleQueue.
     */
    @Test
    public void peekTest() {
        assertThat(new Product("1", "product1"), is(this.queue.peek()));
    }

    /**
     * popTest - tests method pop of class SimpleQueue.
     */
    @Test
    public void popTest() {
        assertThat(new Product("1", "product1"), is(this.queue.pop()));
        assertThat(new Product("2", "product2"), is(this.queue.peek()));
    }

    /**
     * searchTrueTest - tests method search of class SimpleQueue when object is in queue.
     */
    @Test
    public void searchTrueTest() {
        assertThat(4, is(this.queue.search(new Product("4", "product4"))));
        assertThat(1, is(this.queue.search(new Product("1", "product1"))));
    }

    /**
     * searchFalseTest - tests method search of class SimpleQueue when object is not in queue.
     */
    @Test
    public void searchFalseTest() {
        assertThat(-1, is(this.queue.search(new Product("5", "product5"))));
    }

    /**
     * sizeTest - tests method size of class SimpleQueue.
     */
    @Test
    public void sizeTest() {
        assertThat(4, is(this.queue.size()));
    }

    /**
     * forEachTest - tests method forEach of class SimpleQueue.
     */
    @Test
    public void forEachTest() {
        Object[] resultActual = new Object[] {this.product1, this.product2, this.product3, this.product4};
        Object[] resultExpected = new Object[4];
        int index = 0;
        for (Product product : this.queue) {
            resultExpected[index++] = product;
        }
        assertThat(resultActual, is(resultExpected));
    }

    /**
     * nextTest - it tests method next for iterator when next element from container is true.
     */
    @Test
    public void nextTest() {
        this.it.next();
        this.it.next();
        assertThat(new Product("3", "product3"), is(this.it.next()));
    }

    /**
     * hasNextTrueTest - it tests method hasNext for iterator when next element from container is true.
     */
    @Test
    public void hasNextTrueTest() {
        this.it.next();
        this.it.next();
        this.it.hasNext();
        assertThat(true, is(this.it.hasNext()));
    }

    /**
     * hasNextFalseTest - it tests method hasNext for iterator when next element from container is true.
     */
    @Test
    public void hasNextFalseTest() {
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.hasNext();
        this.it.hasNext();
        assertThat(false, is(this.it.hasNext()));
    }

    /**
     * loopTest - it test loop for iterator.
     */
    @Test
    public void loopTest() {
        Object[] resultActual = new Object[] {this.product1, this.product2, this.product3, this.product4};
        Object[] resultExpected = new Object[4];
        int index = 0;
        while (this.it.hasNext()) {
            resultExpected[index++] = this.it.next();
        }
        assertThat(resultActual, is(resultExpected));
    }

}