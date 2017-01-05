package com.adidyk;

import java.io.*;

public class RemoveAbuse {

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            String text;
            do {
//            while (!(text = br.readLine()).equals("q")) {
                text = br.readLine();
                String[] args = text.split(" ");
                for (int arg = 0; arg < args.length; arg++) {
                    for (String abu : abuse) {
                        if (args[arg].equals(abu)) {
                            args[arg] = " ";
                        }
                    }
                }
                for (String arg : args) {
                    bw.write(arg + " ");
                }

            }
            while (!text.equals("q"));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

