package com.adidyk;

import java.util.List;

public class StartUi {

    public static void main(String[] arg) {

        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7}
        };
        ConvertList convert = new ConvertList();
        List<Integer> list = convert.toList(array);
        for (Integer item : list) {
            System.out.println(item);
        }

        System.out.println();

        int[][] array1 = convert.toArray(list, 3);
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                System.out.print(array1[i][j] +" ");
            }
            System.out.println();
        }

    }

}

/*    private LinkedList<String> linkedList;
    private ArrayList<String> arrayList;
    private Set<String> treeSet;
    private Productivity product;
    private static final double TRANS = pow(10, 9);

    // Constructor
    private StartUi() {
        this.linkedList = new LinkedList<>();
        this.arrayList = new ArrayList<>();
        this.treeSet = new TreeSet<>();
        this.product = new Productivity();
    }

    // start - starts program
    private void start() {
        this.work();
    }

    // work - program is worked
    private void work() {
        int amountAdd = 500000;
        int amountInsert = 5000;
        int amountDelete = 5000;
        String stringAdd = "stringAdd";
        String stringInsert = "stringInsert";
        System.out.println("\n--------------------- LinkedList ---------------------\n");
        System.out.println("add:    " + this.product.add(this.linkedList, stringAdd, amountAdd) / TRANS + " [s]");
        System.out.println("insert: " + this.product.insert(this.linkedList, stringInsert, amountInsert) / TRANS + " [s]");
        System.out.println("delete: " + this.product.delete(this.linkedList, amountDelete) / TRANS + " [s]");
        System.out.println("\n--------------------- ArrayList ---------------------\n");
        System.out.println("add:    " + this.product.add(this.arrayList, stringAdd, amountAdd) / TRANS + " [s]");
        System.out.println("insert: " + this.product.insert(this.arrayList, stringInsert, amountInsert) / TRANS + " [s]");
        System.out.println("delete: " + this.product.delete(this.arrayList, amountDelete) / TRANS + " [s]");
        System.out.println("\n--------------------- TreeSet ---------------------\n");
        System.out.println("add:    " + this.product.add(this.treeSet, stringAdd, amountAdd) / TRANS + " [s]");
        System.out.println("delete: " + this.product.delete(this.treeSet, amountDelete) / TRANS + " [s]");
    }

    // main - just main ;)
    public static void main(String[] arg) {
        new StartUi().start();
    }

}*/
