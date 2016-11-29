package com.adidyk;

public class Bishop extends Figure {

    private String color;
    private int line;
    private int column;

    public Bishop(String color, int line,int column) {
        this.color = color;
        this.line = line;
        this.line = column;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLine(int posX) {
        this.line = posX;
    }

    public void setColumn(int posY) {
        this.column = posY;
    }

    public String getColor() {
        return this.color;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

}
