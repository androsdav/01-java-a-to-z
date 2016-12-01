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

    public int getAxisX(){
        return this.axisX;
    }

    public int getAxisY() {
        return this.axisY;
    }

}
