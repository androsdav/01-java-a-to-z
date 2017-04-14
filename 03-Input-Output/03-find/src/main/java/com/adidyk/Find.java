package com.adidyk;

import java.io.File;

public class Find {

    public void find(String root) {
        String name = "pom.txt";
        File file = new File(root);
        boolean findTrue = false;
        File[] items = file.listFiles();
        if (items != null) {
            for (File item : items) {
                if (item.isDirectory()) {
                    find(item.getPath());
                } else if (item.isFile()) {
                    if (name.equals(item.getName())) {
                        //findTrue = true;
                        System.out.println(item.getPath());
                    }
                }
            }
        }
    }
}
