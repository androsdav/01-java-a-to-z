package com.adidyk.input;

import org.apache.log4j.Logger;

/**
 * Class ValidateInput contains method for entering data from console.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * @param logger - link variable to object of class Logger.
     */
    private static final Logger logger = Logger.getLogger(ValidateInput.class);

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
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                logger.info("please select key from menu ... ");
            } catch (NumberFormatException nfe) {
                logger.info(" [info] please enter validate data again ... ");
            }
        } while (invalid);
        return value;
    }

    /**
     * askInt - returns the inputted of data from the console if the data is integer.
     * @param question - question.
     * @return - returns the inputted of data from the console if the data is integer.
     */
    @Override
    public String askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.valueOf(super.ask(question));
                invalid = false;
            } catch (NumberFormatException nfe) {
                logger.info("please enter validate data again ... ");
            }
        } while (invalid);
        return String.valueOf(value);
    }

}