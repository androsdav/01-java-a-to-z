package com.adidyk;

//import java.io.*

import java.io.*;

public class StartUi {

    public static void main(String[] args) throws IOException {

        System.out.println("");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "Cp866"));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "Cp866"), true);

        String s = br.readLine();
        System.out.println("Output s: " + s);






    }
//        int c = 0;
 //       pw.println((char)c);
        //String symbol = br.read((char)c);


      /*  import j ava.io.*;

        class PrWr{

            public static void main(String[] args){

                try{

                    BufferedReader br =

                            new BufferedReader(new InputstreamReader(System.in, "Cp866"));

                    PrintWriter pw = new PrintWriter(

                            new OutputstreamWriter(System.out, "Cp866"), true);

                    String s = "Это строка с русским текстом";

                    System.out.println("System.out puts: " + s);

                    pw.println("PrintWriter puts: " + s) ;

                    int с = 0;

                    pw.println("Посимвольный ввод:");

                    while((с = br.read()) != -1)

                        pw.println((char)c);

                    pw.println("Построчный ввод:");

                    do{

                        s = br.readLine();

                        pw.println(s);

                    }while(!s.equals("q"));

                }catch(Exception e){

                    System.out.println(e);

                }

            }

        }
        /*Board board = new Board();
        board.addFigure(new Bishop("black", new Cell(5, 4)));
        board.addFigure(new Bishop("black", new Cell(3, 4)));
        board.addFigure(new Bishop("black", new Cell(2, 5)));
        board.addFigure(new Castle("black", new Cell(7, 3)));
        board.addFigure(new Knight("black", new Cell(4, 4)));

        System.out.println("All Figures");
        Figure[] figure1 = board.getFigure();
        for (Figure fig : figure1) {
            if (fig != null) {
                System.out.println(fig.getClass().getSimpleName() +": " +fig.position.getPositionX() +" " +fig.position.getPositionY() );
            }
        }

        System.out.println("Move Bishop");
        board.move(new Cell(5, 4), new Cell(2, 1));
        Figure[] figure2 = board.getFigure();
        for (Figure fig : figure2) {
            if (fig != null) {
                System.out.println(fig.getClass().getSimpleName() +": " +fig.position.getPositionX() +" " +fig.position.getPositionY() );
            }
        }

        System.out.println("Move  Castle");
        board.move(new Cell(4, 4), new Cell(2, 3));
        Figure[] figure3 = board.getFigure();
        for (Figure fig : figure3) {
            if (fig != null) {
                System.out.println(fig.getClass().getSimpleName() +": " +fig.position.getPositionX() +" " +fig.position.getPositionY() );
            }
        }

        // result = true, if "a" and "b" in range = -128; 127;
        Integer a = 128;
        Integer b = 128;
        Integer c = 140;
        Integer d = 140;
        System.out.println(a==b);
        System.out.println(c==d);

        Bishop bishop = new Bishop("black", new Cell(1, 1));*/


}
