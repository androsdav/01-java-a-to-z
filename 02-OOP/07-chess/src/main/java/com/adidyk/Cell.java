package com.adidyk;

public class Cell {
    private int line;
    private int column;

    public Cell(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getLine(){
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

}
