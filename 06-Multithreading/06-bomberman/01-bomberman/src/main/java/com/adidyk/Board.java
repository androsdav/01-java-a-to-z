package com.adidyk;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
class Board {

    /**
     * @param board - board.
     */
    private ReentrantLock[][] board;

    /**
     * ReentrantLock - constructor.
     * @param lengthX - is.
     * @param lengthY - is.
     */
    Board(int lengthX, int lengthY) {
        this.board = new ReentrantLock[lengthX][lengthY];
        this.init();
    }

    /**
     * init - init board.
     */
    private void init() {
        for (int indexX = 0; indexX < this.board.length; indexX++) {
            for (int indexY = 0; indexY < this.board[indexX].length; indexY++) {
                this.board[indexX][indexY] = new ReentrantLock();
            }
        }
    }

    /**
     * addHeroes - is hero.
     * @param cell - is cell.
    */
    void lockCell(Cell cell) {
        this.board[cell.getPositionX()][cell.getPositionY()].lock();
    }

    /**
     *
     * @param cell - is cell.
     */
    void unlock(Cell cell) {
        this.board[cell.getPositionX()][cell.getPositionY()].unlock();
    }

    /**
     * tryLockCell - cell.
     * @param source - is cell.
     * @param dist - is dist.
     * @return true.
     */
    private boolean tryLockCell(Cell source, Cell dist) {
        boolean tryLock = false;
        try {
            if (this.board[dist.getPositionX()][dist.getPositionY()].tryLock(500, TimeUnit.MILLISECONDS)) {
                System.out.println("[info]: tryLock true... ");
                tryLock = true;
                this.board[source.getPositionX()][source.getPositionY()].unlock();
            } else {
                System.out.println("[info]: tryLock false... ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tryLock;
    }

    /**
     * move - is move.
     * @param source - is source.
     * @param dist - is dist.
     * @return true or false.
     */
    boolean move(Cell source, Cell dist) {
        boolean cellIsFree = false;
        if ((0 <= dist.getPositionX() && dist.getPositionX() < this.board.length) && (0 <= dist.getPositionY() && dist.getPositionY() < this.board[source.getPositionX()].length)) {
            if (!this.board[dist.getPositionX()][dist.getPositionY()].isLocked()) {
                if (this.tryLockCell(source, dist)) {
                    cellIsFree = true;
                } else {
                    System.out.println("[info]: tryLock false... ");
                }
            } else {
                System.out.println("[info]: tryLock false... ");
            }
        } else {
            System.out.println("[info]: border...");
        }
        return cellIsFree;
    }

}