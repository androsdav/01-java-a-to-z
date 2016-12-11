package com.adidyk;

public abstract class Figure {

    public String color;
    public Cell position;

    // Constructor
    Figure(String color, Cell position) {
        this.color = color;
        this.position = position;
    }

    // way - will return way, if way = true
    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;

    // clone - set new cell
    public void clone(Cell dist) {
        this.position = dist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Figure figure = (Figure) o;

        if (color != null ? !color.equals(figure.color) : figure.color != null) return false;
        return position != null ? position.equals(figure.position) : figure.position == null;

    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
