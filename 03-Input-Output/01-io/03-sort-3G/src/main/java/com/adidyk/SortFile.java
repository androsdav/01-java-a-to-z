package com.adidyk;

import java.io.*;

public class SortFile {

    public void sort(File source, File distance) throws FileNotFoundException {

        try (RandomAccessFile rafSource = new RandomAccessFile(source, "r");
            RandomAccessFile rafDist = new RandomAccessFile(distance, "rw")) {

            String row;
            String tempFile;
            long length = 0;
            RandomAccessFile rafTemp;
            int index = 0;

            while ((row = rafSource.readLine()) != null) {
                tempFile = "temp".concat(Integer.toString(index)).concat(".txt");
                rafTemp = new RandomAccessFile(tempFile, "rw");
                rafTemp.writeBytes(row);
                length = length + row.length();
                index++;

                //              if

                // try rafWrite = new RandomAccessFile(File.createTempFile("text", ".txt", new File("D:/temp/")), "rw"); {
                //     rafWrite.writeBytes(row);
                //            }
                // catch (Exception ex) {
                //     ex.printStackTrace();
                //  }


                //rafWrite.setLength(1);
                //long len = rafRead.length();
                //String row;
                //while ((row = rafRead.readLine()) != null) {
                //   rafWrite.writeBytes(row);
                //    rafWrite.writeBytes(System.lineSeparator());
                //System.out.println(row);

                //}
                //System.out.println(len);
                rafTemp.close();
//                System.out.println(rafSource.length());
  //              System.out.println(length);
            }
            System.out.println(rafSource.length());
            System.out.println(length);

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
