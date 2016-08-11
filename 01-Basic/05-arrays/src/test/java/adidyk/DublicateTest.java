package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
//import java.util.ArrayList;

public class DublicateTest {

	@Test
	public void searcDubl() {
		// Expected ArrayList
		String []argsExpected = {"horse", "false", "pig", "false", "false", "false", "dog", "cat", "elephant", "mouse"};
		// Actual ArrayList	
		String []argsActual = {"horse", "dog", "pig", "elephant", "cat", "dog", "dog", "cat", "elephant", "mouse"};
		// Testing sort babble 				
		final Dublicate dubl = new Dublicate(argsActual);
		argsActual = dubl.searchDubl();
		assertThat(argsActual, is(argsExpected));
		
		int size = dubl.getSize();
		assertThat(size, is(5));
		
	}
} 
