package com.adidyk;

import java.io.*;

public class StartUi {

    // main - just main
    public static void main(String[] args) throws IOException {
        System.out.println("Input word - palindrome: ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Palindrome palindrome = new Palindrome();
            palindrome.palindromeCheck(new ByteArrayInputStream(br.readLine().getBytes()));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

