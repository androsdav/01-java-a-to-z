package com.adidyk.start;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {


    private String keyFind;
    private String name;

    Filter(String name, String keyFind) {
        this.name = name;
        this.keyFind = keyFind;
    }

    @Override
    public boolean accept(File dir, String name) {
        // "-e" - file extension
        if ("-e".equals(this.keyFind)) {
            if (name.lastIndexOf('.') > 0) {
                int lastIndex = name.lastIndexOf('.');
                String string = name.substring(lastIndex);
                if (this.name.equals(string)) {
                    return true;
                }
            }
        }
        // "-f" - full match
        else if ("-f".equals(this.keyFind)) {
            if (this.name.equals(name)) {
                return true;
            }
        }

       return new File(dir, name).isDirectory();
    }

}
