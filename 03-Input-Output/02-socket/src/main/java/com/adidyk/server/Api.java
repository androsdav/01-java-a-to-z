package com.adidyk.server;

import java.io.File;

public class Api {

    // Comment
    // 1. wayAll do not have root directory, maybe must add root to wayAll in constructor
    //
    //
    private String[] listDir;
    private StringBuffer way;
    private String[] wayAll = new String[10];
    private int position = 0;
    private static final String SEPARATOR = System.getProperty("file.separator");

    public Api(StringBuffer root) {
        this.way = root;
    }

    // enterDir -
    public String[] enterDir(String dir) {
        this.wayAll[this.position] = SEPARATOR.concat(dir);
        this.position++;
     //   if (this.position == this.wayAll.length) {
     //      String[] wayAllTemp = new String[2 * this.wayAll.length];
     //       System.arraycopy(this.wayAll, 0, wayAllTemp, 0, this.wayAll.length);
     //       this.wayAll = wayAllTemp;
     //   }
        this.way = this.way.append(SEPARATOR).append(dir);
        File file = new File(String.valueOf(this.way));
        System.out.println(this.way);
        if (file.exists() && file.isDirectory()) {
            this.listDir = file.list();
        } else {
            System.out.println("Directory not found");
        }
        return this.listDir;
    }

    // exitDir -
    public String[] exitDir() {
        this.way = this.way.delete(this.way.indexOf(this.wayAll[--this.position]), this.way.length());
        File file = new File(String.valueOf(this.way));
        System.out.println(this.way);
        this.listDir = file.list();
            return this.listDir;
        }
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



