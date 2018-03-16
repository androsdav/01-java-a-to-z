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
    private ThreadWork thread;

    /**
     * ThreadPoll - constructor.
     */
    ThreadPool() {
        this.thread = new ThreadWork();
    }

    /**
     * execute - is execute.
     */
    void execute() {
        this.thread.start();
    }

}
