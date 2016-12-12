package com.adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void addFigureTest() {
        Figure bishop1 = new Bishop("black", new Cell(1, 1));
        Board board = new Board();
        Figure bishop2 = new Bishop("black", new Cell(1, 1));
        board.addFigure(bishop2);
        Figure result = board.addFigure(bishop2);
        assertThat(result, is(bishop1));
    }

    @Test
    public void getFigureTest() {
        Figure bishop1 = new Bishop("black", new Cell(1, 1));
        Figure bishop2 = new Bishop("black", new Cell(2, 2));
        Figure bishop3 = new Bishop("black", new Cell(3, 3));
        Figure[] figures = {bishop1, bishop2, bishop3};
        Board board = new Board();
        Figure bishop4 = new Bishop("black", new Cell(1, 1));
        Figure bishop5 = new Bishop("black", new Cell(2, 2));
        Figure bishop6 = new Bishop("black", new Cell(3, 3));
        board.addFigure(bishop4);
        board.addFigure(bishop5);
        board.addFigure(bishop6);
        Figure[] result = this.getAllIFigureWithoutNull(board.getFigure());
        assertThat(result, is(figures));
    }

    @Test
    public void moveTest() {
        Figure bishop1 = new Bishop("black", new Cell(5, 4));
        Figure bishop2 = new Bishop("black", new Cell(7, 5));
        Figure castle1 = new Castle("white", new Cell(3, 3));
        Figure bishop1Move = new Bishop("black", new Cell(2, 7));
        Figure[] figures = {bishop1Move, bishop2, castle1};
        Board board = new Board();
        board.addFigure(bishop1);
        board.addFigure(bishop2);
        board.addFigure(castle1);
        board.move(new Cell(5, 4), new Cell(2, 7));
        Figure[] result = this.getAllIFigureWithoutNull(board.getFigure());
        assertThat(result, is(figures));
    }

    // getAllFigureWithoutNull - method return all []figure without null
    private Figure[] getAllIFigureWithoutNull(Figure[] resultAll) {
        int length = 0;
        for (Figure figure : resultAll) {
            if (figure != null) {
                length++;
            }
        }
        Figure[] resultWithoutNull = new Figure[length];
        int index = 0;
        for (Figure figure : resultAll) {
            if (figure != null) {
                resultWithoutNull[index++] = figure;
            }
        }
        return resultWithoutNull;
    }

}
