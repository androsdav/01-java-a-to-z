package com.adidyk;

/** Class Consumer gets first product (in thread) from queue (object of class SimpleBlockingQueue)
 * if queue contains at least one product.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.03.2018.
 * @version 1.0.
 */
public class Consumer implements Runnable {

    /**
     * @param queue - is link variable to object of class SimpleBlockingQueue.
     */
    private final SimpleBlockingQueue queue;

    /**
     * @param - is number of product.
     */
    private final int numberProduct;


    /**
     * Consumer - constructor.
     * @param queue - is link variable to object of class SimpleBlockingQueue.
     * @param numberProduct - is number of product.
     */
    Consumer(SimpleBlockingQueue queue, int numberProduct) {
        this.queue = queue;
        this.numberProduct = numberProduct;
    }

    /**
     * run - gets first product (in thread) from queue if queue contains at least one product.
     */
    @Override
    public void run() {
        for (int index = 0; index < numberProduct; index++) {
            this.queue.get();
        }
    }

}