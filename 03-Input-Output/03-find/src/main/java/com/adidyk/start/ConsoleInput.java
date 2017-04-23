package com.adidyk.start;

import java.util.Scanner;

public class ConsoleInput implements Input {

    @Override
    public String ask(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return scanner.nextLine();
    }

}
