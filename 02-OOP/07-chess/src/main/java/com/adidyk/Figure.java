package com.adidyk;

import static java.lang.Math.abs;

public abstract class Figure {

    public String color;
    public Cell position;

    Figure(String color, Cell position) {
        this.color = color;
        this.position = position;
    }
    // temp method
    //public String getColor() {
    //        return this.color;
    //    }
    // temp method
    //public Cell getCell() {
    //    return this.position;
    // }

    public Cell[] way(Cell dist) {
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
            for (int index = 1; index < highway.length; index++) {
                int indexX = startX + sign * index;
                int indexY = (indexX - startX)*(endY - startY)/(endX - startX) + startY;
                highway[index] = new Cell(indexX, indexY);
            }
        } else {
            System.out.println("Imposible Move Exception");
        }
        return highway;
    }

    public void clone(Cell dist) {
        this.position = dist;

    }

}
