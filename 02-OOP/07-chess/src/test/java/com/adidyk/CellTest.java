package com.adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CellTest {

    Cell cell = new Cell(3, 4);
    int positionX = 3;
    int positionY = 4;

    @Test
    public void getPositionXTest() {
        assertThat(cell.getPositionX(), is(this.positionX));
    }

    @Test
    public void getPositionYTest() {
        assertThat(cell.getPositionY(), is(this.positionY));
    }


}
