package com.adidyk;

import java.io.*;

public class RemoveAbuse {

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            int index = 0;
            String text;
            while (index != -1) {
                text = br.readLine();

            }

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
