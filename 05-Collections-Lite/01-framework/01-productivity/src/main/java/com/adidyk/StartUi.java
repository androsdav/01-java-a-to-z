package com.adidyk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class StartUi {
    private LinkedList<String> linkedList;
    private ArrayList<String> arrayList;
    private Set<String> treeSet;
    private Productivity product;
    private Input input;

    private StartUi(Input input) {
        this.input = input;
        this.linkedList = new LinkedList<>();
        this.arrayList = new ArrayList<>();
        this.treeSet = new TreeSet<>();
        this.product = new Productivity();
    }

    private void start() {
        this.work();
    }

    private void work() {
       // String string = this.input.ask("Input string: ");
        String string = "testString";

        int amount = Integer.parseInt(this.input.ask("Input amount: "));

        System.out.println("LinkedList: " + (float)this.product.add(this.linkedList, string, amount) + " [ns]");
        System.out.println("ArrayList:  " + (float)this.product.add(this.arrayList, string, amount) + " [ns]");
        System.out.println("TreeSet:    " + (float)this.product.add(this.treeSet, string, amount) + " [ns]");

        System.out.println();
        for (String item : this.arrayList) {
            System.out.println(item);
        }

        System.out.println();
        for (String item : this.linkedList) {
            System.out.println(item);
        }

        System.out.println();
        for (String item : this.treeSet) {
            System.out.println(item);
        }

        System.out.println("LinkedList: " + (float)this.product.delete(this.linkedList, amount / 2) + " [ns]");
        System.out.println("ArrayList:  " + (float)this.product.delete(this.arrayList, amount / 2) + " [ns]");
        System.out.println("TreeSet:    " + (float)this.product.delete(this.treeSet, amount / 2 ) + " [ns]");
    }

    public static void main(String[] arg) {
        Input input = new ConsoleInput();
        new StartUi(input).start();
    }

}
