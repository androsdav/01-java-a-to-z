package com.adidyk;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
public class BomberManMove extends Thread {

    /**
     * @param bomber - is bomber.
     */
    private final BomberMan bomber;

    /**
     * @param locker - is locker.
     */
    private final Board board;

    /**
     * @param isRunning - is running.
     */
    private volatile boolean isRunning = true;

    /**
     * @param board - is board.
     * @param bomber - is bomber.
     */
    BomberManMove(Board board, BomberMan bomber) {
        this.board = board;
        this.bomber = bomber;
    }

    /**
     * stop - is stop.
     */
    void finish() {
        this.isRunning = false;
    }

    /**
     * run - is run.
     */
    @Override
    public void run() {
        System.out.println(" -> BomberMan move start");
        this.lock();
        this.move();
        System.out.println(" -> BomberMan move start");
    }

    /**
     * lock - is lock.
     */
    private void lock() {
        this.board.lockCell(this.bomber.cell());
    }

    /**
     * move - is move.
     */
    private void move() {
        while (this.isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Cell source = this.bomber.cell();
            Cell dist = this.bomber.way();
            if (this.board.move(source, dist)) {
                this.bomber.clone(dist);
                System.out.println(" " + this.bomber);
            }
        }
    }

}