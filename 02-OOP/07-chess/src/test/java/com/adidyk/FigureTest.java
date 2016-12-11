package com.adidyk;

public abstract class Figure {

    public String color;
    public Cell position;

    // Constructor
    Figure(String color, Cell position) {
        this.color = color;
        this.position = position;
    }

    // way - will return way, if way = true
    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;

    // clone - set new cell
    public void clone(Cell dist) {
        this.position = dist;
    }

}
