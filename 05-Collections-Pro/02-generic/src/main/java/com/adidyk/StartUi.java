package com.adidyk;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {
        System.out.println("SimpleArray");

        SimpleArray<String> array = new SimpleArray<>();

        array.add("1");
        array.add("2");
        array.add("3");
        array.add("4");
        array.add("5");
        array.add("6");

        System.out.println("Add objects and print all object result:");
        for (Object object : array.getAllObject()) {
            System.out.println(object);
        }

        System.out.println("Delete object 4 and print all object result:");
        array.removeObjectByObject("4");

        for (Object object : array.getAllObject()) {
            System.out.println(object);
        }

        System.out.println("Add object and print all object result:");
        array.add("7");

        for (Object object : array.getAllObject()) {
            System.out.println(object);
        }

        System.out.println("Delete object by object and print all object result:");
        array.removeObjectByObject("4");

        for (Object object : array.getAllObject()) {
            System.out.println(object);
        }

        System.out.println("Delete object by index and print all object result:");
        array.removeObjectByIndex(20);
        for (Object object : array.getAllObject()) {
            System.out.println(object);
        }




    }

}