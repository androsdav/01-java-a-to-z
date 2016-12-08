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

}
