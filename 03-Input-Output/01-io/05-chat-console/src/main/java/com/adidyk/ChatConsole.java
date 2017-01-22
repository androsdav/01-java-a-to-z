package com.adidyk;

import java.io.*;

public class ChatConsole {

    public void chat(InputStream in, OutputStream out, File ans, File log) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
        RandomAccessFile rafAnswer = new RandomAccessFile(ans, "rw");
        RandomAccessFile rafLog = new RandomAccessFile(log, "rw")) {

            String question = br.readLine();
            String answer;
            do {
                answer = rafAnswer.readLine();
                System.out.println(answer);
                rafLog.writeBytes("[question]:" + question.concat(System.lineSeparator()));
                rafLog.writeBytes("[answer]:" +answer.concat(System.lineSeparator()));
            }
            while (!(question = br.readLine()).equals("finish"));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

    private void answer(File answer) {

    }
}
