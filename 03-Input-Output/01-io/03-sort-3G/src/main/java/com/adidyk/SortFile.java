package com.adidyk;

import java.io.*;

public class SortFile {

    public void sort(File source, File distance) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             BufferedWriter bw = new BufferedWriter(new FileWriter(distance))) {

            distance.createNewFile();
            String row;
            String max = br.readLine();
            while ((row = br.readLine()) != null) {
                if (max.length() > row.length()) {
                    bw.write(Integer.toString(row.length()));
                    bw.newLine();
                } else {
                    bw.write(Integer.toUnsignedString(max.length()));
                    bw.newLine();
                    max = row;
                }
                //bw.write(row);
                //bw.newLine();
                //System.out.println(row);
            }
            bw.write((Integer.toString(max.length())));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
