package com.adidyk;

import org.junit.Test;

import java.io.*;

public class ChatConsoleTest {

    @Test
    public void chatTest() throws IOException {

        String[] answerSource = {"I do not know", "no", "maybe", "nothing"};
        String[] questionSource = {"Do you work ?", "Does she do exercise ?", "Did you see her ?", "Do you like it ?"};

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

        //
       // try (RandomAccessFile rafQuest = new RandomAccessFile(quest, "rw")) {
       //     for (String question : questionSource) {
       //         rafQuest.writeBytes(question.concat(System.lineSeparator()));
       //     }
       // }
       // catch (Exception ex) {
       //     System.out.println(ex.getMessage());
       // }



        //
        //ChatConsole chatConsole = new ChatConsole();
    //    try (RandomAccessFile raf = new RandomAccessFile(quest, "r")) {
    //        String row;
    //        ChatConsole chatConsole = new ChatConsole();
    //        while ((row = raf.readLine()) != null)  {
    //            chatConsole.chat(new ByteArrayInputStream(row.getBytes()), answer, log);
    //        }

    //    }
    //    catch (Exception ex) {
    //        System.out.println(ex.getMessage());
    //    }
        //for (String question : questionSource) {
        //    System.out.println(question + "test");
        //    chatConsole.chat(new BufferedReader(new InputStreamReader(question)), answer, log);
        //}




    }

}
