package com.adidyk;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SortFile {

    private String[] names; // names - names all temp file

    //
    public void sort(File source, File distance) throws IOException {
        this.split(source);
        this.sortAllFile();
    }

    // /split - it write rows to files, file size auto detected
    private void split(File source) throws IOException {
        try (RandomAccessFile rafSource = new RandomAccessFile(source, "r")) {
            int index = 0;
            String temp = "temp".concat(Integer.toString(index)).concat(".txt");
            String name = temp.concat(" ");
            RandomAccessFile rafTemp = new RandomAccessFile(temp, "rw");
            String row;
            while ((row =rafSource.readLine()) != null) {
                if (rafTemp.length() < 60) {
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

    //
    private void sortAllFile() throws IOException {
        for (String name : this.names) {
            System.out.println("Name: " + name);
            try (RandomAccessFile rafTemp = new RandomAccessFile(name, "rw")) {
                String row = this.fromArrayStringInString(this.sortBubble(this.fromRAFileInString(rafTemp)));
                rafTemp.seek(0);
                rafTemp.writeBytes(row);
            }
            catch (Exception ex) {
                System.out.println();
            }
        }
    }

    //
    private String[] fromRAFileInString(RandomAccessFile raf) throws IOException {
        byte[] buffer = new byte[(int)raf.length()];
        raf.read(buffer, 0, (int)raf.length());
        return new String(buffer, "cp1251").split(System.lineSeparator());
    }

    //
    private String[] sortBubble(String[] rows) {
        boolean flag = true;
        String min;
       // while (flag) {
            for (int j = rows.length - 1; j > 0; j--) {
                for (int i = 0; i < j; i++) {
                    if (rows[i].length() > rows[i+1].length()) {
                        min = rows[i + 1];
                        rows[i + 1] =rows[i];
                        rows[i] = min;
                    } //else {
                       // flag = false;
                   // }
                }
            }
        //}
        return rows;
    }

    //
    private String fromArrayStringInString(String[] rows) throws IOException {
        String line = "";
        for (String row : rows) {
            line = line.concat(row).concat(System.lineSeparator());
        }
        return line;
    }

}
