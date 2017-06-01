package com.adidyk;

public class StartUi {

    public static void main(String[] arg) {

        System.out.println("IteratorArray");
        IteratorArray it = new IteratorArray(new int[]{1, 3, 4, 5, 6});
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("IteratorDoubleArray");
        IteratorDoubleArray it1 = new IteratorDoubleArray(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        System.out.println("IteratorEvenArray");
        IteratorEvenArray it2 = new IteratorEvenArray(new int[]{1, 3, 4, 5, 6, 7, 8, 1, 3, 5});
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }

}