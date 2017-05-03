package com.adidyk.start;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    // save - saves result to file to root directory

    void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt"))) {
            for (String item : this.result) {
                bw.write(item.concat(System.lineSeparator()));
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // remove - removes result searches
    void remove() {
        this.result.clear();
    }

    // getPath - returns path
    String getPath() {
        return this.path;
    }

    // getResult - returns result searches
    ArrayList<String> getResult() {
        return this.result;
    }

}
