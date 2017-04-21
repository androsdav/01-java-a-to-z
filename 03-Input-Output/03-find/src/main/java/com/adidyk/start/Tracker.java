package com.adidyk.start;

import com.adidyk.exceptions.IncorrectInputPath;

import java.io.File;

public class Tracker {

    private String path;

    public String setPath(String path) throws IncorrectInputPath {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            this.path = path;
        } else {
            throw new IncorrectInputPath("Input path is false");
        }
        return path;
    }

    public void

    public String getPath() {
        return this.path;
    }


}
