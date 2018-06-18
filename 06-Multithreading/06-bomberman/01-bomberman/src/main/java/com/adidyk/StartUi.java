package com.adidyk;

//import java.util.concurrent.locks.ReentrantLock;

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
        int[][] array = new int[5][5];
        array[1][2] = 3;
        System.out.println(array[1][2]);
        BomberMan bomber1 = new BomberMan(new Cell(3, 2), "bomber1");
        BomberMan bomber2 = new BomberMan(new Cell(2, 2), "bomber2");
        Board board = new Board();
        board.addHeroes(bomber1);
        board.addHeroes(bomber2);
        boolean result = board.move(bomber1.getCell(), new Cell(1, 2));
        System.out.println(result);
        boolean result1 = board.move(bomber1.getCell(), new Cell(1, 2));
        System.out.println(result1);
        //System.out.println("BOMBER");
        //int direction = 1 + (int) (Math.random() * 4);
        //System.out.println(direction);
        /*
        ReentrantLock lock = new ReentrantLock();
        BomberMan bomber = new BomberMan(new Cell(5, 5), "bomber");
        Thread board = new Thread(new BoardLock(lock, bomber));
        board.start();
        System.out.println((lock.isLocked()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((lock.isLocked()));
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        //System.out.println(Thread.holdsLock(bomber));

        /*
        Cell cell = new Cell(1, 2);
        System.out.println(cell);
        BomberMan bomber = new BomberMan(new Cell(4, 6), "bomber");
        System.out.println(bomber);
        bomber.moveDown();
        System.out.println(bomber);
        */
    }

}