package com.adidyk;

import java.util.ArrayList;
import java.util.Arrays;
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

//------------------------------------------------------------------
   //     ArrayList<Iterator<Integer>> listAll = new ArrayList<>();
   //     listAll.add(it1);
   //     listAll.add(it2);
   //     listAll.add(it3);

        ConvertIteratorIterator iter = new ConvertIteratorIterator();
        Iterator<Integer> it = iter.convert((Arrays.asList(it1, it2, it3)).iterator());
/*
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.hasNext());
        System.out.println(it.hasNext());
*/
        while(it.hasNext()) {
            System.out.println(it.next());
        }


/*
        while (it.hasNext()) {
            System.out.println(it.next());
        }


/*
        for (Iterator<Integer> it : Arrays.asList(it1, it2, it3)) {
            while (it.hasNext()) {
                System.out.println(it.next());
            }

        }

//        ConvertIterator it = new ConvertIterator()



        /*
        for (Iterator<Integer> item : listAll) {
            System.out.println(item);
            while(item.hasNext()) {
                System.out.println(item.next());
            }
        }
*/
        //Iterator<Iterator<Integer>> itAll = listAll.iterator();

        //-------------------------------------------------------------------------
/*
        Iterator<Iterator<Integer>> itAll = Arrays.asList(it1, it2, it3).iterator();

        while (itAll.hasNext()) {
            while(itAll.next().hasNext()) {
                System.out.println(itAll.next().next());
            }
        }

        //-------------------------------------------------------------------------

        /*
        for (Iterator<Integer> integerIterator : Arrays.asList(it1, it2, it3)) {
            while(integerIterator.hasNext()) {
                System.out.println(integerIterator.next());
            }
        }



//        System.out.println(itAll.next());
//        System.out.println(itAll.next());
//        System.out.println(itAll.next());








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




