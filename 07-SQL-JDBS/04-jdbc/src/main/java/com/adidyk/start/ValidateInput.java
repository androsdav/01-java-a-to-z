package com.adidyk.start;

public class ValidateInput extends ConsoleInput {



    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch(MenuOutException moe) {
                System.out.println(" Please select key from menu. ");
            } catch (NumberFormatException nfe) {
                System.out.println(" Please enter validate data again. ");
            }
        } while (invalid);
        return value;
    }

    public String askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.valueOf(super.ask(question));
                invalid = false;
            } catch(MenuOutException moe) {
                System.out.println(" Please select key from menu. ");
            } catch (NumberFormatException nfe) {
                System.out.println(" Please enter validate data again. ");
            }
        } while (invalid);
        return String.valueOf(value);
    }



}
