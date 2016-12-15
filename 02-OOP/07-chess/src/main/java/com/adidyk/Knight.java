package com.adidyk;

import static java.lang.StrictMath.abs;

public class Knight extends Figure {

    // Constructor
    public Knight(String color, Cell cell) {
        super(color, cell);
    }

    // way - will return all way, if way =true
    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int startX = this.position.getPositionX();
        int startY = this.position.getPositionY();
        int endX = dist.getPositionX();
        int endY = dist.getPositionY();
        Cell[] highway = new Cell[1];
        int lineH = 1;
        int lineL = 2;
        if ((abs(endX - startX) == lineH && abs(endY - startY) == lineL) || (abs(endX - startX) == lineL && abs(endY - startY) == lineH)) {
            highway[0] = new Cell(endX, endY);
        } else {
            throw new ImposibleMoveException("Knight can`t move to this cell");
        }
        return highway;
    }

}

