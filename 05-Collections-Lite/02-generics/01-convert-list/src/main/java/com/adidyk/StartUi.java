package com.adidyk;

import java.util.ArrayList;

public class StartUi {

    public static void main(String[] arg) {
        System.out.println("ConvertList");

        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 11});
        list.add(new int[]{5, 7, 8, 10});

        ConvertList con = new ConvertList();
        ArrayList<Integer> result = (ArrayList<Integer>) con.convert(list);
        for (Integer item : result) {
            System.out.println(item);
        }
    }

}