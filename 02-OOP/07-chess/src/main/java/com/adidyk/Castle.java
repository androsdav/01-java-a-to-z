package com.adidyk;

import static java.lang.Math.abs;

public class Castle extends Figure {

    // Constructor
    public Castle(String color, Cell cell) {
        super(color, cell);
    }

    // way - will return all way, if way = true
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
                int indexY = startY + sign*index;
                highway[index - 1] = new Cell(startX, indexY);
            }
        } else if (endY == startY) {
            for (int index = 1; index <= highway.length; index++) {
                int indexX = startX + sign * index;
                highway[index - 1] = new Cell(indexX, startY);
                }
            } else {
            throw new ImposibleMoveException("Castle can`t move to this cell");
        }
        return highway;
    }

}

