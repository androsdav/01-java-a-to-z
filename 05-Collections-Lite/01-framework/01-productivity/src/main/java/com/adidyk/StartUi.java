package com.adidyk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.Math.pow;

public class StartUi {

    private ArrayList<String> warmUpArrayList;
    private LinkedList<String> warmUpLinkedList;
    private TreeSet<String> warmUpTreeSet;

    private LinkedList<String> linkedList;
    private ArrayList<String> arrayList;
    private Set<String> treeSet;
    private Productivity product;
    private Input input;

    private StartUi(Input input) {
        //this.input = input;

        this.warmUpArrayList = new ArrayList<>();
        this.warmUpLinkedList = new LinkedList<>();
        this.warmUpTreeSet = new TreeSet<>();

        this.linkedList = new LinkedList<>();
        this.arrayList = new ArrayList<>();
        this.treeSet = new TreeSet<>();
        this.product = new Productivity();
    }

    private void start() {
        this.work();
    }

    private void work() {

        int amountAdd = 500000;
        int amountInsert = 5000;
        int amountDelete = 5000;

        String stringAdd = "stringAdd";
        String stringInsert = "stringInsert";

        System.out.println("---------------------ArrayList add");
        System.out.println("ArrayList add:  " + (double)this.product.add(this.arrayList, stringAdd, amountAdd) / pow(10, 9) + " [s]");
        System.out.println("---------------------ArrayList insert");
        System.out.println("ArrayList insert: " + (double)this.product.insert(this.arrayList, stringInsert, amountInsert) / pow(10, 9) + " [s]");
        System.out.println("---------------------ArrayList delete");
        System.out.println("ArrayList delete: " + (float)this.product.delete(this.arrayList, amountDelete) / pow(10, 9) + " [s]");

        System.out.println("---------------------LinkedList add");
        System.out.println("ArrayList add:  " + (double)this.product.add(this.linkedList, stringAdd, amountAdd) / pow(10, 9) + " [s]");
        System.out.println("---------------------LinkedList insert");
        System.out.println("ArrayList insert: " + (double)this.product.insert(this.linkedList, stringInsert, amountInsert) / pow(10, 9) + " [s]");
        System.out.println("---------------------LinkedList delete");
        System.out.println("ArrayList delete: " + (float)this.product.delete(this.linkedList, amountDelete) / pow(10, 9) + " [s]");



        //System.out.println(product.randomString());

//        int amount = Integer.parseInt(this.input.ask("Input amount: "));

//        System.out.println("warm - Up LinkedList:  " + (float) this.product.add(this.warmUpLinkedList, string, amount) + " [ns]");
   //     System.out.println("        TreeSet:    " + (float) this.product.add(this.treeSet, string, amount) + " [ns]");
   //     System.out.println("        ArrayList:  " + (float) this.product.add(this.arrayList, string, amount) + " [ns]");
   //     System.out.println("        LinkedList: " + (float) this.product.add(this.linkedList, string, amount) + " [ns]");

//        System.out.println("warm - Up ArrayList:  " + (float) this.product.add(this.warmUpArrayList, string, amount) + " [ns]");
//        System.out.println("        ArrayList:  " + (float) this.product.add(this.arrayList, string, amount) + " [ns]");

//        System.out.println("warm - Up TreeSet: " + (float) this.product.add(this.warmUpTreeSet, string, amount) + " [ns]");
//        System.out.println("        TreeSet:    " + (float) this.product.add(this.treeSet, string, amount) + " [ns]");

   //     System.out.println();
        //      for (String item : this.arrayList) {
        //          System.out.println(item);
        //      }

        //     System.out.println();
        //      for (String item : this.linkedList) {
        //         System.out.println(item);
        //      }

        //     System.out.println();
        //     for (String item : this.treeSet) {
        //         System.out.println(item);
        //    }

   //     int amount1 = 50;
//        System.out.println("ArrayList:  " + (float) this.product.delete(this.arrayList, amount1) + " [ns]");
//        System.out.println("LinkedList: " + (float) this.product.delete(this.linkedList, amount1) + " [ns]");
//        System.out.println("ArrayList:  " + (float) this.product.delete(this.arrayList, amount1) + " [ns]");
//        System.out.println("TreeSet:    " + (float) this.product.delete(this.treeSet, amount1) + " [ns]");


       // System.out.println("---------------------ArrayList");
       // for (String item : this.arrayList) {
        //    System.out.println(item);
       // }

//        System.out.println("---------------------LinkedId");
  //      for (String item : this.linkedList) {
    //        System.out.println(item);
      //  }

        //System.out.println("---------------------TreeSet");
        //for (String item : this.treeSet) {
        //    System.out.println(item);
        //}
    }
    public static void main(String[] arg) {
        Input input = new ConsoleInput();
        new StartUi(input).start();
    }

}
