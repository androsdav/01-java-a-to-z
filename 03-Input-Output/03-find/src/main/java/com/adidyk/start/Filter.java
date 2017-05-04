package com.adidyk.start;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter implements FilenameFilter {

    private String name;
    private String keyFind;
    private Pattern pattern;

    // Constructor
    Filter(String name, String keyFind) {
        this.name = name;
        this.keyFind = keyFind;
        this.pattern = Pattern.compile(this.name);
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
        // "-e" - file extension match
        else if ("-e".equals(this.keyFind)) {
            if (name.endsWith(this.name)) {
                return true;
            }
        }
        // "-r" - regex match
        else if ("-r".equals(this.keyFind)) {
            Matcher matcher = this.pattern.matcher(name);
            if (matcher.find()) {
                return true;
            }
        }
        return new File(dir, name).isDirectory();
    }

}
