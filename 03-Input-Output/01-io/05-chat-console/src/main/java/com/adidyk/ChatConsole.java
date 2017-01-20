package com.adidyk;

import java.io.*;

public class ChatConsole {

    public void chat(InputStream in, OutputStream out, File answer, File log) {

//        File fileLog = new File("log.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in)); RandomAccessFile raf = new RandomAccessFile(log, "rw")) {

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }



    }

    private void answer(File answer) {

    }
}
