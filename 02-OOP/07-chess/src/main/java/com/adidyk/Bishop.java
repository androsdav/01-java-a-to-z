package com.adidyk;

import static java.lang.Math.abs;

public class Bishop extends Figure {

    public Bishop(String color, Cell cell) {
        super(color, cell);
    }

    @Override
    public Cell[] way(Cell dist) {
        int startX = getCell().getPositionX();
        int startY = getCell().getPositionY();
        int endX = dist.getPositionX();
        int endY = dist.getPositionY();
        Cell[] highway = new Cell[abs(endX - startX) + 1];
        int sign = 1;
        if ((abs(endX - startX) == abs(endY - startY))  && ((endX - startX) != 0) && ((endY - startY) != 0)) {
            if (endX < startX) {
                sign = -1;
            }
            for (int index = 0; index < highway.length; index++) {
                int indexX = startX + sign * index;
                int indexY = (indexX - startX)*(endY - startY)/(endX - startX) + startY;
                highway[index] = new Cell(indexX, indexY);
            }
        } else {
            System.out.println("Imposible Move Exception");
        }
        return highway;
    }
}
