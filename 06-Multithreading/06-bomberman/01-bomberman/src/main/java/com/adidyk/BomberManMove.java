package com.adidyk;

//import java.util.concurrent.locks.ReentrantLock;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
public class BomberManMove implements Runnable {

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
     * @param bomber - is bomber.
     */
    private final BomberMan bomber;

    /**
     * @param step - step.
     */
    private static final int STEP = 1;

    /*
    /**
     * @param board - board.
     */
    /*
    private final Board board;
     */

    /**
     * @param locker - is locker.
     */
    private final Board board;

    /**
     * @param board - is board.
     * @param bomber - is bomber.
     */
    BomberManMove(Board board, BomberMan bomber) {
        this.board = board;
        this.bomber = bomber;
        this.board.lockCell(this.bomber.getCell());
    }

    /**
     * run - is run.
     */
    @Override
    public void run() {
        System.out.println(" -> BomberMan move start");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Cell source = this.bomber.getCell();
            Cell dist = this.bomber.way();
            if (this.board.move(source, dist)) {
                this.bomber.clone(dist);
                System.out.println("Bomber source: " + this.bomber.getCell());
            } else {
                System.out.println("cell is lock ...");
            }
        }
     //   System.out.println(" <- BomberMan move finish");
    }


}