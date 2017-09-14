package com.adidyk;

import java.util.Map;
import java.util.TreeMap;

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
        TreeMap<String, String> tree = new TreeMap<>();
        tree.put("BOB1", "Madly1");
        tree.put("BOB2", "Madly2");
        tree.put("BOB3", "Madly3");
        System.out.println(tree);

        for (Map.Entry<String, String> item : tree.entrySet()) {
            System.out.println("key: " + item.getKey() +  " value: " + item.getValue());
        }
    }

}