package com.adidyk;

import java.io.*;

public class RemoveAbuse {

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            int index = 0;
            String text;
            while (index != -1) {
                text = br.readLine();
                String[] args = text.split(" ");
                for (int arg = 0; arg < args.length; arg++) {
                    for (String abu : abuse) {
                        if (args[arg].equals(abu)) {
                            args[arg] = null;
                        }
                    }
                }
            }

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

