package com.adidyk;

/** Class StartUi for create jar file and run program (Producer-Consumer).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
class ThreadPool {

    /**
     * @param - is thread.
     */
    private Thread[] thread;

    /**
     * @param queue - is.
     */
    private final SimpleQueue<String> queue;

    /**
     * @param quantity - is.
     */
    private int quantity;

    /**
     * ThreadPoll - constructor.
     * @param quantity - is.
     */
    ThreadPool(int quantity) {
        this.quantity = quantity;
        this.thread = new Thread[this.quantity];
        this.queue = new SimpleQueue<>();
        this.start();
    }

    /**
     * start - is run.
     */
    private void start() {
        for (int index = 0; index < this.quantity; index++) {
            this.thread[index] = new Thread(new ThreadWork(this.queue, "thread" + index));
            this.thread[index].start();
        }
    }

    /**
     * add - is add.
     * @param string - is string.
     */
    void add(String string) {
        synchronized (this.queue) {
            this.queue.push(string);
            this.queue.notifyAll();
        }
    }

    /**
     * threadIntercepted - is.
     */
    void finish() {
        synchronized (this.queue) {
            while (!this.queue.empty()) {
                try {
                    this.queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

      //  this.thread.interrupt();
    }

}
