package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RotateTest {

	@Test
	public void rotateQuadroArrayTest() {
		// Expected ArrayList
		int [][]rotateExpected = {
			{1, 7, 4, 0},
			{2, 8, 0, 1},
			{3, 0, 5, 2},
			{0, 9, 6, 3},
		};
		// Actual ArrayList	
		int [][]rotateActual = {
			{0, 1, 2, 3},
			{4, 0, 5, 6},
			{7, 8, 0, 9},
			{1, 2, 3, 0},
		};
		// Testing rotate quadro Array 				
		final Rotate rota = new Rotate();
		rotateActual = rota.rotateQuadroArray(rotateActual);
		//assertThat(rotateActual, is(rotateExpected));
		assertArrayEquals(rotateActual, rotateExpected);
	}
}
