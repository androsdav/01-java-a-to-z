package com.adidyk;

import java.io.*;

public class SortFile {

    public void sort(File source, File distance) throws FileNotFoundException {

        try (RandomAccessFile rafSource = new RandomAccessFile(source, "r");
            RandomAccessFile rafDist = new RandomAccessFile(distance, "rw")) {

            // initialization param
            String row;
            int index = 0;
            String tempFile = "temp".concat(Integer.toString(index)).concat(".txt");;
            RandomAccessFile rafTemp = new RandomAccessFile(tempFile, "rw");

            // it write rows to file, file size auto detected
            while ((row = rafSource.readLine()) != null) {
                if (rafTemp.length() < 50) {
                    rafTemp.writeBytes(row.concat(System.lineSeparator()));
                } else {
                    index++;
                    tempFile = "temp".concat(Integer.toString(index)).concat(".txt");
                    rafTemp = new RandomAccessFile(tempFile, "rw");
                    rafTemp.writeBytes(row.concat(System.lineSeparator()));
                }
            }
            rafTemp.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        /*try (BufferedReader br = new BufferedReader(new FileReader(source));
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
        }*/

    }

}
