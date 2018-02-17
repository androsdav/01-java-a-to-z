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
        List<String> list = new ArrayList<String>();
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
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}