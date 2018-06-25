package com.adidyk;

import static com.adidyk.Constant.*;
import static com.adidyk.Constant.LEFT;
import static com.adidyk.Constant.STEP;

/**
 * Class BomberMan for create bomber-man (object) with params: cell, name.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 25.06.2018.
 * @version 1.0.
 */
public class Monster extends Heroes {

    /**
     * BomberMan - constructor.
     * @param cell - is start position of hero (link variable).
     * @param name - is name hero.
     */
    Monster(Cell cell, String name) {
        super(cell, name);
    }

    @Override
    public Cell way() {
        int direction = 1 + (int) (Math.random() * 4);
        if (direction == UP) {
            higWay = new Cell(cell().getPositionX() - STEP, cell().getPositionY());
            direct = "up";
        } else if (direction == RIGHT) {
            higWay = new Cell(cell().getPositionX(), cell().getPositionY() + STEP);
            direct = "right";
        } else if (direction == DOWN) {
            higWay = new Cell(cell().getPositionX() + STEP, cell().getPositionY());
            direct = "down";
        } else if (direction == LEFT) {
            higWay = new Cell(cell().getPositionX(), cell().getPositionY() - STEP);
            direct = "left";
        }
        System.out.println(" [info]: direction: " + direct);
        return null;
    }

    /*
    private void moveLine() {

    }
    */
}
