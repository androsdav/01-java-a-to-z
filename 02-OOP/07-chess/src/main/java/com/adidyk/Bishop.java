package com.adidyk;

import static java.lang.Math.abs;

public class Bishop extends Figure {

    public Bishop(String color, Cell cell) {
        super(color, cell);
    }

    @Override

    public Cell[] way(Cell dist) {
        int startX = getCell().getAxisX();
        int startY = getCell().getAxisY();
        int endX = dist.getAxisX();
        int endY = dist.getAxisY();
        Cell[] way = new Cell[abs(endX - startX) + 1];
        int mark = 1;

        if (abs((endX - startX)) == abs(endY - startY)  && (endX - startX != 0)) {
            System.out.println("Move go ++");
            if (endX < startX) { mark = -1;}
            System.out.println("++");
            for (int index = 0; index < way.length; index++) {
                int indexX = startX + index * mark;
                int indexY = (indexX - startX)*(endY - startY)/(endX - startX) + startY;
                way[index] = new Cell(indexX, indexY);
            }
        } else {
            System.out.println("Imposible Move Exception");
        }
        return way;
    }
}
