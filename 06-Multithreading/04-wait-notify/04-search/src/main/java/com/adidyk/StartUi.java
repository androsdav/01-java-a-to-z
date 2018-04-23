package com.adidyk;

import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;
//import java.nio.file.attribute.BasicFileAttributes;

/** Class StartUi for create jar file and run program (Locker).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.04.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - runs program, creates three thread: one thread of class MyThreadFirst and two thread
     * of class MyThreadSecond.
     * @param arg - is nothing.
     * @throws InterruptedException - is interrupted exception.
     * @throws IOException - is interrupted exception.
     */
    public static void main(String[] arg) throws InterruptedException, IOException {
        System.out.println();
        System.out.println(" Searches ...");
        System.out.println();
        String root = "root";
        String text = "glob:*.java";
        List<String> extensions = new ArrayList<>();
        extensions.add("txt");
        ParallelSearch parallelSearch = new ParallelSearch(root, text, extensions);
        parallelSearch.init();

        //Path path = Paths.get("D:\\Books\\Kapital\\cover.jpg");
        //System.out.println("0. path:" + path);
        //System.out.println("1. getFileName:" + path.getFileName());
        //System.out.println("2. getNameCount:" + path.getNameCount());
        //System.out.println("3. getName:" + path.getName(2));
        //System.out.println("3. getName:" + path.getName(2));
        //String string = "test";
        //Path test = Paths.get(string);

        /*
        try {
            Files.walkFileTree(path, new MyFileVisitor());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        */
        /*
        List<String> extension = new ArrayList<>();
        extension.add("txt");
        ParallelSearch parallelSearch = new ParallelSearch(String.valueOf(path), "test", extension);
        parallelSearch.init();

        //BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        //visitor.visitFile(file, attr);
        /*
        Counter counter = new Counter();
        counter.addCounter();
        counter.addCounter();
        counter.addCounter();
        System.out.println();
        System.out.println(" result: " + counter.getCounter());
        */
    }

}