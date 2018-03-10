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
        for (int index = 0; index < 1000; index++) {
            String id = String.valueOf(index);
            String name = String.valueOf("book" + index);
            this.queue.add(new Product(id, name));
        }
        //this.queue.add(new Product("1", "book1"));
        //this.queue.add(new Product("2", "book2"));
        //this.queue.add(new Product("3", "book3"));
        //this.queue.add(new Product("4", "book4"));
        //this.queue.add(new Product("5", "book5"));
        //this.queue.add(new Product("6", "book6"));
    }

}