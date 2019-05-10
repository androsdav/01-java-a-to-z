package com.adidyk.input;

/**
 * Interface Input contains method for entering data from console.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public interface Input {

    /**
     * ask - returns entering data from console.
     * @param question - question.
     * @return - returns entering data from console.
     */
    String ask(String question);

    /**
     * ask - returns the inputted of data from the console if the data is integer, and if inputted
     * of data is entered in the range.
     * @param question - question.
     * @param range - range of menu numbers.
     * @return - returns the inputted of data from the console if the data is integer, and if inputted
     * of data is entered in the range.
     */
    int ask(String question, int[] range);

    /**
     * askInt - returns the inputted of data from the console if the data is integer.
     * @param question - question.
     * @return - returns the inputted of data from the console if the data is integer.
     */
    String askInt(String question);

}