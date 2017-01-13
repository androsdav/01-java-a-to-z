package com.adidyk;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SortFile {

    private String[] names;

    private void split(File source) {
        try (RandomAccessFile rafSource = new RandomAccessFile(source, "r")) {
            // initialization param
            int index = 0;
            String temp = "temp".concat(Integer.toString(index)).concat(".txt");
            String name = temp.concat(" ");
            RandomAccessFile rafTemp = new RandomAccessFile(temp, "rw");
            String row;
            // it write rows to files, file size auto detected
            while ((row =rafSource.readLine()) != null) {
                if (rafTemp.length() < 60) {
                    rafTemp.writeBytes(row.concat(System.lineSeparator()));
                } else {
                    index++;
                    temp = "temp".concat(Integer.toString(index)).concat(".txt");
                    System.out.println(name);
                    name = name.concat(temp).concat(" ");
                    rafTemp = new RandomAccessFile(temp, "rw");
                    rafTemp.writeBytes(row.concat(System.lineSeparator()));
                }
            }
            this.names = name.split(" ");
            System.out.println(name);
            rafTemp.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void sortBubble() {


    }

    public void sort(File source, File distance) throws IOException {

        this.split(source);
//        System.out.println(Arrays.toString(this.names));

        for (String index : this.names) {
            if (index != null) {
                System.out.println(index);
            }

        }



     /*   try (RandomAccessFile rafDist = new RandomAccessFile(distance, "rw")) {

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
        }

        rafTemp.close();*/




    }

}
