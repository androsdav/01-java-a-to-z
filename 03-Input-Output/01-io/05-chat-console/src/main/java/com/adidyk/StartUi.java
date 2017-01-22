package com.adidyk;

import java.io.*;

public class StartUi {

    // main - just main
    public static void main(String[] args) throws IOException {
        File answer = new File("answer.txt");
        File log = new File("log.txt");
        ChatConsole chatConsole = new ChatConsole();
        chatConsole.chat(System.in,answer, log);
    }

}

