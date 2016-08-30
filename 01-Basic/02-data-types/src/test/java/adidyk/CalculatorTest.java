package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {

       @Test
       public void testAdd() {
              final Calculator calc = new Calculator();
              calc.add(1,5);
              final double result = calc.getResult();
              assertThat(result, is(6d));
       }

       @Test
       public void testSub() {
              final Calculator calc = new Calculator();
              calc.sub(10,3);
              final double result = calc.getResult();
              assertThat(result, is(7d));
       }

       @Test
       public void testDiv() {
              final Calculator calc = new Calculator();
              calc.div(6,2);
              double result = calc.getResult();
              assertThat(result, is(3d));
       }

       @Test
       public void testMult() {
              final Calculator calc = new Calculator();
              calc.mult(3,4);
              final double result = calc.getResult();
              assertThat(result, is(12d));
       }
}
