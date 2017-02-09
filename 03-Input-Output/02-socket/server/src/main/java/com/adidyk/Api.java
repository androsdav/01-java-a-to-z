package com.adidyk;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Api {

    private StringBuffer way;
    private static final String SEPARATOR = System.getProperty("file.separator");

    public Map<String, Api> actions = new HashMap<String, Api>();

    public fillAction() {
        actions.put("cd", new Api());

    }

    public Api(StringBuffer root) {
        this.way = root;
    }

    // enterDir -
    private class inputToDir {
        public String execute(String dir) throws NullPointerException {
            boolean dirFound = false;
            File file = new File(String.valueOf(way));
            for (String list : file.list()) {
                if (dir.equals(list)) {
                    way = way.append(SEPARATOR).append(dir);
                    dirFound = true;
                    break;
                }
            }
            if (!dirFound) {
                System.out.println("Exception: -> Direct no found ");
            }
            return String.valueOf(way);
        }
    }

    // exitDir -
    private class outputFromDir {
        public String execute() {
            way = new StringBuffer(new File(String.valueOf(way)).getParent());
            return String.valueOf(way);
        }

        public String[] showDir() {
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



