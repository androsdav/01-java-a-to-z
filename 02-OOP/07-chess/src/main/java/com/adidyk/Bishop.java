package com.adidyk;

import static java.lang.Math.abs;

public class Bishop extends Figure {

    public Bishop(Cell cell) {
        super(cell);
    }

    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int startX = this.position.getPositionX();
        int startY = this.position.getPositionY();
        int endX = dist.getPositionX();
        int endY = dist.getPositionY();
        Cell[] highway = new Cell[abs(endX - startX)];
        int sign = 1;
        if ((abs(endX - startX) == abs(endY - startY))  && ((endX - startX) != 0) && ((endY - startY) != 0)) {
            if (endX < startX) {
                sign = -1;
            }
            for (int index = 1; index <= highway.length; index++) {
                int indexX = startX + sign * index;
                int indexY = (indexX - startX)*(endY - startY)/(endX - startX) + startY;
                highway[index - 1] = new Cell(indexX, indexY);
            }
        }
        else {
            throw new ImposibleMoveException("Bishop can`t move to this cell");
        }
        return highway;
    }



}
