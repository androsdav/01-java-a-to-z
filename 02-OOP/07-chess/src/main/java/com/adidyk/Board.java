package com.adidyk;

public class Board {

    public Figure[] figures = new Figure[32];

    public Figure addFigure(Figure figure) {
        for(int index = 0; index < this.figures.length; index++) {
            if(this.figures[index] == null) {
                this.figures[index] = figure;
            }
        }
        return figure;
    }

    public void removeFigure(Figure figure) {
        for(int index = 0; index < this.figures.length; index++) {
            if(this.figures[index] != null && this.figures[index].position.getPositionX() == figure.position.getPositionX() ) {
                this.figures[index] = null;
                break;
            }
        }
    }


    public void move(Cell source, Cell dist) {
        for(int index = 0; index < figures.length; index++) {
            if((figures[index].getCell().getPositionX() == source.getPositionX() && figures[index].getCell().getPositionY() == source.getPositionY())) {
                Cell[] hightway = figures[index].way(Cell dist);
            } else {
                System.out.println("FigureNotFoundException");
            }


        }

    }
}
