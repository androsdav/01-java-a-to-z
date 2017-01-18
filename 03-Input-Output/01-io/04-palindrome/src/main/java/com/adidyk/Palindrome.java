package com.adidyk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Palindrome {

    public boolean palindromeCheck(InputStream in) throws IOException {
        boolean palindromeFlag =false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            char[] letters = br.readLine().toLowerCase().toCharArray();
            if (letters.length < 6) {
                for (int index = 0; index < letters.length / 2; index++) {
                    if (letters[index] == letters[letters.length - index - 1]) {
                        palindromeFlag = true;
                    } else {
                        palindromeFlag = false;
                        break;
                    }
                }
            } else {
                throw new MoreThanFifeLetters("Input word has more than fife letters");
            }

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return palindromeFlag;
    }
}
