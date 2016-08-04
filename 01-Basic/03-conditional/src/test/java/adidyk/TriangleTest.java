package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TriangleTest {
	final Point pointA = new Point(0, 0);
	final Point pointB = new Point(0, 3);
	final Point pointC = new Point(4, 0);
	final Triangle triangle = new Triangle(pointA, pointB, pointC);
	
	@Test 
	public void validTriangleTest() {
		boolean valid = triangle.validTriangle();
		assertTrue(valid);
	}
	
	@Test
	public void areaTest() {
		final double areaTriangle = triangle.area();
		assertThat(areaTriangle, is(6d));
	}
}
