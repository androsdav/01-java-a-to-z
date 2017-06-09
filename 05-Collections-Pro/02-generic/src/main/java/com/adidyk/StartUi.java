package com.adidyk;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {
        System.out.println("SimpleArray");

        SimpleArray<String> array = new SimpleArray<>();
        String string = array.add("first-string");
        System.out.println(string);
    }

}