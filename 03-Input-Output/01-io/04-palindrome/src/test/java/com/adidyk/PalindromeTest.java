package com.adidyk;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class PalindromeTest {

    @Test
    public void palindromeCheckTest() throws IOException {

        String word = "komok";
        Palindrome palindrome = new Palindrome();
        boolean valid = palindrome.palindromeCheck(new ByteArrayInputStream(word.getBytes()));
        assertTrue(valid);

    }

}