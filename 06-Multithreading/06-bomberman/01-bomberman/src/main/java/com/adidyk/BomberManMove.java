package com.adidyk;

/**
 * Class BomberManMove create thread for move bomber-man.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
public class BomberManMove extends Thread {

    /**
     * @param bomber - is link variable to object of class BomberMan.
     */
    private final BomberMan bomber;

    /**
     * @param border - is link variable to object of class Board.
     */
    private final Board board;

    /**
     * @param isRunning - is check for finishes of bomber-man move.
     */
    private volatile boolean isRunning = true;

    /**
     * BomberManMove - constructor.
     * @param board - is link variable to object of class Board.
     * @param bomber - is link variable to object of class BomberMan.
     */
    BomberManMove(Board board, BomberMan bomber) {
        this.board = board;
        this.bomber = bomber;
    }

    /**
     * finish - change variable isRunning to false - finishes move bomber-man.
     */
    void finish() {
        this.isRunning = false;
    }

    /**
     * run - runs thread for move bomber-man.
     */
    @Override
    public void run() {
        this.infoStart();
        this.lock();
        this.move();
        this.infoFinish();
    }

    /**
     * lock - locks cell in the begin game.
     */
    private void lock() {
        this.board.lockCell(this.bomber.cell());
    }

    /**
     * move - hero moves every second to a new cell. When moving, hero try take a new cell - tryLock.
     * If it does not work for 500 ms. then change the movement to another cell.
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

    /**
     * infoStart - information that the bomber-man begins to run.
     */
    private void infoStart() {
        System.out.println(String.format("%s%s%s", " -> ", this.bomber.name(), " move start ... "));
    }

    /**
     * infoFinish - information that the bomber-man finish to run.
     */
    private void infoFinish() {
        System.out.println(String.format("%s%s%s", " -> ", this.bomber.name(), " move finish ... "));
    }

}