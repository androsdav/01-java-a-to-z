package com.adidyk;

public abstract class Figure {

    String color;
    Cell position;

    Figure(String color, Cell position) {
        this.color = color;
        this.position = position;
    }

    public String getColor() {
            return this.color;
        }

    public Cell getCell() {
        return this.position;
    }




}
