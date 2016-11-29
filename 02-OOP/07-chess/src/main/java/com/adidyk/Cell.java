package com.adidyk;

public class Cell {
    public boolean [][] cell = new boolean[8][8];

    public void setCell(int line, int column) {
        this.cell[line][column] = true;
    }

    public boolean[][] getCell(){
        return this.cell;
    }

}
