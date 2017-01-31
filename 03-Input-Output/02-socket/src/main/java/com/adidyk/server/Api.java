package com.adidyk.server;

import java.io.File;

public class Api {

    public String[] showDir(String dir) {
        File file = new File(dir);
        String[] list = null;

        if (file.exists() && file.isDirectory()) {
            list = file.list();
        } else {
            System.out.println("Directory not found");
        }
        return list;
    }

    public File[] showFile(String dir) {
        File file = new File(dir);
        File[] list = null;

        if(file.exists() && file.isDirectory()) {
            list = file.listFiles();
        } else {
            System.out.println("Directory not found");
        }
        return list;
    }

        //if (file.isDirectory()) {
        //    for (File item : file.listFiles()) {
        //        System.out.println("Katalog:  " + item);

//            }
  //      }

        //System.out.println("1. getAbsolutePath :" + file.getAbsolutePath());
        //System.out.println("2. getAbsoluteFile :" + file.getAbsoluteFile());
        //System.out.println("3. getParent :" + file.getParent());
        //System.out.println("1. getAbsolutePath :" + file.getAbsolutePath());
        //System.out.println("1. getAbsolutePath :" + file.getAbsolutePath());
        //System.out.println("1. getAbsolutePath :" + file.getAbsolutePath());
    }


