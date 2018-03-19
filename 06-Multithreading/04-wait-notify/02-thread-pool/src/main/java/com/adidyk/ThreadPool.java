package com.adidyk;

/** Class ThreadPool creates thread poll by number core of processor
 * and starts thread pool.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
class ThreadPool {

    /**
     * @param - is link variable to array thread.
     */
    private Thread[] thread;

    /**
     * @param queue - is.
     */
    private final SimpleQueue<Work> queue;

    /**
     * @param quantity - is.
     */
    private int quantity;

    /**
     * @param isRunning =- is running.
     */
    private volatile boolean isRunning = true;

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
     * start - is run. haltura
     */
    private void start() {
        for (int index = 0; index < this.quantity; index++) {
            this.thread[index] = new Thread(new ThreadWork("thread-" + index));
            this.thread[index].start();
        }
    }

    /**
     * add - is add.
     * @param work - is string.
     */
    void add(Work work) {
        if (this.isRunning) {
            synchronized (this.queue) {
                this.queue.push(work);
                this.queue.notifyAll();
            }
        }
    }

    /**
     * threadIntercepted - is.
     */
    void shutdown() {
        this.isRunning = false;
    }

    /** Class StartUi for create jar file and run program (Producer-Consumer).
     * @author Didyk Andrey (androsdav@bigmir.net).
     * @since 13.03.2018.
     * @version 1.0.
     */
    private class ThreadWork implements Runnable {

        /**
         * @param name - is name.
         */
        private final String name;

        /**
         * ThreadWork - constructor.
         * @param name - is string.
         */
        ThreadWork(String name) {
            this.name = name;
        }

        /**
         * run - is run.
         */
        @Override
        public void run() {
            while (isRunning) {
                synchronized (queue) {
                    while (queue.empty() && isRunning) {
                        try {
                            queue.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (!queue.empty()) {
                        System.out.println(this.name + " -> " + queue.pop().toString());
                    }
                }
            }
        }
    }

}