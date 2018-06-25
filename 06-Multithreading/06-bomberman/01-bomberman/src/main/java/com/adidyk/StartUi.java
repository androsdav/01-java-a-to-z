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
    }

}