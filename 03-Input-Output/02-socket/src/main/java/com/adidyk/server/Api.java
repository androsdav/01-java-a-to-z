package com.adidyk.server;

import java.io.File;
import java.util.Properties;

public class Api {

    public String[] subDir;
    public StringBuffer way;
    public String[] wayAll = new String[10];
    public int index = 0;


    public Api(StringBuffer way) {
        this.way = way;
    }

    Properties prop = System.getProperties();
    String separator = prop.getProperty("file.separator");

    public String[] enterDir(String dir) {
        this.wayAll[this.index] = this.separator.concat(dir);
        index++;
        this.way = this.way.append(this.separator).append(dir);
        File file = new File(String.valueOf(way));
        System.out.println(this.way);
        if (file.exists() && file.isDirectory()) {
            this.subDir = file.list();
//            this.way = file.getPath();
        } else {
            System.out.println("Directory not found");
        }

        return this.subDir;
    }

    public String[] exitDir() {
        this.way = this.way.delete(this.way.indexOf(this.wayAll[--this.index]), this.way.length());
        File file = new File(String.valueOf(way));
        System.out.println(this.way);
        this.subDir = file.list();
        return this.subDir;
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
    //System.out.println("Way temp: " + way);
    //System.out.println("getParent: " + file.getParent());
    //System.out.println("Path :" +file.getAbsolutePath());
    //System.out.println("HZ1 :" +file.getAbsoluteFile());
    //       System.out.println("HZ2 :" +this.way);
    }


