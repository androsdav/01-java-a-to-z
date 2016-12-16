package com.adidyk;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KnightTest {

    @Test
    public void wayTest() {
        Cell[] highway = {new Cell(5, 6)};
        Figure knight = new Knight("black", new Cell(4, 4));
        Cell[] result = knight.way(new Cell(5, 6));
        assertThat(result, is(highway));
    }
}

