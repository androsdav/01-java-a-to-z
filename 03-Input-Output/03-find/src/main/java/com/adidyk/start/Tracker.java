package com.adidyk.start;

import java.io.File;
import java.util.ArrayList;

class Tracker {

    private String path = null;
    private ArrayList<String> result = new ArrayList<>();

    // setPath - sets this.path if path is true
    String setPath(String path) {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            this.path = path;
        } else {
            System.out.println(" [Info]: entered path false ...");
        }
        return path;
    }

    // find - finds all files in folder and writes to this.result
    ArrayList<String> find(String path, Filter filter) {
        File file = new File(path);
        File[] items = file.listFiles(filter);
        if (items != null) {
            for (File item : items) {
                if (item.isDirectory()) {
                    find(item.getPath(), filter);
                } else if (item.isFile()) {
                    this.result.add(item.getPath());
                }
            }
        }
        return this.result;
    }

    void remove() {
        this.result.clear();
    }

    // getPath -
    String getPath() {
        return this.path;
    }

    // getResult -
    ArrayList<String> getResult() {
        return this.result;
    }


}
