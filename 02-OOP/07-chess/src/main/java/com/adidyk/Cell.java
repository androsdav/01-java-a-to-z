package com.adidyk;

public class Cell {

    private int positionX;
    private int positionY;

    public Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX(){
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return positionX == cell.positionX && positionY == cell.positionY;

    }

    @Override
    public int hashCode() {
        int result = positionX;
        result = 31 * result + positionY;
        return result;
    }

}
