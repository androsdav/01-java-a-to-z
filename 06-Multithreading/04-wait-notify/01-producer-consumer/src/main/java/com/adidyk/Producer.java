package com.adidyk;

/** Class StartUi for create jar file.
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
     * Producer - constructor.
     * @param queue - is product.
     */
    Producer(SimpleBlockingQueue<Product> queue) {
        this.queue = queue;
    }

    /**
     * run - is run.
     */
    @Override
    public void run() {
        for (int index = 0; index < 20; index++) {
            String id = String.valueOf(index);
            String name = String.valueOf("book" + index);
            this.queue.add(new Product(id, name));
        }
    }

}