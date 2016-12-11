package com.adidyk;

public class Board {

    public Figure[] figures = new Figure[32];

    // addFigure - add new figure in []figures
    public Figure addFigure(Figure figure) {
        for (int index = 0; index < this.figures.length; index++) {
            if (this.figures[index] == null) {
                this.figures[index] = figure;
                break;
            }
        }
        return figure;
    }

    // getFigure - return all []figure
    public Figure[] getFigures() {
        return this.figures;
    }

    // move - found figure in source cell, inspection true way and move figure in a dist cell
    public void move(Cell source, Cell dist) throws ImposibleMoveException, FigureNotFoundException, OccupiedWayException {
        boolean figureFound = false;
        for (Figure figure : this.figures) {
            if (figure != null) {
                if (figure.position.equals(source)) {
                    figureFound = true;
                    Cell[] highway = figure.way(dist);
                    boolean freeway = true;
                    for (Cell aHighway : highway) {
                        for (Figure chessman : this.figures) {
                            if (chessman != null) {
                                if (aHighway.equals(chessman.position)) {
                                    freeway = false;
                                    break;
                                }
                            }
                        }
                        if (!freeway) break;
                    }
                    if (!freeway) {
                        throw new OccupiedWayException("Way occupied");
                    } else {
                        figure.clone(dist);
                    }
                }
            }
            if (figureFound) break;
        }
        if (!figureFound) throw new FigureNotFoundException("Figure not found in this cell");
    }

}



