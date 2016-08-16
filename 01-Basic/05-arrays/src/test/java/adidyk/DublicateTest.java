package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DublicateTest {
	// Expected New String List
	final String []argsNewExpected = {
		"horse", "pig", "fox", "dog", "cat", "elephant", "mouse", "wolf"
	};
	// Expected String List
	final String []argsExpected = {
		"horse", "pig", "fox", "dog", "cat", "elephant", "mouse", "wolf", null, null, null, null, null
	};
	// Actual String List	
	final String []argsActual = {
		"horse", "dog", "pig", "elephant", "fox", "cat", "dog", "dog", "wolf", "cat", "elephant", "mouse", "wolf"
	}; 				
	final Dublicate dubl = new Dublicate(argsActual);

	@Test
	public void searchDublArrayTest() {
		int size = this.dubl.searchDublArray();
		assertThat(size, is(8));
	}
	
	@Test
	public void createNewArrayTest() {				
		String []argsNewActual = this.dubl.createNewArray();
		assertThat(argsNewActual, is(this.argsNewExpected));
	}
}