package com.adidyk.server;

import java.io.File;

public class Api {

    private String[] subDir;
    private StringBuffer way;
    private String[] wayAll = new String[10];
    private int position = 0;
    private static final String SEPARATOR = System.getProperty(("file.separator"));

    public Api(StringBuffer way) {
        this.way = way;
    }

    // enterDir -
    public String[] enterDir(String dir) {
        this.wayAll[this.position] = SEPARATOR.concat(dir);
        this.position++;
        this.way = this.way.append(SEPARATOR).append(dir);
        File file = new File(String.valueOf(this.way));
        System.out.println(this.way);
        if (file.exists() && file.isDirectory()) {
            this.subDir = file.list();
        } else {
            System.out.println("Directory not found");
        }

      //  for (String hight : wayAll) {
       //     if (hight != null) {
       //         System.out.print(hight);
       //     }
       /// } System.out.println();

        return this.subDir;
    }

    // exitDir -
    public String[] exitDir() {
        this.way = this.way.delete(this.way.indexOf(this.wayAll[--this.position]), this.way.length());
        File file = new File(String.valueOf(this.way));
        System.out.println(this.way);
        this.subDir = file.list();

      //  for (String hight : wayAll) {
      //      if (hight != null) {
      //          System.out.print(hight);
      //      }

     //   } System.out.println();

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


