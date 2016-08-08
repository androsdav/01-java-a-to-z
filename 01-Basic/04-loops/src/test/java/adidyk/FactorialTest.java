package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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
		final int resultFactorial = factorial.calculate();
		assertThat(resultFactorial, is(24));
	}
}
