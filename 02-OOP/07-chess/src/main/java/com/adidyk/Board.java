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
            if(this.figures[index] != null && this.figures[index].getCell().getPositionX() == figure.getCell().getPositionX() ) {
                this.figures[index] = null;
                break;
            }
        }
    }


    public void move(Cell source, Cell dist) {

        for(int index = 0; index < figures.length; index++) {

        }

    }
}
