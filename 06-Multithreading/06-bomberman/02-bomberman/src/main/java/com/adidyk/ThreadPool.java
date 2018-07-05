package com.adidyk;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class Monster create thread for move monster.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
class ThreadPool {

    /**
     * @param quantity - is.
     */
    private int quantity;

    /**
     * @param monsters - is.
     */
    private ArrayList<MonsterMove> monsters;

    /**
     * @param board - is.
     */
    private Board board;

    /**
     * @param executor - is.
     */
    private ExecutorService executor;

    /**
     * ThreadPool.
     * @param board - is board.
     * @param quantity - is.
     */
    ThreadPool(Board board, int quantity) {
        this.quantity = quantity;
        this.board = board;
        this.init();
    }

    /**
     *
     */
    private void init() {
        this.monsters = new ArrayList<>(this.quantity);
        this.executor = Executors.newFixedThreadPool(this.quantity);
    }

    /**
     * add - is.
     * @param monster - is.
     */
    void add(Monster monster) {
        if (this.monsters.size() < this.quantity) {
            this.monsters.add(new MonsterMove(this.board, monster));
        }
    }

    /**
     * start - is start.
     */
    void start() {
        for (MonsterMove monster : this.monsters) {
            this.executor.execute(monster);
        }
    }

    /**
     *
     */
    void shutdown() {
        for (MonsterMove monster : this.monsters) {
            monster.shutdown();
        }
        this.executor.shutdown();
    }

}