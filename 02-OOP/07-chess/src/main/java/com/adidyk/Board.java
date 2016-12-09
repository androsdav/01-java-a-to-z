package com.adidyk;

public class Board {

    public Figure[] figures = new Figure[32];

    public Figure addFigure(Figure figure) {
        for (int index = 0; index < this.figures.length; index++) {
            if (this.figures[index] == null) {
                this.figures[index] = figure;
                break;
            }
        }
        return figure;
    }

    public Figure[] getFigures() {
        return this.figures;
    }

    public void move(Cell source, Cell dist) throws ImposibleMoveException {
        for (Figure figure : this.figures) {
            if ((figure.position.getPositionX() == source.getPositionX()) && (figure.position.getPositionY() == source.getPositionY())) {
                Cell[] highway = figure.way(dist);
                boolean freeway = true;
                for (Cell aHighway : highway) {
                    for (Figure figure1 : this.figures) {
                        if (figure1 != null) {
                            if (aHighway.getPositionX() == figure1.position.getPositionX() && aHighway.getPositionY() == figure1.position.getPositionY()) {
                                freeway = false;
                                System.out.println("OccupiedWayException");
                                break;
                            }
                        }
                    }
                }
                if (freeway) {
                    figure.clone(dist);
                }
                break;
            } else {
                throw new FigureNotFoundException("saaaaaa");
            }
        }
    }

}
