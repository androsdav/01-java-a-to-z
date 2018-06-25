package com.adidyk;

/**
 * Class Cell for create cell (object) with params: positionX, positionY.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.05.2018.
 * @version 1.0.
 */
public class Cell {

    /**
     * @param positionX - position by X.
     */
    private int positionX;

    /**
     * @param positionY - position by Y.
     */
    private int positionY;

    /**
     * Cell - constructor.
     * @param positionX - position by X.
     * @param positionY - position by Y.
     */
    Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * getPositionX - returns position by X.
     * @return - returns position by X.
     */
    int getPositionX() {
        return this.positionX;
    }

    /**
     * getPositionY - returns position by Y.
     * @return - returns position by Y.
     */
    int getPositionY() {
        return this.positionY;
    }

    /**
     * equals - returns boolean result.
     * @param obj - object of class Cell.
     * @return - returns boolean result "true" if positionX and positionY is same, and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) obj;
        return this.positionX == cell.positionX && this.positionY == cell.positionY;
    }

    /**
     * hashCode - returns hashCode for cell.
     * @return - returns hashCode for cell.
     */
    @Override
    public int hashCode() {
        int result = this.positionX;
        result = 31 * result + this.positionY;
        return result;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for cell.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s", "positionX=", this.positionX, ", positionY=", this.positionY);
    }

}