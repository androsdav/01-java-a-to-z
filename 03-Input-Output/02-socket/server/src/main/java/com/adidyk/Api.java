package com.adidyk;

import java.io.File;
import java.util.Arrays;

public class Api {

    private StringBuffer way;
    private static final String SEPARATOR = System.getProperty("file.separator");
    public static final String ROOT = "root";
    public static final String FROM = "..";

    //public Map<String, UserAction> actions = new HashMap<String, Api>();

    Api(StringBuffer root) {
        this.way = root;
    }

    // changeDir - change folder: input one step, output one step, output to root directory
    public String changeDir(String dir) throws NullPointerException {

        if (dir == null) {
            this.way = new StringBuffer(ROOT);
        }
        else if (FROM.equals(dir)) {
            this.way = new StringBuffer(new File(String.valueOf(this.way)).getParent());
        } else {
            File file = new File(String.valueOf(this.way));
            boolean dirFound = false;
            for (String list : file.list()) {
                if (dir.equals(list)) {
                    this.way = this.way.append(SEPARATOR).append(dir);
                    dirFound = true;
                    break;
                }
            }
            if (!dirFound) {
                System.out.println("Exception: -> Direct no found ");
            }
        }
            return String.valueOf(this.way);
        }

    // showDir - return all folders and files that are in folder
    public String showDir() {
        String[] listDir = null;
        File file = new File(String.valueOf(way));
        if (file.exists() && file.isDirectory()) {
            listDir = file.list();
        } else {
                System.out.println("Directory not found");
        }
        return Arrays.toString(listDir);
    }
}


// exitDir -
//    public String outputFromDir(String dir) {
//        if ("..".equals(dir)) {
//            this.way = new StringBuffer(new File(String.valueOf(this.way)).getParent());
//        } else
//        if (dir == null) {
//            this.way = new StringBuffer();
//        }

//       return String.valueOf(way);
//   }

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
        //System.out.println("HZ2 :" +this.way);



