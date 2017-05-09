package com.adidyk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class StartUi {

    public static void main(String[] arg) {
        System.out.println("Test begin to start new project now !!!");
        System.out.println("Add new ");
        String line = "test line";
        int amount = 1000000;
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();

        TreeSet<String> treeSet = new TreeSet<>();
        TreeSet<String> treeSet1 = new TreeSet<>();

        Productivity product = new Productivity();
        System.out.println("ArrayList  :  " + product.add(arrayList, line, amount) + " [ns]");
        System.out.println("TreeSet    :  " + product.add(treeSet, line, amount) + " [ns]");
        System.out.println("TreeSet1:  :  " + product.add(treeSet1, line, amount) + " [ns]");
        System.out.println("ArrayList1 :  " + product.add(arrayList1, line, amount) + " [ns]");
        System.out.println("ArrayList2 :  " + product.add(arrayList2, line, amount) + " [ns]");
        System.out.println("ArrayList3 :  " + product.add(arrayList3, line, amount) + " [ns]");

        System.out.println("LinkedList :  " + product.add(linkedList, line, amount) + " [ns]");

        //System.out.println("TreeSet:  " + product.add(arrayList2, line, amount) + " [ns]");
        //System.out.println("TreeSet:  " + product.add(arrayList3, line, amount) + " [ns]");
        //System.out.println("LinkedList:  " + product.add(arrayList, line, amount) + " [ns]");
    }

}
