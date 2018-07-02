package com.adidyk;

import static com.adidyk.Constant.*;

/**
 * Class BomberMan for create bomber-man (object) with params: cell, name.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 25.06.2018.
 * @version 1.0.
 */
public class Monster extends Heroes {
    /**
     * @param direction - is direction.
     */
    private int direction;

    /**
     * @param step - is step.
     */
    private int step;

    /**
     * BomberMan - constructor.
     * @param cell - is start position of hero (link variable).
     * @param name - is name hero.
     */
    Monster(Cell cell, String name) {
        super(cell, name);
        this.step = FORWARD;
        this.setDirection();
    }

    /**
     * direct - direct.
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
     * way - randomly selects direction of travel (up, right, down, left) and
     * returns new cell for bomber-man.
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