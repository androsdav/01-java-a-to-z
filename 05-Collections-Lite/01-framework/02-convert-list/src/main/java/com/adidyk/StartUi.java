package com.adidyk;

import java.util.*;
import static java.lang.Math.*;

public class StartUi {

    private LinkedList<String> linkedList;
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

}
