package com.adidyk;

import java.io.*;

public class SortFile {

    public void sort(File source, File distance) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             BufferedWriter bw = new BufferedWriter(new FileWriter(distance))) {

            distance.createNewFile();
            String row;
            while ((row = br.readLine()) != null) {
                bw.write(row + "\n");
                //bw.write("\n");
                System.out.println(row);

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
