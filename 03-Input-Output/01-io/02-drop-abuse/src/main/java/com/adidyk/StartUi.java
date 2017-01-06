package com.adidyk;

import java.io.*;
import java.util.ArrayList;

public class StartUi {

    // main - input several row from console, for finished input <q>
    public static void main(String[] args) throws IOException {
        RemoveAbuse ra = new RemoveAbuse();
        String[] abuse = {"abuse1", "abuse2", "abuse3"};
        String text;
        String row = "";
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Input several row, for finished input <q>: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (!(text = br.readLine()).equals("q")) {
            list.add(text);
        }
        br.close();
        for (String arg : list) {
            row = row.concat(arg).concat(" ");
        }
        System.out.println(row);
        ra.dropAbuses(new ByteArrayInputStream(row.getBytes()), System.out, abuse);
    }

}
