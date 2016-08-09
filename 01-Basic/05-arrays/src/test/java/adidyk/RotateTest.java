package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RotateTest {

	@Test
	public void rotate() {
		// Expected ArrayList
		int [][]argsExpected = {
			{1, 2, 3, 4},
			{1, 2, 3, 4},
			{1, 2, 3, 4},
			{1, 2, 3, 4}
		};
		// Actual ArrayList	
		int [][]argsActual = {
			{4, 4, 4, 4},
			{3, 3, 3, 3},
			{2, 2, 2, 2},
			{1, 1, 1, 1}
		};
		// Testing rotate quadro Array 				
		final Rotate rota = new Rotate();
		argsActual = rota.rotate(argsActual);
		assertThat(argsActual, is(argsExpected));
	}
}
