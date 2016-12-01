package com.adidyk;

public class Cell {
    private int axisX;
    private int axisY;

    public Cell(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }

    public int getLine(){
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

}
