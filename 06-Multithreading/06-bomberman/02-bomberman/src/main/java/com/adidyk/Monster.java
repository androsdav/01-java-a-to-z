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
    private String direction = null;

    /**
     * BomberMan - constructor.
     * @param cell - is start position of hero (link variable).
     * @param name - is name hero.
     */
    Monster(Cell cell, String name) {
        super(cell, name);
        this.setDirection();
    }

    /**
     * direct - direct.
     */
    private void setDirection() {
        int direction = 1 + (int) (Math.random() * 2);
        if (direction == VERTICAL) {
            this.direction = "vertical";
        } else if (direction == HORIZONTAL) {
            this.direction = "horizontal";
        }
    }

    /**
     *
     */
    public String getDirection() {
        return this.direction;
    }

    /**
     *
     */
    public void vertical() {

    }

    /**
     * up - is.
     * @return - is.
     */
    public Cell up() {
        return new Cell(cell().getPositionX() - STEP, cell().getPositionY());
    }

    /**
     * right - is.
     * @return - is.
     */
    public Cell right() {
        return new Cell(cell().getPositionX(), cell().getPositionY() + STEP);
    }

    /**
     * down - is.
     * @return - is.
     */
    public Cell down() {
        return new Cell(cell().getPositionX() + STEP, cell().getPositionY());
    }

    /**
     * left - is.
     * @return - is.
     */
    public Cell left() {
        return new Cell(cell().getPositionX(), cell().getPositionY() - STEP);
    }

    /*

     */
    public void horizontal() {

    }

    @Override
    public Cell way() {
        if (this.direction.equals("vertical")) {
            higWay = new Cell(cell().getPositionX() - STEP, cell().getPositionY());
            direct = "up";
        } else if ("horizontal".equals(this.direction)) {
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
    */
        return null;

    }
}