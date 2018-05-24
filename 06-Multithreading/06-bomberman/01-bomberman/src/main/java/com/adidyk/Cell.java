package com.adidyk;

/**
 * Class Cell for create jar file and run program (Parallel Search).
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
     * @param positionY - position by X.
     */
    private int positionY;

    /**
     * Cell - constructor.
     * @param positionX - position X.
     * @param positionY - position Y.
     */
    Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * getPositionX - get.
     * @return returns get position X.
     */
    int getPositionX() {
        return this.positionX;
    }

    /**
     * setPositionY - sets.
     * @return returns get position Y.
     */
    int getPositionY() {
        return this.positionY;
    }

    /**
     *
     * @param obj - is.
     * @return - is.
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
        return positionX == cell.positionX && positionY == cell.positionY;
    }

    /**
     *
     * @return - is.
     */
    @Override
    public int hashCode() {
        int result = this.positionX;
        result = 31 * result + this.positionY;
        return result;
    }

    /**
     *
     * @return returns toString.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s", "Cell{", "positionX=", this.positionX, ", positionY=", this.positionY, "}");
    }
}