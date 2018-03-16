package com.adidyk;

/** Class StartUi for create jar file and run program (Producer-Consumer).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
public class ThreadWork implements Runnable {

    /**
     * @param queue - is.
     */
    private final SimpleQueue<String> queue;

    /**
     * @param name - is name.
     */
    private final String name;

    /**
     * ThreadWork - constructor.
     * @param queue - is string.
     * @param name - is string.
     */
    ThreadWork(SimpleQueue<String> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    /**
     * run - is run.
     */
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this.queue) {
                while (this.queue.empty()) {
                    try {
                        this.queue.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                String result = this.queue.pop();
                System.out.println(this.name + " - > " + result);
            }
        }
    }
}
