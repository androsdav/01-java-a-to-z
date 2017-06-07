package com.adidyk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.function.Consumer;

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

        System.out.println("Iterator1");
        while(it1.hasNext()) {
            System.out.println(it1.next());
        }

        System.out.println("Iterator2");
        while(it2.hasNext()) {
            System.out.println(it2.next());
        }

        System.out.println("Iterator3");
        while(it3.hasNext()) {
            System.out.println(it3.next());
        }

        ArrayList<Iterator<Integer>> listTemp = new ArrayList<>();
        listTemp.add(it1);
        listTemp.add(it2);
        listTemp.add(it3);

        Iterator<Iterator<Integer>> iterator = listTemp.iterator();

        /*
        while(itAll.hasNext()) {
            System.out.println(itAll.next());

        }

*/
        System.out.println("Iterator iterator");
        for (Iterator<Integer> aListTemp : iterator) {
            while (aListTemp.hasNext()) {
                System.out.println(aListTemp.next());
            }
        }







       // Iterator<Iterator<Integer>> itAll = new Iteartor<>(it1, it2, it3);


        /*
        Iterator <Iterator<Integer>> itAll = new Iterator<Iterator<Integer>>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Iterator<Integer> next() {
                return null;
            }

            @Override
            public void remove() {

            }

            @Override
            public void forEachRemaining(Consumer<? super Iterator<Integer>> action) {

            }
        };


*/
    }

}




