package com.adidyk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {

        System.out.println("Iterators");
        System.out.println();


        //list1 it1
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Iterator<Integer> it1 = list1.iterator();

        //list2 it2
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        Iterator<Integer> it2 = list2.iterator();

        //list3 it3
        List<Integer> list3 = new ArrayList<>();
        list3.add(8);
        list3.add(9);
        list3.add(10);
        list3.add(11);
        list3.add(12);
        Iterator<Integer> it3 = list3.iterator();

        //listAll
        List<Integer> listAll = new ArrayList<>();

        while(it1.hasNext()) {
            System.out.println(it1.next());
        }

        while(it2.hasNext()) {
            System.out.println(it2.next());
        }

        while(it3.hasNext()) {
            System.out.println(it3.next());
        }



    }

}




