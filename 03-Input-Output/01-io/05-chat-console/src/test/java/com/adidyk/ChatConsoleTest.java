package com.adidyk;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChatConsoleTest {

    @Test
    public void chatTest() throws IOException {

        String[] answerSource = {"yes", "yes", "yes", "yes"};
        String[] questionSource = {"Do you work ?", "Does she do exercise ?", "Did you see her ?", "Do you like it ?"};
        String actual = "[question]: Do you work ? " +
                        "[answer]:   yes " +
                        "[question]: Does she do exercise ? " +
                        "[answer]:   yes " +
                        "[question]: Did you see her ? " +
                        "[answer]:   yes " +
                        "[question]: Do you like it ? " +
                        "[answer]:   yes ";

        File answer = new File("answerTest.txt");
        File quest = new File("questionTest.txt");
        File log = new File("logTest.txt");

        // create file answerTest.txt
        try (RandomAccessFile rafAnswer = new RandomAccessFile(answer, "rw")) {
            for (String ans : answerSource) {
                rafAnswer.writeBytes(ans.concat(System.lineSeparator()));
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        String line = "";
        for (String question : questionSource) {
            line = line.concat(question).concat(System.lineSeparator());
        }
        ChatConsole chatCons = new ChatConsole();
        chatCons.chat(new ByteArrayInputStream(line.getBytes()), answer, log);


        String result = "";
        String row;
        try (RandomAccessFile rafLog = new RandomAccessFile(log, "r")) {
            while ((row = rafLog.readLine()) != null) {
                result = result.concat(row).concat(" ");
            }

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertThat(result, is(actual));
    }

}
