package com.adidyk;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] anArray : array) {
            for (int anAnArray : anArray) {
                list.add(anAnArray);
            }
        }
        return list;
    }

    public int[][] toArray(List<Integer> list, int rows) {
        //int i = rows;
        //int j = list.size() / rows;
        int array[][] = new int[rows][list.size() / rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < list.size() / rows; j++) {
                array[i][j] = list.get(index);
                index++;
            }
        }
        return array;
    }


}
