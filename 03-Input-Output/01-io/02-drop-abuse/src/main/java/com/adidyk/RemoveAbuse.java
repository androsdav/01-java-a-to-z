package com.adidyk;

import java.io.*;

public class RemoveAbuse {

    // dropAbuses - drop words in the stream, that included in the array abuse
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            String text;
            text = br.readLine();
            String[] args = text.split(" ");
            for (int arg = 0; arg < args.length; arg++) {
                for (String abu : abuse) {
                    if (args[arg] != null && args[arg].equals(abu)) {
                        args[arg] = null;
                    }
                }
                if (args[arg] != null) {
                    bw.write(args[arg] + " ");
                }
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

