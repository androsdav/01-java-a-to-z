package com.adidyk;

/** Class Producer adds last product (in thread) to queue (object of class simpleBlockingQueue)
 * if queue is not full.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.03.2018.
 * @version 1.0.
 */
public class Producer implements Runnable {

    /**
     * @param product - is product.
     */
    private final SimpleBlockingQueue<Product> queue;

    /**
     * @param - is number of product.
     */
    private final int numberProduct;

    /**
     * Producer - constructor.
     * @param queue - is product.
     * @param numberProduct - is number of product.
     */
    Producer(SimpleBlockingQueue<Product> queue, int numberProduct) {
        this.queue = queue;
        this.numberProduct = numberProduct;
    }

    /**
     * run - adds product to end of queue (in loop, in thread) if queue is not full.
     */
    @Override
    public void run() {
        for (int index = 0; index < this.numberProduct; index++) {
            this.queue.add(new Product(String.valueOf(index), "product " + String.valueOf(index)));
        }
    }

}