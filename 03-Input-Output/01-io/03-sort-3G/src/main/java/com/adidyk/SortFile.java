package com.adidyk;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class SortFile {

    private String[] names; // names - names all temp file

    //
    public void sort(File source, File distance) throws IOException {
        this.splitFile(source);
        this.sortAllTempFile();
        this.sortMerge(distance);
    }

    // /split - it write rows to files, file size auto detected
    private void splitFile(File source) throws IOException {
        try (RandomAccessFile rafSource = new RandomAccessFile(source, "r")) {
            int index = 0;
            String temp = "temp".concat(Integer.toString(index)).concat(".txt");
            String name = temp.concat(" ");
            RandomAccessFile rafTemp = new RandomAccessFile(temp, "rw");
            String row;
            while ((row = rafSource.readLine()) != null) {
                if (rafTemp.length() < 30) {
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
    private void sortAllTempFile() throws IOException {
        for (String name : this.names) {
            try (RandomAccessFile rafTemp = new RandomAccessFile(name, "rw")) {
                String row = this.fromArrayStringInString(this.sortBubble(this.fromRAFileInString(rafTemp)));
                rafTemp.seek(0);
                rafTemp.writeBytes(row);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
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
        String min;
            for (int j = rows.length - 1; j > 0; j--) {
                for (int i = 0; i < j; i++) {
                    if (rows[i].length() > rows[i+1].length()) {
                        min = rows[i + 1];
                        rows[i + 1] =rows[i];
                        rows[i] = min;
                    }
                }
            }
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

    private void sortMerge(File distance) throws IOException {
        try (RandomAccessFile rafDist = new RandomAccessFile(distance, "rw")) {

            RandomAccessFile [] raf = new RandomAccessFile[this.names.length];
            String[] rows = new String[this.names.length];
            //String[] rows = new String[this.names.length];
            for (int index = 0; index < this.names.length; index++) {
                raf[index] = new RandomAccessFile(this.names[index], "r");
                rows[index] = raf[index].readLine();
            }

            String min = rows[0];
            int position = 0;
            int flag = 0;

            while (flag < raf.length) {
                for (int index = 0; index < rows.length; index++) {
                    if (rows[index] != null) {
                        if (min.length() > rows[index].length()) {
                            min = rows[index];
                            position = index;
                        }
                    }
                }

                rafDist.writeBytes(min.concat(System.lineSeparator()));

                if ((rows[position] = raf[position].readLine()) != null) {
                    min = rows[position];
                } else {
                    flag++;
                    rows[position] = null;
                    //raf[position] = null;
                    for (String row : rows) {
                        if (row != null) {
                            min = row;
                            break;
                        }
                    }
                }

            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
