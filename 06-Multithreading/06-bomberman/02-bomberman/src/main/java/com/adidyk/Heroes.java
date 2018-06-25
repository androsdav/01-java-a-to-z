package com.adidyk;

/**
 * Class Heroes is abstract class.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.05.2018.
 * @version 1.0.
 */
public abstract class Heroes {

    /**
     * @param cell - is link variable to object of class Cell.
     */
    private Cell cell;

    /**
     *  @param name - is name hero.
     */
    private String name;

    /**
     * BomberMan - constructor.
     * @param cell - is start position of hero (link variable).
     * @param name - is name hero.
     */
    Heroes(Cell cell, String name) {
        this.cell = cell;
        this.name = name;
    }

    /**
     * clone - sets new cell for hero.
     * @param dist - position.
     */
    void clone(Cell dist) {
        this.cell = dist;
    }

    /**
     *  way - returns new cell for each step for hero.
     * @return - returns new cell for each step for hero.
     */
    public abstract Cell way();

    /**
     * cell - returns cell for hero.
     * @return - returns cell for hero.
     */
    Cell cell() {
        return this.cell;
    }

    /**
     * name - returns name for hero.
     * @return - returns name for hero.
     */
    String name() {
        return this.name;
    }

    /**
     * equals - returns boolean result.
     * @param obj - object of class Heroes.
     * @return - returns boolean result "true" if name and cell of hero is same, and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Heroes)) {
            return false;
        }
        Heroes hero = (Heroes) obj;
        return this.cell.equals(hero.cell) && this.name.equals(hero.name);
    }

    /**
     * hashCode - returns hashCode for hero.
     * @return - returns hashCode for hero.
     */
    @Override
    public int hashCode() {
        int result = this.cell.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }

}