package com.adidyk;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
class Board {

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
     * @param board - board.
     */
    private ReentrantLock[][] board;

    /**
     * ReentrantLock - constructor.
     */
    Board(int lengthX, int lengthY) {
        this.board = new ReentrantLock[lengthX][lengthY];

    }

    /**
     * init - init board.
     */
    private void init() {
        for (int indexX = 0; indexX < this.board.length; indexX++) {
            for (int indexY = 0; indexY < this.board.length; indexY++) {
                this.board[indexX][indexY] = new ReentrantLock();
            }
        }
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
    boolean move(Cell source, Cell dist) {
        boolean wayIsFree = false;
        int positionX = dist.getPositionX();
        int positionY = dist.getPositionY();
        if (!this.board[positionX][positionY].isLocked()) {
            wayIsFree = true;
        }
        return wayIsFree;
    }
        /*
        if () {

        }

        /*
        boolean moveTrue = false;
        int positionX = source.getPositionX();
        int positionY = source.getPositionY();
        if (positionX == this.bomber.getCell().getPositionX() && positionY == this.bomber.getCell().getPositionY()) {
            int direction = 1 + (int) (Math.random() * 4);
            if (direction == UP) {
                if () {
                    this.bomber.moveUp();
                }
            } else if (direction == RIGHT) {
                this.bomber.moveRight();
            } else if (direction == DOWN) {
                this.bomber.moveDown();
            } else if (direction == LEFT) {
                this.bomber.moveLeft();
            }



        }
        */

}