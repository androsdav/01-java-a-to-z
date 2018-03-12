package com.adidyk;

/** Class StartUi for create jar file and run program (Producer-Consumer).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.03.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - run program, create Producer-Thread and Consumer-Thread.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        System.out.println("Producer-Consumer");
        SimpleBlockingQueue<Product> queue = new SimpleBlockingQueue<>(5);
        Thread producer = new Thread(new Producer(queue, 20));
        Thread consumer = new Thread(new Consumer(queue, 20));
        consumer.start();
        producer.start();
    }

}