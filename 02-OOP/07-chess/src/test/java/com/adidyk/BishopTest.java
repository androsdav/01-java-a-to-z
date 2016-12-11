package com.adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BishopTest {

    @Test
    public void wayTest() {
        Cell[] highway = {new Cell(6, 5), new Cell(7, 6), new Cell(8, 7)};
        Figure bishop = new Bishop("black", new Cell(5, 4));
        Cell[] result = bishop.way(new Cell(8, 7));
        assertThat(result, is(highway));
    }

}
