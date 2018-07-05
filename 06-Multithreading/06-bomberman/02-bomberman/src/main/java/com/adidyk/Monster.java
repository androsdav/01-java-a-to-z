package com.adidyk;

import static com.adidyk.Constant.*;

/**
 * Class Monster for create monster (object) with params: cell, name.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 25.06.2018.
 * @version 1.0.
 */
public class Monster extends Heroes {
    /**
     * @param direction - is direction of move.
     */
    private int direction;

    /**
     * @param step - is step by one cell.
     */
    private int step;

    /**
     * Monster - constructor.
     * @param cell - is start position of monster (link variable).
     * @param name - is name hero.
     */
    Monster(Cell cell, String name) {
        super(cell, name);
        this.step = FORWARD;
        this.setDirection();
    }

    /**
     * setDirection - choice of direction of movement of monster by vertical or by horizontal.
     */
    private void setDirection() {
        int direction = 1 + (int) (Math.random() * 2);
        if (direction == VERTICAL) {
            this.direction = VERTICAL;
        } else if (direction == HORIZONTAL) {
            this.direction = HORIZONTAL;
        }
    }

    /**
     * way - returns new cell for monster by vertical or by horizontal.
     * Direction Vertical: monster move auto by down or by up.
     * Direction horizontal: monster move auto by right - left.
     * @return - returns new cell for bomber-man.
     */
    @Override
    public Cell way() {
        Cell highWay = null;
        if (this.direction == VERTICAL) {
            highWay = new Cell(cell().getPositionX() + this.step, cell().getPositionY()); // down - up
        } else if (this.direction == HORIZONTAL) {
            highWay = new Cell(cell().getPositionX(), cell().getPositionY() + this.step); // right - left
        }
        return highWay;
    }

    /**
     * setVector - is.
     */
    void setStep() {
        this.step = this.step * FORWARD;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for cell.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s", name(), ": {", cell(), "}");
    }


}