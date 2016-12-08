package com.adidyk;

public class Board {

    public Figure[] figures = new Figure[32];

    public Figure addFigure(Figure figure) {
        for (int index = 0; index < this.figures.length; index++) {
            if (this.figures[index] == null) {
                this.figures[index] = figure;
            }
        }
        return figure;
    }

    public Figure[] getFigures() {
        return this.figures;
    }

    /* public void removeFigure(Figure figure) {
        for(int index = 0; index < this.figures.length; index++) {
            if(this.figures[index] != null && this.figures[index].position.getPositionX() == figure.position.getPositionX() ) {
                this.figures[index] = null;
                break;
            }
        }
    }*/

    public void move(Cell source, Cell dist) {

        for (Figure figure : this.figures) {
            if (figure.position.getPositionX() == source.getPositionX() && figure.position.getPositionY() == source.getPositionY()) {
                Cell[] highway = figure.way(dist);
                boolean freeway = true;
                for (Cell aHighway : highway) {
                    for (Figure figure1 : this.figures) {
                        if (aHighway.getPositionX() == figure1.position.getPositionX() && aHighway.getPositionY() == figure1.position.getPositionY()) {
                            freeway = false;
                            System.out.println("OccupiedWayException");
                            break;
                        }
                    }
                }
                if (freeway) {
                    figure.clone(dist);
                }
                break;
            }
        }
    }

}
