package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class SquareTest {

	@Test
	public void calculateTest() {
		Square square = new Square(1, 0, 0);		
		float functionY = square.calculate(5);
		assertThat(functionY, is(25f));
	}
	
	@Test
	public void rangeTest() {
		ArrayList<Float> yTest = new ArrayList<Float>();
		float funcY1 = 0;
		float funcY2 = 1;
		float funcY3 = 4;
		yTest.add(funcY1);
		yTest.add(funcY2);
		yTest.add(funcY3);
		ArrayList<Float> yFunc = new ArrayList<Float>();
		Square square = new Square(1, 0, 0);		
		yFunc = square.range(1, 0, 3);
		assertThat(yFunc, is(yTest));
	}
}
