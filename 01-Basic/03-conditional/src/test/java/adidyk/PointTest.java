package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PointTest {
	final Point pointA = new Point(0, 0);
	final Point pointB = new Point(0, 3);
	final Point pointC = new Point(4, 0);
	final double lineAB = pointA.distanceTo(pointB);
	final double lineBC = pointB.distanceTo(pointC);
	final double lineCA = pointC.distanceTo(pointA);
	
	@Test 
	public void distanceToTest() {
		 assertThat(lineAB, is(3d));
		 assertThat(lineBC, is(5d));
		 assertThat(lineCA, is(4d));
	}
}
