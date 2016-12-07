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

/*    public void removeFigure(Figure figure) {
        for(int index = 0; index < this.figures.length; index++) {
            if(this.figures[index] != null && this.figures[index].position.getPositionX() == figure.position.getPositionX() ) {
                this.figures[index] = null;
                break;
            }
        }
    }*/

    public void move(Cell source, Cell dist) {
        //int pos = 0;
        for(int index = 0; index < this.figures.length; index++) {
            if(this.figures[index].position.getPositionX() == source.getPositionX() && this.figures[index].position.getPositionY() == source.getPositionY()) {

                Cell[] highway = figures[index].way(dist);
                boolean freeway = true;

                for(int counter = 0; counter < highway.length; counter++) {
                    for(int number = 0; number < this.figures.length; number++) {
                        if(highway[counter].getPositionX() == this.figures[number].position.getPositionX() && highway[counter].getPositionY() == this.figures[number].position.getPositionY()) {
                            freeway = false;
                            System.out.println("OccupiedWayException");
                            break;
                        }
                    }
                }
                if(freeway) {
                    figures[index].clone(dist);
                }
                break;
            }
        }
    }

}
