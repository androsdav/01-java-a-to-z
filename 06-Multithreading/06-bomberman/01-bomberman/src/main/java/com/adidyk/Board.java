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
        return true;
    }
}
