package com.adidyk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Class User for create user (object) with params: id, amount.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.01.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - just main.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        System.out.println("Hello world");
        System.out.println("UserStorage");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }
        System.out.println();
        Iterator it = list.iterator();
        list.add("false");
        System.out.println("");
        for (String anList : list) {
            System.out.println(anList);

        }
        System.out.println(it.hasNext());
        //System.out.println(it.next());
        /*
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        */
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.add("11");
        array.add("22");
        array.add("33");
        array.add("44");
        System.out.println("Collection SimpleArrayList");
        for (int index = 0; index < array.size(); index++) {
            System.out.println(array.get(index));
        }
        for (String anArray : array) {
            System.out.println(anArray);
        }
        Iterator it1 = array.iterator();
        array.add("55");
        System.out.println(it1.next());
    }

}