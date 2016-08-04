package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
//import java.util.ArrayList;

public class SortingArrayTest {

	@Test
	public void babbleSortTest() {
		// Expected ArrayList
		int []bubbleExpected = {1, 2, 3, 4, 5};
		// Actual ArrayList	
		int []bubbleActual = {4, 5, 2, 3, 1};
		// Testing sort babble 				
		final SortingArray sort = new SortingArray(bubbleActual);
		bubbleActual = sort.babbleSort();
		assertThat(bubbleActual, is(bubbleExpected));
	}
}
