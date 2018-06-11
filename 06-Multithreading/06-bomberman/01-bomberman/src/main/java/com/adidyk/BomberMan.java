package com.adidyk;

/**
 * Class Cell for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.05.2018.
 * @version 1.0.
 */
public class BomberMan {

    /**
     * @param cell - is.
     */
    private Cell cell;

    /**
     *  @param name - is name of hero.
     */
    private final String name;

    /**
     * @param step - step.
     */
    private final int step = 1;

    /**
     * BomberMan - constructor.
     * @param cell - is.
     * @param name - is.
     */
    BomberMan(Cell cell, String name) {
        this.cell = cell;
        this.name = name;
    }

    /**
     * moveUp - is.
     */
    void moveUp() {
        this.cell = new Cell(this.cell.getPositionX(), this.cell.getPositionY() + this.step);
    }

    /**
     * moveUp - is.
     */
    void moveDown() {
        this.cell = new Cell(this.cell.getPositionX(), this.cell.getPositionY() - this.step);
    }

    /**
     * moveRight - is.
     */
    void moveRight() {
        this.cell = new Cell(this.cell.getPositionX() + step, this.cell.getPositionY());
    }

    /**
     * moveLeft - is.
     */
    void moveLeft() {
        this.cell = new Cell(this.cell.getPositionX() - step, this.cell.getPositionY());
    }

    /**
     * getCell - get cell.
     * @return return ce..
     */
    Cell getCell() {
        return this.cell;
    }

    /**
     *
     * @return - is.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s", "BomberMan{", "name='", this.name, ", ", this.cell);
    }
}
