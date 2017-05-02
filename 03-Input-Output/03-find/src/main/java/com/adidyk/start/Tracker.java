package com.adidyk.start;

import com.adidyk.exceptions.IncorrectInputPath;

import java.io.File;
import java.util.ArrayList;

public class Tracker {

    private String path = null;
    private ArrayList<String> result = new ArrayList<>();

    // setPath -
    public String setPath(String path) throws IncorrectInputPath {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            this.path = path;
        } else {
            //throw new IncorrectInputPath("Input path is false");
            System.out.println(" [Info]: Input path is false");
        }
        return path;
    }

    // find - find all files thatn is true config search
    public ArrayList<String> find(String path, Filter filter) {
        File file = new File(path);
        File[] items = file.listFiles(filter);
        if (items != null) {
            for (File item : items) {
                if (item.isDirectory()) {
                    find(item.getPath(), filter);
                    //System.out.println("dir:" +item.getPath());
                } else if (item.isFile()) {
                    System.out.println("file: " +item.getPath());
                    this.result.add(item.getPath());
                }
            }
        }
        return this.result;
    }

    public void remove() {
        this.result.clear();
    }

    // getPath -
    public String getPath() {
        return this.path;
    }

    // getResult -
    public ArrayList<String> getResult() {
        return this.result;
    }


}
