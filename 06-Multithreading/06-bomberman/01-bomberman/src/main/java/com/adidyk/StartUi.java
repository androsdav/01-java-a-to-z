package com.adidyk;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 23.05.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - runs program only for create jar file.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        System.out.println("BOMBER");
        Cell cell = new Cell(1, 2);
        System.out.println(cell);
        BomberMan bomber = new BomberMan(new Cell(4, 6), "bomber");
        System.out.println(bomber);
        bomber.moveDown();
        System.out.println(bomber);
    }

}