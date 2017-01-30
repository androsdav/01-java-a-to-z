package com.adidyk.server;

import java.io.File;

public class Api {

    public void test(String string) {
        File file = new File(string);

        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                System.out.println("Katalog:  " + item);

            }
        }

        //System.out.println("1. getAbsolutePath :" + file.getAbsolutePath());
        //System.out.println("2. getAbsoluteFile :" + file.getAbsoluteFile());
        //System.out.println("3. getParent :" + file.getParent());
        //System.out.println("1. getAbsolutePath :" + file.getAbsolutePath());
        //System.out.println("1. getAbsolutePath :" + file.getAbsolutePath());
        //System.out.println("1. getAbsolutePath :" + file.getAbsolutePath());
    }

}
