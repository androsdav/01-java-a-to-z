package com.adidyk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Palindrome {

    public void palindromeCheck(InputStream in) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String row = br.readLine().toLowerCase();
            char[] letters = row.toCharArray();
            String rows = row.toLowerCase();
            System.out.println(row);
            System.out.println(rows);
            for (char lett : letters) {
                System.out.print(lett +" ");
            }

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
