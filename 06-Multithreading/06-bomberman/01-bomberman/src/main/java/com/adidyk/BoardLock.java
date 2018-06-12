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

    /**
     * @param board - board.
     */
    private final Board board;

    /**
     * @param locker - is locker.
     */
    private final ReentrantLock locker = new ReentrantLock();

    /**
     * @param board - is board.
     * @param bomber - is bomber.
     */
    public BoardLock(Board board, BomberMan bomber) {
        this.board = board;
        this.bomber = bomber;
    }

    /**
     * run - is run.
     */
    @Override
    public void run() {
        int direction = (int) (Math.random() * 5);
        bomber.move(direction);
        this.board.addHeroes(this.bomber);
    }

}