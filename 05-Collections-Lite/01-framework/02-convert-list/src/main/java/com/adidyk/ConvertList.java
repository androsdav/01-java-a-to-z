package com.adidyk;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.ceil;

public class ConvertList {

    // toList - converts [][] array to list collection
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] anArray : array) {
            for (int anAnArray : anArray) {
                list.add(anAnArray);
            }
        }
        return list;
    }

    // toArray - converts list collection  to [][] array
    public int[][] toArray(List<Integer> list, int rows) {
        int array[][] = new int[rows][(int)ceil((double)list.size() / rows)];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (index < list.size()) {
                    array[i][j] = list.get(index);
                } else {
                    array[i][j] = 0;
                }
                index++;
            }
        }
        return array;
    }


}
