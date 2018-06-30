package com.adidyk;

/**
 * Class StartUi for create jar file and run program (BomberManMove).
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
        /*
        Board board = new Board(10, 10);
        BomberMan bomber = new BomberMan(new Cell(4, 4), "bomber");
        BomberMan rock = new BomberMan(new Cell(3, 4), "rock");
        BomberMan block = new BomberMan(new Cell(4, 5), "block");
        BomberMan wall = new BomberMan(new Cell(4, 3), "wall");
        board.lockCell(rock.cell());
        board.lockCell(block.cell());
        board.lockCell(wall.cell());
        BomberManMove bomberMove = new BomberManMove(board, bomber);
        bomberMove.start();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bomberMove.finish();
        */
        Board board = new Board(9, 7);
        Monster rock1 = new Monster(new Cell(1, 4), "rock1");
        Monster rock2 = new Monster(new Cell(7, 4), "rock2");
        Monster rock3 = new Monster(new Cell(4, 1), "rock3");
        Monster rock4 = new Monster(new Cell(4, 6), "rock1");
        board.lockCell(rock1.cell());
        board.lockCell(rock2.cell());
        board.lockCell(rock3.cell());
        board.lockCell(rock4.cell());
        Monster monster1 = new Monster(new Cell(4, 4), "monster1");
        MonsterMove monsterMove1 = new MonsterMove(board, monster1);
        Monster monster2 = new Monster(new Cell(5, 5), "monster2");
        MonsterMove monsterMove2 = new MonsterMove(board, monster2);
        monsterMove1.start();
        monsterMove2.start();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monsterMove1.finish();
        monsterMove2.finish();
    }

}