package com.adidyk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class StartUi {
    private LinkedList<String> linkedList;
    private ArrayList<String> arrayList;
    private TreeSet<String> treeSet;
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
        String string = this.input.ask("Input string: ");

        int amount = Integer.parseInt(this.input.ask("Input amount: "));

        System.out.println("LinkedList: " + this.product.add(this.linkedList, string, amount) + " [ns]");
        System.out.println("ArrayList:  " + this.product.add(this.arrayList, string, amount) + " [ns]");
        System.out.println("TreeSet:    " + this.product.add(this.treeSet, string, amount) + " [ns]");
    }

    public static void main(String[] arg) {
        Input input = new ConsoleInput();
        new StartUi(input).start();
    }

}
