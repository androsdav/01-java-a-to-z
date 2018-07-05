package com.adidyk;

/**
 * Class MonsterMove create thread for move monster.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
public class MonsterMove extends Thread {

    /**
     * @param monster - is link variable to object of class Monster.
     */
    private final Monster monster;

    /**
     * @param border - is link variable to object of class Board.
     */
    private final Board board;

    /**
     * @param isRunning - is check for finishes of monster move.
     */
    private volatile boolean isRunning = true;

    /**
     * MonsterMove - constructor.
     * @param board - is link variable to object of class Board.
     * @param monster - is link variable to object of class Monster.
     */
    MonsterMove(Board board, Monster monster) {
        this.board = board;
        this.monster = monster;
    }

    /**
     * shutdown - change variable isRunning to false - finishes move monster.
     */
    void shutdown() {
        this.isRunning = false;
    }

    /**
     * run - runs thread for move monster.
     */
    @Override
    public void run() {
        this.infoStart();
        this.lock();
        this.move();
        this.infoFinish();
    }

    /**
     * infoStart - information that the monster begins to run.
     */
    private void infoStart() {
        System.out.println(String.format("%s%s%s", " -> ", this.monster.name(), " move start ... "));
    }

    /**
     * lock - locks cell of board in the begin game.
     */
    private void lock() {
        this.board.lockCell(this.monster.cell());
    }

    /**
     * move - monster moves every second to a new cell by vertical or horizontal.
     * When moving, monster try take a new cell - tryLock. If it does not work for 500 ms.,
     * then change the movement to opposite direction.
     */
    private void move() {
        while (this.isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Cell source = this.monster.cell();
            Cell dist = this.monster.way();
            if (this.board.move(source, dist)) {
                this.monster.clone(dist);
                System.out.println(" " + this.monster);
            } else {
                this.monster.setStep();
            }
        }
    }

    /**
     * infoFinish - information that the monster finish to run.
     */
    private void infoFinish() {
        System.out.println(String.format("%s%s%s", " -> ", this.monster.name(), " move finish ... "));
    }

}