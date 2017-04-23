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
            throw new IncorrectInputPath("Input path is false");
        }
        return path;
    }

    // find - find all files that is true config search
    public ArrayList<String> find(String nameFile, String keyFind) {
        File file = new File(this.path);
        File[] items = file.listFiles();
        if (items != null) {
            for (File item : items) {
                if (item.isDirectory()) {
                    find(item.getParent(), keyFind);
                } else if (item.isFile()) {
                    this.result.add(item.getPath());
                }
            }
        }
        return this.result;
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
