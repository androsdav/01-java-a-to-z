package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SortingTest {

	@Test
	public void babbleSortingTest() {
		// Expected ArrayList
		int []bubbleExpected = {1, 2, 3, 4, 5};
		// Actual ArrayList	
		int []bubbleActual = {4, 5, 2, 3, 1};
		// Testing sort babble 				
		final Sorting sort = new Sorting(bubbleActual);
		bubbleActual = sort.babbleSorting();
		assertThat(bubbleActual, is(bubbleExpected));
	}
}
