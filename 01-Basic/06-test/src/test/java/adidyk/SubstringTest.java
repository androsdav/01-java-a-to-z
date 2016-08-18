package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SubstringTest {
	
	// Original string
	String originActual = "Teacher open the door, but you must enter by yourself.";
	// Substring for search in the original string
	String subActual = " the door, but you mu";
	
	// Array char split of origin string
	char []originExpected = { 
		'T', 'e', 'a', 'c', 'h', 'e', 'r', ' ', 'o', 'p', 'e', 'n', ' ', 't', 
		'h', 'e', ' ', 'd', 'o', 'o', 'r', ',', ' ', 'b', 'u', 't', ' ', 'y',
		'o', 'u', ' ', 'm', 'u', 's', 't', ' ', 'e', 'n', 't', 'e', 'r', ' ',
		'b', 'y', ' ', 'y', 'o', 'u', 'r', 's', 'e', 'l', 'f', '.'};
	// Array char split of substring
	char []subExpected = {'o', 'p', 'e', 'n'};
	
	@Test
	public void splittingTest() {
		Substring split = new Substring();	
		boolean valid = split.subSearch(originActual, subActual);
		assertTrue(valid);
	}
}