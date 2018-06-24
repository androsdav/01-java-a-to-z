package com.adidyk;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 23.05.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - runs program only for create jar file.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        Test test = new Test(5);
        System.out.println(test.x);
        /*
        BomberMan bomber = new BomberMan(new Cell(0, 0), "bomber1");
        BomberMan bomber1 = new BomberMan(new Cell(1, 1), "bomber1");
        Board board = new Board(2, 2);
        board.lockCell(bomber1.getCell());
        BomberManMove bomberMove = new BomberManMove(board, bomber);
        bomberMove.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bomberMove.finish();
        */
    }

}