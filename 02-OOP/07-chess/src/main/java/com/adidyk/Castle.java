package com.adidyk;

import static java.lang.Math.abs;

public class Castle extends Figure {

    public Castle(Cell cell) {
        super(cell);
    }

    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int startX = this.position.getPositionX();
        int startY = this.position.getPositionY();
        int endX = dist.getPositionX();
        int endY = dist.getPositionY();
        Cell[] highway = new Cell[abs(endX - startX + endY - startY)];
        int sign = 1;
        if (startY > endY || startX > endX) {
            sign = -1;
        }
        if (endX == startX) {
            for (int index = 1; index <= highway.length; index++) {
                int indexX = startX;
                int indexY = startY + sign*index;
                highway[index - 1] = new Cell(indexX, indexY);
            }
        } else if (endY == startY) {
            for (int index = 1; index <= highway.length; index++) {
                int indexX = startX + sign * index;
                int indexY = startY;
                highway[index - 1] = new Cell(indexX, indexY);
                }
            } else {
            throw new ImposibleMoveException("Castle can`t move to this cell");
        }
        return highway;
    }

}

