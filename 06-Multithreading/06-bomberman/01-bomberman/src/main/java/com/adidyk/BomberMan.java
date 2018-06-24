package com.adidyk;

import static com.adidyk.Constant.*;

/**
 * Class BomberMan for create bomber-man (object) with params: cell, name.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.05.2018.
 * @version 1.0.
 */
public class BomberMan extends Heroes {

    /**
     * BomberMan - constructor.
     * @param cell - is start position of bomber-man (link variable).
     * @param name - is name bomber-man.
     */
    BomberMan(Cell cell, String name) {
        super(cell, name);
    }

    /**
     * way - randomly selects direction of travel (up, right, down, left) and
     * returns new cell for bomber-man.
     * @return - returns new cell for bomber-man.
     */
    @Override
    public Cell way() {
        Cell higWay = null;
        String direct = null;
        int direction = 1 + (int) (Math.random() * 4);
        if (direction == UP) {
            higWay = new Cell(cell().getPositionX(), cell().getPositionY() + STEP);
            direct = "UP";
        } else if (direction == RIGHT) {
            higWay = new Cell(cell().getPositionX() + STEP, cell().getPositionY());
            direct = "RIGHT";
        } else if (direction == DOWN) {
            higWay = new Cell(cell().getPositionX(), cell().getPositionY() - STEP);
            direct = "DOWN";
        } else if (direction == LEFT) {
            higWay = new Cell(cell().getPositionX() - STEP, cell().getPositionY());
            direct = "LEFT";
        }
        System.out.println("[info]: direction: " + direct);
        return higWay;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for cell.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s", "BomberMan{", "name=", name(), ", ", cell());
    }

}