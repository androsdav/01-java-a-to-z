package com.adidyk;

import java.io.*;

public class ChatConsole {

    public void chat(InputStream in, OutputStream out, File answer, File log) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in)); RandomAccessFile raf = new RandomAccessFile(answer, "rw")) {

            //String row;
            while (br.readLine() != "finish") {
                System.out.println(raf.readLine());
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

    private void answer(File answer) {

    }
}
