package com.adidyk;

/** Class StartUi for create jar file.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.03.2018.
 * @version 1.0.
 */
public class Consumer implements Runnable {

    /**
     * @param queue - is queue.
     */
    private final SimpleBlockingQueue queue;

    /**
     *
     * @param queue - is queue.
     */
    Consumer(SimpleBlockingQueue queue) {
        this.queue = queue;
    }

    /**
     * run - is run.
     */
    @Override
    public void run() {
        for (int index = 0; index < 20; index++) {
            //System.out.println("get: " + result + " count = " + this.counter);
            System.out.println("get: " + this.queue.get());
        }
    }

}