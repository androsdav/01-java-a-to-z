package com.adidyk;

import java.io.*;
import static java.lang.Math.random;

public class ChatConsole {

    private static final String FINISH = "finish", STOP = "stop", PLAY = "play";
    private static final String SEPARATOR = System.lineSeparator();
    private static final String QUESTION = "[question]: ";
    private static final String ANSWER = "[answer]:   ";

    // chat - just do all for console chat
    public void chat(InputStream in, File ans, File log) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
        RandomAccessFile rafAnswer = new RandomAccessFile(ans, "rw");
        RandomAccessFile rafLog = new RandomAccessFile(log, "rw")) {
            String question;
            String answer;
            boolean flagStop = false;
            String[] rows = this.getPositionAllRow(rafAnswer);
            System.out.print(QUESTION);
            while (!FINISH.equals((question = br.readLine()))) {
                if (STOP.equals(question)) {
                    flagStop = true;
                }
                if (PLAY.equals(question)) {
                    flagStop = false;
                }
                if (!flagStop) {
                    long pos = (long)(random() * rows.length - 1);
                    rafAnswer.seek(Long.valueOf(rows[(int)(pos)]));
                    answer = rafAnswer.readLine();
                    System.out.println(ANSWER + answer);
                    rafLog.writeBytes(QUESTION + question);
                    rafLog.writeBytes(SEPARATOR);
                    rafLog.writeBytes(ANSWER + answer);
                    rafLog.writeBytes(SEPARATOR);
                } else{
                    rafLog.writeBytes(QUESTION + question);
                    rafLog.writeBytes(SEPARATOR);
                }
                System.out.print(QUESTION);
            }
            rafLog.writeBytes(QUESTION + question);
            rafLog.writeBytes(SEPARATOR);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // getPositionAllRow - return positions for all rows from file = "answer.txt"
    private String[] getPositionAllRow(RandomAccessFile raf) throws IOException {
        String line = "0".concat(SEPARATOR);
        while ((raf.readLine()) != null) {
            line = line.concat(Long.toString(raf.getFilePointer())).concat(SEPARATOR);
        }
        return line.split(SEPARATOR);
    }

}