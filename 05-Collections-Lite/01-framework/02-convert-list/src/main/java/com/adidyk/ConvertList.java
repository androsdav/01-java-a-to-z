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
        int i = 0;
        int j = 0;
        for (Integer anList : list) {
            array[i][j] = anList;
            if (j < array[i].length - 1) {
                j++;
            } else {
                j = 0;
                if (i < rows) {i++;}
            }
        }
        return array;
    }

}