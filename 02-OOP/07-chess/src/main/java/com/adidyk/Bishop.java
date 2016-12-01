package com.adidyk;

public class Bishop extends Figure {

    final public int SIZE = 9;

    public Bishop(String color, Cell cell) {
        super(color, cell);
    }

    @Override
    // Cell[]
    public void way(Cell dist) {
        int startX = getCell().getAxisX();
        int startY = getCell().getAxisY();
        int endX = dist.getAxisX();
        int endY = dist.getAxisY();

        if(endX < SIZE && endY < SIZE) {
            if ((endX - startY) == (endY - startY)) {

            } else {
                System.out.println("Imposible Move Exception");
            }
        } else {
            System.out.println("End position Isn`t correct end of position");
        }


        System.out.println(endX +" " +endY +" " +startX +" " +startY);

    }
}
