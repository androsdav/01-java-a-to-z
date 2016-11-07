package com.adidyk.start;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {
        boolean invalid =true;
        int value = -899;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch(NumberFormatException nfe) {
                System.out.println(" Please enter validate data again.");
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println(" Test input text. ");
            }
        } while (invalid);
        return value;

    }

}
