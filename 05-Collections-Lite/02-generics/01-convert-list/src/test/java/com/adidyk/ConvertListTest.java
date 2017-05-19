package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    private final int[][] arrayActualFirst = new int[][]{{1, 2, 3},{4, 5, 6},{7}};
    private final int[][] arrayActualSecond = new int[][]{{1, 2, 3},{4, 5, 6},{7, 0, 0}};
    private final ConvertList convert = new ConvertList();
    private final ArrayList<Integer> listActual = new ArrayList<>();

    @Before
    public void init() {
        this.listActual.add(1);
        this.listActual.add(2);
        this.listActual.add(3);
        this.listActual.add(4);
        this.listActual.add(5);
        this.listActual.add(6);
        this.listActual.add(7);
    }

    @Test
    public void toListTest() {
        List<Integer> listExpected = this.convert.toList(this.arrayActualFirst);
        assertThat(this.listActual, is(listExpected));
    }

    @Test
    public void toArrayTest() {
        int rows = 3;
        int [][] arrayExpected = this.convert.toArray(this.listActual, rows);
        assertThat(this.arrayActualSecond, is(arrayExpected));
    }

}