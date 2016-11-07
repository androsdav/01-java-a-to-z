package com.adidyk.start;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {
        try {
            return super.ask(question, range);

        } catch(NumberFormatException nfe) {
            System.out.println(" Please enter validate data again.");
        }
    }

}
