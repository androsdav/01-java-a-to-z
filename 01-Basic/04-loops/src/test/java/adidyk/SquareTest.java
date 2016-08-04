package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class SquareTest {

	
	@Test
	public void calculateTest() {
		ArrayList yFunc = new ArrayList();
		Square square = new Square(1, 0, 0, 0, 3, yFunc);		
		double y = square.calculate(5);
		assertThat(y, is(25d));
	}
	
	@Test
	public void getYfuncArrayTest() {
		ArrayList yTest = new ArrayList();
		yTest.add(0.0);
		yTest.add(1.0);
		yTest.add(4.0);
		ArrayList yFunc = new ArrayList();
		Square square = new Square(1, 0, 0, 0, 3, yFunc);		
		yFunc = square.getYfuncArray(1);
		assertThat(yFunc, is(yTest));
	}
}
