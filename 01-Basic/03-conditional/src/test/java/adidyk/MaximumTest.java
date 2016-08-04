package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MaximumTest {

	@Test 
	public void maxTest() {
		Maximum maximum = new Maximum();
		double maxLine = maximum.max(10, 20, 30);
		assertThat(maxLine, is(30d));
	}
}