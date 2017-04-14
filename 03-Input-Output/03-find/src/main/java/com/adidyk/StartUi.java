package com.adidyk;

public class StartUi {

    public static void main(String[] arg) {
        //System.out.println("Test, Hello Word");

        new Filter();
        Filter.init();
        Find find = new Find();
        find.find("root");
    }

}
