package com.adidyk;

/**
 * Class Monster create thread for move monster.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
public class MonsterMove extends Thread {

    /**
     * @param bomber - is link variable to object of class Monster.
     */
    private final Monster monster;

    /**
     * @param border - is link variable to object of class Board.
     */
    private final Board board;


    /**
     * BomberManMove - constructor.
     * @param board - is link variable to object of class Board.
     * @param monster - is link variable to object of class Monster.
     */
    MonsterMove(Board board, Monster monster) {
        this.board = board;
        this.monster = monster;
    }

    /**
     * run - runs thread for move monster.
     */
    @Override
    public void run() {
        this.board.lockCell(this.monster.cell());
        while (true) {
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

}