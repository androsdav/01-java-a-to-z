package com.adidyk;

import java.util.Scanner;

public class ConsoleInput implements Input {

    public String ask(String string) {
        System.out.println(string);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
