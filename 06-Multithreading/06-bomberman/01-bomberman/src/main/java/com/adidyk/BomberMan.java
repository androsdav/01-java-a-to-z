package com.adidyk;

import static com.adidyk.Constant.*;

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
     * BomberMan - constructor.
     * @param cell - is.
     * @param name - is.
     */
    BomberMan(Cell cell, String name) {
        this.cell = cell;
        this.name = name;
    }

    /**
     * @param dist - position.
     */
    void clone(Cell dist) {
        this.cell = dist;
    }

    /**
     * direction - is direction.
     * @return cell.
     */
    Cell way() {
        Cell higWay = null;
        int direction = 1 + (int) (Math.random() * 4);
        if (direction == UP) {
            higWay = this.moveUp();
        } else if (direction == RIGHT) {
            higWay = this.moveRight();
        } else if (direction == DOWN) {
            higWay = this.moveDown();
        } else if (direction == LEFT) {
            higWay = this.moveLeft();
        }
        System.out.println("[info]: direction: " + direction);
        return higWay;
    }

    /**
     * moveUp - is.
     * @return cell.
     */
    private Cell moveUp() {
        return new Cell(this.cell.getPositionX(), this.cell.getPositionY() + STEP);
    }

    /**
     * moveUp - is.
     * @return cell.
     */
    private Cell moveDown() {
        return new Cell(this.cell.getPositionX(), this.cell.getPositionY() - STEP);
    }

    /**
     * moveRight - is.
     * @return cell.
     */
    private Cell moveRight() {
        return new Cell(this.cell.getPositionX() + STEP, this.cell.getPositionY());
    }

    /**
     * moveLeft - is.
     * @return cell.
     */
    private Cell moveLeft() {
        return new Cell(this.cell.getPositionX() - STEP, this.cell.getPositionY());
    }

    /**
     * getCell - get cell.
     * @return return cell.
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
