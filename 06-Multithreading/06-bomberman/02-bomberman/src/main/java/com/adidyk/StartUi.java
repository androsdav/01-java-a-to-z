package com.adidyk;

/**
 * Class StartUi for create jar file and run program (BomberMan).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 23.05.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        Board board = new Board(10, 10);
        Block rock1 = new Block(new Cell(1, 4), "rock1");
        Block rock2 = new Block(new Cell(7, 4), "rock2");
        Block rock3 = new Block(new Cell(4, 1), "rock3");
        Block rock4 = new Block(new Cell(4, 6), "rock4");
        board.lockCell(rock1.cell());
        board.lockCell(rock2.cell());
        board.lockCell(rock3.cell());
        board.lockCell(rock4.cell());
        ThreadPool threadPool = new ThreadPool(board, 3);
        threadPool.add(new Monster(new Cell(4, 4), "monster1"));
        threadPool.add(new Monster(new Cell(5, 5), "monster2"));
        threadPool.add(new Monster(new Cell(6, 6), "monster3"));
        threadPool.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }

}