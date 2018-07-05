package com.adidyk;

//import java.util.concurrent.Executor;
//import java.util.ArrayList;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.ThreadPoolExecutor;

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
        Board board = new Board(9, 7);
        Block rock1 = new Block(new Cell(1, 4), "rock1");
        Block rock2 = new Block(new Cell(7, 4), "rock2");
        Block rock3 = new Block(new Cell(4, 1), "rock3");
        Block rock4 = new Block(new Cell(4, 6), "rock4");
        board.lockCell(rock1.cell());
        board.lockCell(rock2.cell());
        board.lockCell(rock3.cell());
        board.lockCell(rock4.cell());
        ThreadPool threadPool = new ThreadPool(board, 2);
        threadPool.add(new Monster(new Cell(4, 4), "monster1"));
        threadPool.add(new Monster(new Cell(5, 5), "monster2"));
        threadPool.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
        //Monster monster1 = new Monster(new Cell(4, 4), "monster1");
        //MonsterMove monsterMove1 = new MonsterMove(board, monster1);
        //Monster monster2 = new Monster(new Cell(5, 5), "monster2");
        //MonsterMove monsterMove2 = new MonsterMove(board, monster2);
        //monsterMove1.start();
        //monsterMove2.start();
        //try {
        //    Thread.sleep(30000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //monsterMove1.finish();
        //
        //
        /*
        ArrayList<MonsterMove> list = new ArrayList<>();
        list.add(new MonsterMove(board, new Monster(new Cell(1, 1), "monster1")));
        list.add(new MonsterMove(board, new Monster(new Cell(2, 2), "monster2")));
        list.add(new MonsterMove(board, new Monster(new Cell(3, 3), "monster3")));
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (MonsterMove item : list) {
            executor.execute(item);
        }
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (MonsterMove item : list) {
            item.finish();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdownNow();
        */
        //
        //
        //
        /*
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
        */
        /*
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");*/
        //}
    }

}