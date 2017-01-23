package com.adidyk;

import org.junit.Test;
import java.io.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChatConsoleTest {

    private File answer = new File("answerTest.txt");
    private File log = new File("logTest.txt");
    private String[] answerSource = {"yes", "yes", "yes", "yes"};
    private String[] questionSource = {"Do you work ?", "Does she do exercise ?", "Did you see her ?", "Do you like it ?"};
    private String actual = "[question]: Do you work ? " +
                            "[answer]:   yes " +
                            "[question]: Does she do exercise ? " +
                            "[answer]:   yes " +
                            "[question]: Did you see her ? " +
                            "[answer]:   yes " +
                            "[question]: Do you like it ? " +
                            "[answer]:   yes ";

    @Test
    public void chatTest() throws IOException {
        this.createAnswerFile();
        String line = this.getLine();
        ChatConsole chatConsole = new ChatConsole();
        chatConsole.chat(new ByteArrayInputStream(line.getBytes()), this.answer, this.log);
        String result = this.getResult();
        this.answer.delete();
        this.log.delete();
        assertThat(result, is(this.actual));
    }

    // createAnswerFile - create file with answers
    private void createAnswerFile() {
        try (RandomAccessFile rafAnswer = new RandomAccessFile(this.answer, "rw")) {
            for (String ans : this.answerSource) {
                rafAnswer.writeBytes(ans.concat(System.lineSeparator()));
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    // getLine - return line from array questionSource
    private String getLine() {
        String line = "";
        for (String question : this.questionSource) {
            line = line.concat(question).concat(System.lineSeparator());
        }
        return line;
    }

    // getResult - return result row from file = "logTest.txt"
    private String getResult() {
        String result = "";
        String row;
        try (RandomAccessFile rafLog = new RandomAccessFile(log, "r")) {
            while ((row = rafLog.readLine()) != null) {
                result = result.concat(row).concat(" ");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

}
