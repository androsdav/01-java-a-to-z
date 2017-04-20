package com.adidyk;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {


    private String mask;

    Filter(String mask) {
        this.mask = mask;
    }


    @Override
    public boolean accept(File dir, String name) {

        if (this.mask.equals("1")) {
            if (name.lastIndexOf('.') > 0) {
                int lastIndex = name.lastIndexOf('.');
                String str = name.substring(lastIndex);
                if (str.equals(".txt")) {
                    return true;
                }
            }
        }

        else if (this.mask.equals("2")) {
            if (name.equals("123.txt")) {
                return true;
            }
        }

       return new File(dir, name).isDirectory();
    }

}
