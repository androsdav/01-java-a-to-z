package com.adidyk;

/**
 * Class Cell for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.05.2018.
 * @version 1.0.
 */
public class BomberMan {

    /**
     * @param UP - is up.
     */
    private static final int UP = 1;

    /**
     * @param RIGHT - is up.
     */
    private static final int RIGHT = 2;

    /**
     * @param DOWN - is up.
     */
    private static final int DOWN = 3;

    /**
     * @param LEFT - is up.
     */
    private static final int LEFT = 4;



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
     * direction - is direction.
     * @param number - is nuber.
     */
    void move(int number) {
        if (number == UP) {
            this.moveUp();
        } else if (number == RIGHT) {
            this.moveRight();
        } else if (number == DOWN) {
            this.moveDown();
        } else if (number == LEFT) {
            this.moveLeft();
        }
    }

    /**
     * moveUp - is.
     */
    private void moveUp() {
        this.cell = new Cell(this.cell.getPositionX(), this.cell.getPositionY() + this.step);
    }

    /**
     * moveUp - is.
     */
    private void moveDown() {
        this.cell = new Cell(this.cell.getPositionX(), this.cell.getPositionY() - this.step);
    }

    /**
     * moveRight - is.
     */
    private void moveRight() {
        this.cell = new Cell(this.cell.getPositionX() + step, this.cell.getPositionY());
    }

    /**
     * moveLeft - is.
     */
    private void moveLeft() {
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
