package com.adidyk;

public class Bishop extends Figure {

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

        if ((endX - startX) == (endY - startY)) {
            System.out.println("Move way");
        } else {
            System.out.println("Imposible Move Exception");
        }


        System.out.println(endX +" " +endY +" " +startX +" " +startY);

    }
}
