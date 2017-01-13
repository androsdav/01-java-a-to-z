package com.adidyk;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SortFile {

    private String[] names;

    private void split(File source) throws IOException {
        try (RandomAccessFile rafSource = new RandomAccessFile(source, "r")) {
            // initialization param
            int index = 0;
            String temp = "temp".concat(Integer.toString(index)).concat(".txt");
            String name = temp.concat(" ");
            RandomAccessFile rafTemp = new RandomAccessFile(temp, "rw");
            String row;
            // it write rows to files, file size auto detected
            while ((row =rafSource.readLine()) != null) {
                if (rafTemp.length() < 40) {
                    rafTemp.writeBytes(row.concat(System.lineSeparator()));
                } else {
                    index++;
                    temp = "temp".concat(Integer.toString(index)).concat(".txt");
                    name = name.concat(temp).concat(" ");
                    rafTemp = new RandomAccessFile(temp, "rw");
                    rafTemp.writeBytes(row.concat(System.lineSeparator()));
                }
            }
            this.names = name.split(" ");
            rafTemp.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String[] transferToString(RandomAccessFile raf) throws IOException {
        byte[] buffer = new byte[(int)raf.length()];
        raf.read(buffer, 0, (int)raf.length());
        return new String(buffer, "cp1251").split(System.lineSeparator());
    }

    private String transferToByteArray(String[] rows) throws IOException {
        String line = "";
        for (String row : rows) {
            line = line.concat(row).concat(System.lineSeparator());
        }
        return line;
    }

    private String[] sortBubble(String[] rows) {
        boolean flag = true;
        String min;
        while (flag) {
            for (int j = rows.length - 1; j > 0; j--) {
                for (int i = 0; i < j; i++) {
                    if (rows[i].length() > rows[i+1].length()) {
                        min = rows[i + 1];
                        rows[i + 1] =rows[i];
                        rows[i] = min;
                    } else {
                        flag = false;
                    }
                }

            }
        }
        return rows;
    }

    private void sortBubbleAll() throws IOException {
        for (String name : this.names) {
            System.out.println("Name: " + name);
            try (RandomAccessFile rafTemp = new RandomAccessFile(name, "rw")) {
                String[] rows = sortBubble(this.transferToString(rafTemp));
                String row = transferToByteArray(rows);
                rafTemp.writeBytes(row);
            }
            catch (Exception ex) {
                System.out.println();
            }
        }
    }

    public void sort(File source, File distance) throws IOException {

        this.split(source);
        this.sortBubbleAll();

/*        for (String index : this.names) {
            if (index != null) {
                System.out.println(index);
            }

        } */



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
