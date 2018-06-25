package com.adidyk;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class Board create playing board where every cell is object of class ReentrantLock.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
class Board {

    /**
     * @param board - playing board.
     */
    private ReentrantLock[][] board;

    /**
     * ReentrantLock - constructor.
     * Sets size of playing board and initializations all cells of board - new ReentrantLock().
     * @param lengthX - number of lines of playing board.
     * @param lengthY - number of columns of playing board.
     */
    Board(int lengthX, int lengthY) {
        this.board = new ReentrantLock[lengthX][lengthY];
        this.init();
    }

    /**
     * init - initialization all cells of board - new ReentrantLock().
     */
    private void init() {
        for (int indexX = 0; indexX < this.board.length; indexX++) {
            for (int indexY = 0; indexY < this.board[indexX].length; indexY++) {
                this.board[indexX][indexY] = new ReentrantLock();
            }
        }
    }

    /**
     * lockCell - locks cell in the begin game.
     * @param cell - is cell that is blocked in the begin game (begin position for unit).
    */
    void lockCell(Cell cell) {
        this.board[cell.getPositionX()][cell.getPositionY()].lock();
    }

    /**
     * move - verifies the possibility of the hero moving from the source cell to the destination cell.
     * If the destination cell is not locked then hero try locked destination cell in the 500 ms. time.
     * If hero block destination cell, then source cell is unlocking and method returns true, if hero don`t block
     * destination cell, then source cell isn`t unlocking and method returns false.
     * @param source - is source cell.
     * @param dist - is distance cell.
     * @return - returns true if hero block destination cell or returns false if returns false if hero don`t block
     * destination cell.
     */
    boolean move(Cell source, Cell dist) {
        boolean tryLock = false;
        if (this.checkBorder(source, dist)) {
            if (this.tryLockCell(source, dist)) {
                tryLock = true;
                System.out.println(" [info]: tryLock true ... ");
            } else {
                System.out.println(" [info]: tryLock false ... ");
            }
        } else {
            System.out.println(" [info]: border...");
        }
        return tryLock;
    }

    /**
     * checkBorder - check border of paying board.
     * @param source - is source cell.
     * @param dist - is distance cell.
     * @return - returns true if destination cell is limit borders of playing board or returns false id
     * destination cell is out borders of playing board.
     */

    private boolean checkBorder(Cell source, Cell dist) {
        boolean border = false;
        if (0 <= dist.getPositionX() && dist.getPositionX() < this.board.length) {
            if (0 <= dist.getPositionY() && dist.getPositionY() < this.board[source.getPositionX()].length) {
                border = true;
            }
        }
        return border;
    }

    /**
     * tryLockCell - if the destination cell is not locked then hero try locked destination cell in the 500 millisecond
     * time, if hero block destination cell, then source cell is unlocking and method returns true, if hero don`t block
     * destination cell, then source cell isn`t unlocking and method returns false.
     * @param source - is source cell.
     * @param dist - is distance.
     * @return - returns true if hero block destination cell or returns false if returns false if hero don`t block
     * destination cell.
     */
    private boolean tryLockCell(Cell source, Cell dist) {
        boolean tryLock = false;
        try {
            if (this.board[dist.getPositionX()][dist.getPositionY()].tryLock(500, TimeUnit.MILLISECONDS)) {
                tryLock = true;
                this.board[source.getPositionX()][source.getPositionY()].unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tryLock;
    }

}