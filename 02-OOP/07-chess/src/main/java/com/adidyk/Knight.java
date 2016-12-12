package com.adidyk;

public class Knight extends Figure {

    // Constructor
    public Knight(String color, Cell cell) {
        super(color, cell);
    }

    // way - will return all way, if way =true
    public Cell[] way(Cell dist) throws ImposibleMoveException {

        Cell[] highway = {new Cell(1, 1)}; // temp highway
        int startX = this.position.getPositionX();
        int startY = this.position.getPositionY();
        int endX = dist.getPositionX();
        int endY = dist.getPositionY();


        return highway;

    }




}

