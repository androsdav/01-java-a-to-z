package com.adidyk;

public class StartUi {

    public static void main(String[] args) {
        Pown pown = new Pown("black", 2, 2);
        Bishop bishop = new Bishop("white", 3, 3);
        //String color1 =  bishop.getColor();
        System.out.println(bishop.getColor() +" " +bishop.getLine() +" " +bishop.getColumn());
        System.out.println(pown.getColor() +" " +pown.getPosY() +" " +pown.getPosY());

        Cell cell = new Cell();
        cell.setCell(2,4);
        boolean[][]array = cell.getCell();
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
