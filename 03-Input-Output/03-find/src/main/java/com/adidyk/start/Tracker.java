package com.adidyk.start;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static com.adidyk.modeles.Constant.*;

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
    void save(String fileName) {
        if (fileName == null) {fileName = LOG;}
        if (this.result.size() != 0) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                System.out.println(" [Info]: saving to file, wait ...");
                for (String item : this.result) {
                    bw.write(item.concat(LINE_SEPARATOR));
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println( " [Info]: save is complete ...");
        } else {
            System.out.println(" [Info]: there is nothing to save ...");
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
