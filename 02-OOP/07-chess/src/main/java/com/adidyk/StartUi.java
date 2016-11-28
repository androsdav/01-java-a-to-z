package com.adidyk;

public class StartUi {

    public static void main(String[] args) {
        //Pown pown = new Pown("pown", "white", 4, 2);
        String color = "white";
        Bishop bishop = new Bishop(color, 2, 7);
        //String color1 =  bishop.getColor();
        System.out.println(bishop.getColor() +" " +bishop.getPosX() +" " +bishop.getPosY());
    }
}
