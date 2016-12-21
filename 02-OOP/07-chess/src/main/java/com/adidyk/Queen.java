package com.adidyk;

public class Queen extends Figure{

    // Constructor
    public Queen(String color, Cell cell) {
        super(color, cell);
    }

    // way - will return all way, if way = true
    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        Cell[] resultTemp = {new Cell(1, 1)};

        return resultTemp;

    }
}
