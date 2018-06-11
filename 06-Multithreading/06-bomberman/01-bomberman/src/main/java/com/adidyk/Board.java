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
    ReentrantLock [][] board = new ReentrantLock[5][5];


    /**
     * addHeroes - is hero.
     * @param bomber - is hero.
    */
    public void addHeroes(BomberMan bomber) {
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

    }
}
