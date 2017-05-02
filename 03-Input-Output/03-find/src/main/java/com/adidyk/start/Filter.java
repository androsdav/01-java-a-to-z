package com.adidyk.start;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {

    private String keyFind;
    private String name;

    // Constructor
    Filter(String name, String keyFind) {
        this.name = name;
        this.keyFind = keyFind;
    }

    @Override
    public boolean accept(File dir, String name) {
        // "-f" - full match
        if ("-f".equals(this.keyFind)) {
            if (this.name.equals(name)) {
                return true;
            }
        }
        // "-m" - maximum match
        else if ("-m".equals(this.keyFind)) {
            if (name.contains(this.name)) {
                return true;
            }
        }
        // "-e" - file extension
        else if ("-e".equals(this.keyFind)) {
            if (name.endsWith(this.name)) {
                return true;
            }
        }
        return new File(dir, name).isDirectory();
    }

}
