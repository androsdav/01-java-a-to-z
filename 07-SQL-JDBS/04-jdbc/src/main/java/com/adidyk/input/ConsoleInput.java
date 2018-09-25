package com.adidyk.input;

import java.util.Scanner;

/**
 * Class ConsoleInput contains method for entering data from console.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public class ConsoleInput implements Input {

    /**
     * @param scanner - link variable to object of class Scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * ask - returns entering data from console.
     * @param question - question.
     * @return - returns entering data from console.
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return this.scanner.nextLine();
    }

    /**
     * ask - returns the inputted of data from the console if the data is integer, and if inputted
     * of data is entered in the range.
     * @param question - question.
     * @param range - range of menu numbers.
     * @return - returns the inputted of data from the console if the data is integer, and if inputted
     * of data is entered in the range.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException(" [info] out of menu range ... ");
        }
    }

    /**
     * askInt - returns the inputted of data from the console if the data is integer.
     * @param question - question.
     * @return - returns the inputted of data from the console if the data is integer.
     */
    @Override
    public String askInt(String question) {
        return this.ask(question);
    }

}