package com.adidyk.server;

import java.io.File;
import java.util.Properties;

public class Api {

    public String[] subDir;
    public String way;

    public Api(String way) {
        this.way = way;
    }

    Properties prop = System.getProperties();
    String separator = prop.getProperty("file.separator");

    public String[] enterDir(String dir) {
        this.way = this.way.concat(this.separator).concat(dir);
        File file = new File(way);
        System.out.println(way);
        if (file.exists() && file.isDirectory()) {
            this.subDir = file.list();
//            this.way = file.getPath();
        } else {
            System.out.println("Directory not found");
        }
        //System.out.println("Way temp: " + way);
        //System.out.println("getParent: " + file.getParent());
        //System.out.println("Path :" +file.getAbsolutePath());
        //System.out.println("HZ1 :" +file.getAbsoluteFile());
 //       System.out.println("HZ2 :" +this.way);
        return this.subDir;
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


