package com.adidyk;

import java.io.*;

public class SortFile {

    public void sort(File source) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {

            String row;
            while ((row = br.readLine()) != null) {
                System.out.println(row);
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
