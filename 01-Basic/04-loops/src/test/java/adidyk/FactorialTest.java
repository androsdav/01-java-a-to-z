package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class FactorialTest {

	@Test
	public void validFactorialTest() {
		final Factorial factorial = new Factorial(1);
		final boolean flagValidFactorial = factorial.validFactorial();
		assertTrue(flagValidFactorial);
	}
	
	@Test
	public void calculaleTest() {
		final Factorial factorial = new Factorial(4);
		factorial.calculate();
		final int resultFactorial = factorial.getFactorial();
		assertThat(resultFactorial, is(24));
	}
}
