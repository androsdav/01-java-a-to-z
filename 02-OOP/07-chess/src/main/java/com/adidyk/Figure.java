package com.adidyk;

public abstract class Figure {

    public String color;
    final Cell position;

    Figure(String color, Cell position) {
        this.color = color;
        this.position = position;
    }
    // temp method
    public String getColor() {
            return this.color;
        }
    // temp method
    public Cell getCell() {
        return this.position;
    }

    abstract public void way(Cell dist);

}
