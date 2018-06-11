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

    private final ReentrantLock locker = new ReentrantLock();

    /**
     *
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
        this.board.addHeroes(this.bomber);
    }

}