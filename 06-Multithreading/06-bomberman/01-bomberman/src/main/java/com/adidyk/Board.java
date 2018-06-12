package com.adidyk;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
public class Board {

    /**
     * @param board - board.
     */
    private ReentrantLock[][] board = new ReentrantLock[5][5];

    /**
     * @param bomber - is bomber.
     */
    private BomberMan bomber;

    /**
     *
     * @param bomber - is bomber.
     */
    Board(BomberMan bomber) {
        this.bomber = bomber;
    }

    /**
     * addHeroes - is hero.
     * @param bomber - is hero.
    */
    void addHeroes(BomberMan bomber) {
        int positionX = bomber.getCell().getPositionX();
        int positionY = bomber.getCell().getPositionY();
        this.board[positionX][positionY].lock();
    }

    /**
     *
     * @param source - is source.
     * @param dist - is dist.
     * @return true or false.
     */
    public boolean move(Cell source, Cell dist) {

        return true;
    }
}
