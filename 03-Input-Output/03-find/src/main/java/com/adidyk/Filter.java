package com.adidyk;

import java.io.File;
import java.io.FilenameFilter;

public class Filter {

    public static FilenameFilter filter;

    public static void init() {
        filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if ((dir.isFile() && name.equals("pom.txt")) || dir.isDirectory()) {
                    return true;
                } else {
                    return false;
                }
            }
        };
    }

}
