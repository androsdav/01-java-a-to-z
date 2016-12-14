package com.adidyk;

public class Knight extends Figure {

    // Constructor
    public Knight(String color, Cell cell) {
        super(color, cell);
    }

    // way - will return all way, if way =true
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int startX = this.position.getPositionX();
        int startY = this.position.getPositionY();
        int endX = dist.getPositionX();
        int endY = dist.getPositionY();
        Cell[] highway = new Cell[1];
        int cathetusH = 1;
        int cathetusL = 2;
        if ( ((endX - startX) == cathetusH || (endY - startY) == cathetusL) && ((endX - startX) == cathetusL || (endY - startY) == cathetusH)  ) {
            highway[0] = new Cell(endX, endY);
        } else {
            throw new ImposibleMoveException("Knight can`t move to this cell");
        }
        return highway;
    }

}

