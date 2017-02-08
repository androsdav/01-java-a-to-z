package com.adidyk;

import java.io.File;

public class Api {

    private StringBuffer way;
    private static final String SEPARATOR = System.getProperty("file.separator");

    public Api(StringBuffer root) {
        this.way = root;
    }

    // enterDir -
    public String cdIn(String folder) throws NullPointerException {
        boolean dirFound = false;
        File file = new File(String.valueOf(this.way));
        for (String list : file.list()) {
            if (folder.equals(list)) {
                this.way = this.way.append(SEPARATOR).append(folder);
                dirFound = true;
                break;
            }
        }
        if (!dirFound) {
            System.out.println("Exception: -> Direct no found ");
        }
        return String.valueOf(this.way);
    }

    // exitDir -
    public String cdOut() {
        this.way = new StringBuffer(new File(String.valueOf(this.way)).getParent());
        return String.valueOf(this.way);
    }

    public String[] dir() {
        String[] listDir = null;
        File file = new File(String.valueOf(this.way));
        if (file.exists() && file.isDirectory()) {
            listDir = file.list();
        } else {
            System.out.println("Directory not found");
        }
        return listDir;
    }
}

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



