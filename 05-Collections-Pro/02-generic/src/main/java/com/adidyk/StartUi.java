package com.adidyk;

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

        /*
        for (int index = 0; index < array.size(); index++) {
            System.out.println(array.getAllObject());
        }
        */

        //------------------------------
        System.out.println("Add objects and Get all object: ");
        for (Object object : array.getAllObject()) {
            System.out.println(object);
        }
        System.out.println("size: " + array.size());

        //------------------------------
        System.out.println("Delete object <4> and Get all object:");
        array.remove("4");
        for (Object object : array.getAllObject()) {
            System.out.println(object);
        }
        System.out.println("size: " + array.size());

        //------------------------------
        System.out.println("Add object <7> and Get all object: ");
        array.add("7");
        for (Object object : array.getAllObject()) {
            System.out.println(object);
        }
        System.out.println("size: " + array.size());

        //------------------------------
        System.out.println("Delete object by index <4> and Get all object:");
        array.remove(4);
        for (Object object : array.getAllObject()) {
            System.out.println(object);
        }
        System.out.println("size: " + array.size());

/*
        System.out.println();
        System.out.println("Its little example for use Collections....  ");
        System.out.println();
/*
        List<String> list = new ArrayList<>(5);

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        for (String item : list) {
            System.out.println(item);
        }

        list.remove("5");

        System.out.println("List size: " +list.size());






*/
    }

}