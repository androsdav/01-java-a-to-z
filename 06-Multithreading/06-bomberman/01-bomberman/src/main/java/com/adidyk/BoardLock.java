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
     * @param UP - is up.
     */
    private static final int UP = 1;

    /**
     * @param RIGHT - is up.
     */
    private static final int RIGHT = 2;

    /**
     * @param DOWN - is up.
     */
    private static final int DOWN = 3;

    /**
     * @param LEFT - is up.
     */
    private static final int LEFT = 4;

    /**
     * @param bomber - is bomber.
     */
    private final BomberMan bomber;

    /**
     * @param step - step.
     */
    private static final int STEP = 1;

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
    private final Board board;

    /**
     * @param board - is board.
     * @param bomber - is bomber.
     */
    BoardLock(Board board, BomberMan bomber) {
        this.board = board;
        this.bomber = bomber;
    }

    /**
     * run - is run.
     */
    @Override
    public void run() {
        System.out.println("Thread start");
        this.bomber.way(1 + (int) (Math.random() * 4));

        if () {

        }
        /*
        lock.lock();
        try {
            this.bomber.move(1);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        */
        System.out.println("Thread finish");
    }


}