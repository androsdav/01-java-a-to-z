package com.adidyk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SortFile {

    public void sort(File source) {
        try (FileInputStream fis = new FileInputStream(source)) {
            int index = -1;
            while ((index = fis.read()) != -1) {
                System.out.print((char)index);

            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
