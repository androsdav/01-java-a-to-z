package com.adidyk;

import java.io.*;

import static java.lang.Math.random;

public class ChatConsole {

    private static final String FINISH = "finish", STOP = "stop", PLAY = "play";
    private static final String separator = System.lineSeparator();

    // chat - just do all for console chat
    public void chat(InputStream in, File ans, File log) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
        RandomAccessFile rafAnswer = new RandomAccessFile(ans, "rw");
        RandomAccessFile rafLog = new RandomAccessFile(log, "rw")) {
            String question;
            String answer;
            boolean flagStop = false;
            String[] rows = this.getPositionAllRow(rafAnswer);
            System.out.print("[question]: ");
            while (!(question = br.readLine()).equals(FINISH)) {
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
                    System.out.println("[answer]:   " + answer);
                    rafLog.writeBytes("[question]: " + question);
                    rafLog.writeBytes(separator);
                    rafLog.writeBytes("[answer]:   " + answer);
                    rafLog.writeBytes(separator);
                } else{
                    rafLog.writeBytes("[question]: " + question);
                    rafLog.writeBytes(separator);
                }
                System.out.print("[question]: ");
            }
            rafLog.writeBytes("[question]: " + question);
            rafLog.writeBytes(separator);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // getPositionAllRow - return positions for all rows from file = "answer.txt"
    private String[] getPositionAllRow(RandomAccessFile raf) throws IOException {
        String line = "0".concat(System.lineSeparator());
        while ((raf.readLine()) != null) {
            line = line.concat(Long.toString(raf.getFilePointer())).concat(System.lineSeparator());
        }
        return line.split(System.lineSeparator());
    }

}
