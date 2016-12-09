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
    public void move(Cell source, Cell dist) throws ImposibleMoveException, FigureNotFoundException {
        boolean figureFound =false;
        for (Figure figure : this.figures) {
            if (figure != null) {
                if ((figure.position.getPositionX() == source.getPositionX()) && (figure.position.getPositionY() == source.getPositionY())) {
                    figureFound = true;
                    Cell[] highway = figure.way(dist);
                    boolean freeway = true;
                    for (Cell aHighway : highway) {
                        for (Figure figure1 : this.figures) {
                            if (figure1 != null) {
                                if (aHighway.getPositionX() == figure1.position.getPositionX() && aHighway.getPositionY() == figure1.position.getPositionY()) {
                                    freeway = false;
                                    break;
                                }
                            }
                        }
                        if (!freeway) break;
                    }
                    if (freeway) {
                        figure.clone(dist);
                    } else {

                    }
                    }
                    break;
                }
            }

        if (!figureFound) throw new FigureNotFoundException("Figure not found in whis cell");
        }

    }


    /*    boolean foundFigure = false;
        for (Figure figure : this.figures) {
            if ((figure.position.getPositionX() == source.getPositionX()) && (figure.position.getPositionY() == source.getPositionY())) {
                foundFigure = true;
                break;
            }
        }
        if (foundFigure) {

            Cell[] highway = figure.way(dist);

        } else {
            throw new FigureNotFoundException("Cell doesn`t contain any figure");
        }
    }*/

/*    public void move(Cell source, Cell dist) throws ImposibleMoveException, FigureNotFoundException {
          for (Figure figure : this.figures) {
            if (figure != null) {
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
                }
            }
        }
    }*/

}
