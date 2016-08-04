package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class SortingTest {

	@Test
	public void babbleSortTest() {
		// Expected ArrayList
		ArrayList<Integer> bubbleExpected = new ArrayList<Integer>();
		bubbleExpected.add(1);
		bubbleExpected.add(2);
		bubbleExpected.add(3);
		bubbleExpected.add(4);
		bubbleExpected.add(5);
		// Actual ArrayList	
		ArrayList<Integer> bubbleActual = new ArrayList<Integer>();
		bubbleActual.add(4);
		bubbleActual.add(5);
		bubbleActual.add(2);
		bubbleActual.add(3);
		bubbleActual.add(1);
		// Testing sort babble 				
		final Sorting sort = new Sorting(bubbleActual);
		bubbleActual = sort.babbleSort();
		assertThat(bubbleActual, is(bubbleExpected));
	}
}
