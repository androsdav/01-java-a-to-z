package adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ContainsTest {
	// Expected New String List
	String originActual = "Teacher open the door, but you must enter by yourself.";
	// Expected String List
	char []originExpected = { 
		'T', 'e', 'a', 'c', 'h', 'e', 'r', ' ', 'o', 'p', 'e', 'n', ' ', 't', 
		'h', 'e', ' ', 'd', 'o', 'o', 'r', ',', ' ', 'b', 'u', 't', ' ', 'y',
		'o', 'u', ' ', 'm', 'u', 's', 't', ' ', 'e', 'n', 't', 'e', 'r', ' ',
		'b', 'y', ' ', 'y', 'o', 'u', 'r', 's', 'e', 'l', 'f', '.'};
	
	@Test
	public void splittingTest() {
		Contains cont = new Contains();
		char []origin = cont.splitting(originActual);
		assertThat(origin, is(originExpected));
	}
}