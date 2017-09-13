package com.adidyk;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class "StartUi" for create Map and puts key = user and value = new Object().
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - is only for create jar file.
     * @param arg nothing.
     */
    public static void main(String[] arg) {
        System.out.println("SimpleHashMap");
        System.out.println("Tree");
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        TreeSet<Integer> set = new TreeSet<>();
    }

}