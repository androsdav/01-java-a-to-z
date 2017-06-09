package com.adidyk;

import java.util.ArrayList;
import java.util.List;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {

        //------------------------------
        System.out.println("SimpleArray");
        SimpleArray<String> array = new SimpleArray<>();
        System.out.println("size: " + array.size());
        array.add("1");
        array.add("2");
        array.add("3");
        array.add("4");
        array.add("5");
        array.add("6");

        //------------------------------
        System.out.println("Get object by index and used loop for: ");
        for (int index = 0; index < array.size(); index++) {
            System.out.println(array.get(index));
        }

        //------------------------------
        System.out.println("Add objects and Get all object: ");
        for (Object object : array.getAll()) {
            System.out.println(object);
        }
        System.out.println("size: " + array.size());

        //------------------------------
        System.out.println("Delete object <4> and Get all object:");
        array.remove("4");
        for (Object object : array.getAll()) {
            System.out.println(object);
        }
        System.out.println("size: " + array.size());

        //------------------------------
        System.out.println("Add object <7> and Get all object: ");
        array.add("7");
        for (Object object : array.getAll()) {
            System.out.println(object);
        }
        System.out.println("size: " + array.size());

        //------------------------------
        System.out.println("Delete object by index <4> and Get all object:");
        array.remove(4);
        for (Object object : array.getAll()) {
            System.out.println(object);
        }
        System.out.println("size: " + array.size());
        System.out.println();
        System.out.println(array);


        System.out.println();
        System.out.println("Its little example for use Collections....  ");
        System.out.println();

        List<String> list = new ArrayList<>(5);

        list.add("2");
        list.add("2");
        list.add("3");
        list.add("4");
/*
        for (String item : list) {
            System.out.println(item);
        }

        list.remove("5");

        System.out.println("List size: " +list.size());






*/
    }

}