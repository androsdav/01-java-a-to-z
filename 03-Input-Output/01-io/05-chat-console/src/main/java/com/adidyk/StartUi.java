package com.adidyk;

import java.io.*;

public class StartUi {

    // main - just main
    public static void main(String[] args) throws IOException {
        File answer = new File("answer.txt");
        File log = new File("log.txt");
        ChatConsole chatConsole = new ChatConsole();
        chatConsole.chat(System.in,answer, log);
       // try (RandomAccessFile raf = new RandomAccessFile(answer, "rw")) {
       //     chatConsole.answerRandom(raf);
       // }
       // catch (Exception ex) {
       //     ex.getMessage();
       // }


/*        System.out.println("Input word - palindrome: ");
        try {
            Palindrome palindrome = new Palindrome();
            System.out.println(palindrome.palindromeCheck(System.in));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/
        //System.out.println("Hello Word !!!");
    }

}

