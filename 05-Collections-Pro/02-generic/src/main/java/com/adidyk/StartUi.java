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

        //------------------------------
        System.out.println("Add objects and Get all object: ");
        System.out.println(array);
        System.out.println();

        //------------------------------
        System.out.println("Remove object <4> and Get all object:");
        array.remove("4");
        System.out.println(array);
        System.out.println();

        //------------------------------
        System.out.println("Add object <7> and Get all object: ");
        array.add("7");
        System.out.println(array);
        System.out.println();



        //------------------------------
        System.out.println("Delete object by index <4> and Get all object:");
        array.remove(1);
        System.out.println(array);
        System.out.println();

        //------------------------------
        System.out.println();
        System.out.println("Add object and Get all object:");

        array.add(4, "8");
        System.out.println(array);

        array.add(4, "9");
        System.out.println(array);

        array.add(4, "10");
        System.out.println(array);

        array.add(4, "11");
        System.out.println(array);

        array.add(8, "test");
        System.out.println(array);

        array.add(0, "test1");
        System.out.println(array);

        array.add("testEnd");
        System.out.println(array);

        array.remove("test1");
        System.out.println(array);

        array.add(11, "testTest");
        System.out.println(array);

        //------------------------------
        System.out.println("Add object <test> by index <4> and Get all object:");
        array.add(4, "test");
        System.out.println("size: " + array.size());
        System.out.println(array);
        System.out.println();

/*

        System.out.println();
        System.out.println("Test method add by index");
        List<String> list = new ArrayList<>();
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");

        for(String item : list) {
            System.out.println(item);
        }

        list.add(1, "test");

        System.out.println("Add by index");
        for(String item : list) {
            System.out.println(item);
        }







*/



    }

}