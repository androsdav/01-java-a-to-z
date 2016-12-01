package com.adidyk;

public class Bishop extends Figure {

    public Bishop(String color, Cell cell) {
        super(color, cell);
    }

    @Override
    // Cell[]
    public void way(Cell dist) {
        int lineDist = dist.getLine();
        int columnDist = dist.getColumn();
        int lineCell = getCell().getLine();
        int columnCell = getCell().getColumn();

    }
}
