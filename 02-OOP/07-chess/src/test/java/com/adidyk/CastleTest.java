package com.adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CastleTest {

    @Test
    public void wayTest() {
        Cell[] highway = {new Cell(6, 3), new Cell(5, 3), new Cell(4, 3), new Cell(3, 3)};
        Figure castle = new Castle("black", new Cell(7, 3));
        Cell[] result = castle.way(new Cell(3, 3));
        assertThat(result, is(highway));
    }

}
