package com.adidyk;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class ThreadPool create thread pool for move monsters.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
class ThreadPool {

    /**
     * @param quantity - number of monster.
     */
    private int quantity;

    /**
     * @param monsters - list contains thread-move all of monster (MonsterMove).
     */
    private ArrayList<MonsterMove> monsters;

    /**
     * @param board - is link variable to object of class Board.
     */
    private Board board;

    /**
     * @param executor - is link variable to object of class ExecutorService.
     */
    private ExecutorService executor;

    /**
     * ThreadPool - constructor.
     * @param board - is link variable to object of class Board.
     * @param quantity - number of monster.
     */
    ThreadPool(Board board, int quantity) {
        this.quantity = quantity;
        this.board = board;
        this.init();
    }

    /**
     * init - initialisation "this.monster" and "this.executor' by number of monster.
     */
    private void init() {
        this.monsters = new ArrayList<>(this.quantity);
        this.executor = Executors.newFixedThreadPool(this.quantity);
    }

    /**
     * add - adds monster to game.
     * @param monster - is link variable to object of class Monster.
     */
    void add(Monster monster) {
        if (this.monsters.size() < this.quantity) {
            this.monsters.add(new MonsterMove(this.board, monster));
        }
    }

    /**
     * start - starts thread pool -> all monster start moving.
     */
    void start() {
        for (Runnable monster : this.monsters) {
            this.executor.execute(monster);
        }
    }

    /**
     * shutdown - finish thread pool -> all monsters finish moving.
     */
    void shutdown() {
        for (MonsterMove monster : this.monsters) {
            monster.shutdown();
        }
        this.executor.shutdown();
    }

}