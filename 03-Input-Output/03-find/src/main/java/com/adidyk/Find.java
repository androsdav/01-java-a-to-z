package com.adidyk;

import java.io.File;

public class Find {

    private Input input;

    private Find(Input input) {
        this.input = input;
    }

    public void find(String root, String mask) {
        File file = new File(root);
        if (file.exists() && file.isDirectory()) {
            File[] items = file.listFiles(new Filter(mask));
            if (items != null) {
                for (File item : items) {
                    if (item.isDirectory()) {
                        find(item.getParent(), mask);

                    }
                }
            }

        } else {
            System.out.println("Directory not found");
        }


        //String name = "pom.txt";
        boolean findTrue = false;

        File[] items = file.listFiles(new Filter("2"));
        if (items != null) {
            for (File item : items) {
                if (item.isDirectory()) {
                    find(item.getPath());
                } else if (item.isFile()) {
                    //if (name.equals(item.getName())) {
                        //findTrue = true;
                        System.out.println(item.getPath());
                    }
                }
            //}
        }
    }
}
