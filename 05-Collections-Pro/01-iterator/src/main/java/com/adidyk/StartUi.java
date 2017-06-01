package com.adidyk;

import java.util.Iterator;

public class StartUi {

    public static void main(String[] args) {
        System.out.println("Test output word");

        Iterator it = new IteratorEvenArray(new int[]{88, 7, 4, 3, 6, 4, 8, 9, 7, 3});

        while(it.hasNext()) {
            System.out.println(it.next());
        }

      /*  System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());*/
        //System.out.println(it.next());

        //Iterator<Integer> it = new Iterator();


       /* IteratorArray it = new IteratorArray(new int[]{1, 2, 35, 36, 23 , 23, 23, 1, 123, 452});

        while(it.hasNext()) {
            System.out.println(it.next());
        }*/

        /*
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.hasNext());
        */
/*
        IteratorDoubleArray iter = new IteratorDoubleArray(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());

        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());

        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());


        System.out.println(10%5);

       /* while(iter.hasNext()) {
            System.out.println(iter.next());
        }*/
        /*
        System.out.println(iter.hasNext());
        System.out.println(iter.next());

        System.out.println(iter.hasNext());
        System.out.println(iter.next());

        System.out.println(iter.hasNext());
        System.out.println(iter.next());

        System.out.println(iter.hasNext());
        System.out.println(iter.next());
*/
    }
}
