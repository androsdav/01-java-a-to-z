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
        IteratorEvenArray it2 = new IteratorEvenArray(new int[]{2, 3, 4, 1, 3, 6, 5, 7, 8, 7, 10, 1, 12, 3, 14, 1, 16, 1, 18, 20, 22, 24, 23, 26, 1092, 1});
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        System.out.println("IteratorPrimeArray");
        IteratorPrimeArray it3 = new IteratorPrimeArray(new int[]{1, 2, 4, 5, 6, 8, 17, 31, 51, 61, 32, 18, 71, 131, 132});
        while(it3.hasNext()) {
            System.out.println(it3.next());
        }
    }

}