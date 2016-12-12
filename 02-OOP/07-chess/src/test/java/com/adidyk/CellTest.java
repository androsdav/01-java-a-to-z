package com.adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CellTest {

    private Cell cell = new Cell(3, 4);


    @Test
    public void getPositionXTest() {
        int positionX = 3;
        assertThat(this.cell.getPositionX(), is(positionX));
    }

    @Test
    public void getPositionYTest() {
        int positionY = 4;
        assertThat(this.cell.getPositionY(), is(positionY));
    }

}
