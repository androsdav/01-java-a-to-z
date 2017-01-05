package com.adidyk;

import java.io.*;
import java.util.ArrayList;

public class StartUi {

    // main - input row from console
    public static void main(String[] args) throws IOException {
        RemoveAbuse ra = new RemoveAbuse();
        String[] abuse = {"abuse1", "abuse2"};
        String text;
        String row = "";
        ArrayList<String> list = new ArrayList<>();
        byte[] buffer;
        System.out.println("Input several row, for finished input <q>: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (!(text = br.readLine()).equals("q")) {
            list.add(text);
        }
        br.close();
        for (String arg : list) {
            row = row.concat(arg).concat(" ");
        }
        buffer = row.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        ra.dropAbuses(bais, System.out, abuse);
    }

}
