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
     * direction - is direction.
     * @return cell.
     */
    @Override
    public Cell way() {
        Cell higWay = null;
        int direction = 1 + (int) (Math.random() * 4);
        if (direction == UP) {
            higWay = new Cell(cell().getPositionX(), cell().getPositionY() + STEP);
        } else if (direction == RIGHT) {
            higWay = new Cell(cell().getPositionX() + STEP, cell().getPositionY());
        } else if (direction == DOWN) {
            higWay = new Cell(cell().getPositionX(), cell().getPositionY() - STEP);
        } else if (direction == LEFT) {
            higWay = new Cell(cell().getPositionX() - STEP, cell().getPositionY());
        }
        System.out.println("[info]: direction: " + direction);
        return higWay;
    }

    /**
     * getCell - get cell.
     * @return return cell.
     */
    Cell getCell() {
        return cell();
    }

    /**
     * toString -
     * @return - is.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s", "BomberMan{", "name='", name(), ", ", cell());
    }

}