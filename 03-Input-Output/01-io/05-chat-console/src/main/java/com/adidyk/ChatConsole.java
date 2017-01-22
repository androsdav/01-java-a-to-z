package com.adidyk;

import java.io.*;
import java.util.Map;

import static java.lang.Math.random;

public class ChatConsole {

    public void chat(InputStream in, File ans, File log) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
        RandomAccessFile rafAnswer = new RandomAccessFile(ans, "rw");
        RandomAccessFile rafLog = new RandomAccessFile(log, "rw")) {
            String question;
            String answer;
            boolean flag = false;
            String[] rows = this.answerRandom(rafAnswer);
            for (String row : rows) {
                System.out.print(row + " ");
            }
            while (!(question = br.readLine()).equals("finish")) {
                if (question.equals("stop")) {
                    flag = true;
                }
                if (question.equals("play")) {
                    flag = false;
                }
                if (!flag) {
                    long pos = (long)(random() * rows.length);
                    rafAnswer.seek(Long.valueOf(  rows[(int)(random() * rows.length)] ));
                    System.out.println(pos);
                    answer = rafAnswer.readLine();
                    System.out.println(answer);
                    rafLog.writeBytes("[question]: " + question.concat(System.lineSeparator()));
                    rafLog.writeBytes("[answer]:   " + answer.concat(System.lineSeparator()));
                } else{
                    rafLog.writeBytes("[question]: " + question.concat(System.lineSeparator()));
                }
            }
            rafLog.writeBytes("[question]: " + question.concat(System.lineSeparator()));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String[] answerRandom(RandomAccessFile raf) throws IOException {
        String line = "";
        while ((raf.readLine()) != null) {
            line = line.concat(Long.toString(raf.getFilePointer())).concat(" ");
            //System.out.println("test");
        }
        String[] rows = line.split(" ");
        //for (String rw : rows) {
        //    System.out.println(rw);
       // }
        return rows;


   // System.out.println(rowPosition);
    }
}
