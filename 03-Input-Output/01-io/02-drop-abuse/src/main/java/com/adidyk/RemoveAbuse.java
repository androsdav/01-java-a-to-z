package com.adidyk;

import java.io.*;

public class RemoveAbuse {

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            String text;
            text = br.readLine();
            String[] args = text.split(" ");
            for (String arg : args) {
                for (String abu : abuse) {
                    if (!arg.equals(abu)) {
                        bw.write(arg +" ");
                    }
                }
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

