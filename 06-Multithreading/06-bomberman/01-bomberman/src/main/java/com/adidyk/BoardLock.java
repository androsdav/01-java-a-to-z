package com.adidyk;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
public class BoardLock implements Runnable {

    /**
     * @param bomber - is bomber.
     */
    private final BomberMan bomber;

    /*
    /**
     * @param board - board.
     */
    /*
    private final Board board;
     */

    /**
     * @param locker - is locker.
     */
    private final ReentrantLock lock;

    /**
     * @param lock - is board.
     * @param bomber - is bomber.
     */
    BoardLock(ReentrantLock lock, BomberMan bomber) {
        this.lock = lock;
        this.bomber = bomber;
    }

    /**
     * run - is run.
     */
    @Override
    public void run() {
        System.out.println("Thread start");
        lock.lock();
        try {
            this.bomber.move(1);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("Thread finish");
    }

}