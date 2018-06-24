package com.adidyk;

/**
 * Class Cell for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.05.2018.
 * @version 1.0.
 */
abstract class Heroes implements Creature {

    /**
     * @param cell - is link variable to object of class Cell.
     */
    Cell cell;

    /**
     *  @param name - is name bomber-man.
     */
    String name;

    /**
     * BomberMan - constructor.
     * @param cell - is start position of bomber-man (link variable).
     * @param name - is name bomber-man.
     */
    Heroes(Cell cell, String name) {
        this.cell = cell;
        this.name = name;
    }

    /**
     * @param dist - position.
     */
    public void clone(Cell dist) {
        this.cell = dist;
    }

    /**
     *  way - returns cell for each step.
     * @return - returns cell.
     */
    public abstract Cell way();


}
