package com.adidyk;

public class StartUi {

    public static void main(String[] args) {

        //Figure bishop = new Bishop("black", new Cell(3,3));
        Board board = new Board();
        board.addFigure(new Bishop("black", new Cell(5, 4)));
        board.addFigure(new Bishop("black", new Cell(3, 4)));
        board.addFigure(new Bishop("black", new Cell(2, 5)));
        board.addFigure(new Castle("black", new Cell(7, 3)));

        System.out.println("Start Bishop");
        Figure[] figure1 = board.getFigures();
        for (Figure fig : figure1) {
            if (fig != null) {
                System.out.println(fig.getClass().getSimpleName() +": " +fig.position.getPositionX() +" " +fig.position.getPositionY() );
            }
        }

        System.out.println("End Bishop");
        board.move(new Cell(5, 4), new Cell(8, 7));
        Figure[] figure2 = board.getFigures();
        for (Figure fig : figure2) {
            if (fig != null) {
                System.out.println(fig.getClass().getSimpleName() +": " +fig.position.getPositionX() +" " +fig.position.getPositionY() );
            }
        }

        System.out.println("Move  castle");
        board.move(new Cell(7, 3), new Cell(7, 7));
        Figure[] figure3 = board.getFigures();
        for (Figure fig : figure3) {
            if (fig != null) {
                System.out.println(fig.getClass().getSimpleName() +": " +fig.position.getPositionX() +" " +fig.position.getPositionY() );
            }
        }






       // Pown pown = new Pown("black", new Cell(1, 2));
        //Bishop bishop1 = new Bishop("white", new Cell(5, 4));
        //Bishop bishop2 = new Bishop("white", new Cell(7, 8));
        //Cell dist = new Cell(7, 2);
        //Cell[] way = bishop1.way(dist);
        /*for (Cell cell : way) {
            if(cell != null) {
                System.out.println(cell.getAxisX() +" " +cell.getAxisY());
            }

        }*/
        //bishop2.way(dist);

        //System.out.println(bishop.getClass().getSimpleName() +": " +bishop.getColor() +" " +bishop.getCell().getLine() +" " +bishop.getCell().getColumn());
       // System.out.println(pown.getClass().getSimpleName() +": " +pown.getColor() +" " +pown.getCell().getLine() +" " +pown.getCell().getColumn());

      //  Board board = new Board();

        /*Cell cell = new Cell();
        cell.setCell(2,4);
        boolean[][]array = cell.getCell();
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }*/
    }


}
