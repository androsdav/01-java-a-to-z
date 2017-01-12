package com.adidyk;

import java.io.*;

public class SortFile {

    private String name;

    public void sort(File source, File distance) throws IOException {

        try (RandomAccessFile rafSource = new RandomAccessFile(source, "r")) {
            // initialization param
            String row;
            int index = 0;
            String temp = "temp".concat(Integer.toString(index)).concat(".txt");
            RandomAccessFile rafTemp = new RandomAccessFile(temp, "rw");
            this.name = temp.concat(" ");
            // it write rows to files, file size auto detected
            while ((row = rafSource.readLine()) != null) {
                if (rafTemp.length() < 50) {
                    rafTemp.writeBytes(row.concat(System.lineSeparator()));
                } else {
                    index++;
                    temp = "temp".concat(Integer.toString(index)).concat(".txt");
                    this.name = this.name.concat(temp).concat(" ");
                    rafTemp = new RandomAccessFile(temp, "rw");
                    rafTemp.writeBytes(row.concat(System.lineSeparator()));
                }
            }
            rafTemp.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try (RandomAccessFile rafDist = new RandomAccessFile(distance, "rw")) {

            String[] args = this.name.split(" ");
            RandomAccessFile rafTemp = new RandomAccessFile(args[0], "rw");
            byte[] buffer = new byte[(int)rafTemp.length()];
            rafTemp.read(buffer, 0, (int)rafTemp.length());
            String[] newLine = (new String(buffer, "cp1251")).split(" ");

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // convert
        String[] args = this.name.split(" ");
        RandomAccessFile rafTemp = new RandomAccessFile(args[0], "rw");
        byte[] buffer = new byte[(int)rafTemp.length()];
        rafTemp.read(buffer, 0, (int)rafTemp.length());
        String[] newLine = (new String(buffer, "cp1251")).split(" ");

        /*System.out.print(newLine);

        for (int i = 0; i < newLine.length; i++) {
            System.out.print(newLine[i]);
        }*/

        rafTemp.close();




    }

}
