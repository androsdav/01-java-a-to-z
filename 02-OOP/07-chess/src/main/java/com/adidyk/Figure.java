package com.adidyk;

public abstract class Figure {

    //public String color;
    public Cell position;

    Figure(Cell position) {
      //  this.color = color;
        this.position = position;
    }

    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;

    public void clone(Cell dist) {
        this.position = dist;
    }

}
