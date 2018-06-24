package com.adidyk;

/**
 * Interface Creature for create different unit.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.06.2018.
 * @version 1.0.
 */
public interface Creature {

    /**
     * clone - assign new cell position for creature.
     * @param dist - new cell position.
     */
    void clone(Cell dist);

    /**
     * way - returns cell for each step.
     * @return - returns cell.
     */
    Cell way();

}