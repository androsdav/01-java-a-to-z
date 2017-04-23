package com.adidyk.start;

import java.util.Scanner;

public class ConsoleInput implements Input {

    @Override
    public String ask() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
