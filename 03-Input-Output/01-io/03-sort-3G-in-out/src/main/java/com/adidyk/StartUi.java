package com.adidyk;

import java.io.*;

public class StartUi {

    // main - just main
    public static void main(String[] args) throws IOException {
        SortFile sf = new SortFile();
        File source = new File("source.txt");
        File distance = new File("distance.txt");
        sf.sort(source, distance);
    }

}

