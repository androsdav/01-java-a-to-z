package com.adidyk;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        System.out.println("Convert List");
        return list;
    }
}
