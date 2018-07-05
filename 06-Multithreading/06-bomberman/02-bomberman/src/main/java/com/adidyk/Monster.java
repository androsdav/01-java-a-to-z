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
     * @param name - is name hero (monster).
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
     * way - returns new cell for monster by vertical if direction - vertical, or returns new cell
     * for monster by horizontal if direction - horizontal.
     * Direction vertical   -> move up and move down.
     * Direction horizontal -> move right and move left.
     * @return - returns new cell for monster.
     */
    @Override
    public Cell way() {
        Cell highWay = null;
        if (this.direction == VERTICAL) {
            highWay = new Cell(cell().getPositionX() + this.step, cell().getPositionY());
        } else if (this.direction == HORIZONTAL) {
            highWay = new Cell(cell().getPositionX(), cell().getPositionY() + this.step);
        }
        return highWay;
    }

    /**
     * setStep - changes direction of move if next cell is locked.
     */
    void setStep() {
        this.step = this.step * FORWARD;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for monster.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s", name(), ": {", cell(), "}");
    }


}