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
    private final ConvertList con = new ConvertList();
    private final List<Integer> listActual = new ArrayList<>();

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
        List<Integer> listExpected = this.con.toList(this.arrayActualFirst);
        assertThat(this.listActual, is(listExpected));
    }

    @Test
    public void toArrayTest() {
        int rows = 3;
        int [][] arrayExpected = this.con.toArray(this.listActual, rows);
        assertThat(this.arrayActualSecond, is(arrayExpected));
    }

    @Test
    public void convertTest() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3});
        list.add(new int[]{4});
        list.add(new int[]{5, 6});
        list.add(new int[]{7});
        List<Integer> listExpected = this.con.convert(list);
        assertThat(this.listActual, is(listExpected));
    }

}