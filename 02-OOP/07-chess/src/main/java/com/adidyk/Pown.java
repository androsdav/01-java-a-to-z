package com.adidyk;

public class Pown {

    private String color;
    private int posX;
    private int posY;

    public Pown(String color, int posX, int posY) {
        this.color = color;
        this.posX = posX;
        this.posY = posY;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getColor() {
        return this.color;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

}
