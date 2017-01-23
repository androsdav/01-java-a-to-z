package com.adidyk;

import org.junit.Test;

import java.io.*;

public class ChatConsoleTest {

    @Test
    public void chatTest() throws IOException {

        String[] answerSource = {"yes", "yes", "yes", "yes"};
        String[] questionSource = {"Do you work ?", "Does she do exercise ?", "Did you see her ?"};

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

        try (RandomAccessFile rafQuest = new RandomAccessFile(quest, "rw")) {
            for (String question : questionSource) {
                rafQuest.writeBytes(question.concat(System.lineSeparator()));
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //ChatConsole chatConsole = new ChatConsole();
        //for (String question : questionSource) {
        //    System.out.println(question + "test");
        //    chatConsole.chat(new BufferedReader(new InputStreamReader(question)), answer, log);
        //}




    }

}
