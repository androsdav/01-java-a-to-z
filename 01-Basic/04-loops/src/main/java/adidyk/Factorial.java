package adidyk;

import java.util.ArrayList;

public class Factorial {
	int n;	
	int factorial = 1;
	//Constructor
	public Factorial(int n) {
		this.n = n;
	}
	// method validFactorial - inspection valid factorial
	public boolean validFactorial() {
		boolean flagValidFactorial = false;
		if (n < 0) {
			flagValidFactorial = false;
			System.out.println("Can`t create factorial.");
		} else {
			flagValidFactorial = true;
		}
		return flagValidFactorial;
	}
	// method Calculate - calculate function on the interval x1 to x2, with a step
	public void calculate() {
		if (n == 0) {
			this.factorial = 1;
		} else {
			for (int i = 1; i < n + 1; i++) {
				this.factorial = this.factorial * i;
			}	
		} 
 	}
 	// method getFactorial - getting factorial value n 
 	public int getFactorial() {
 		return this.factorial;
 	}
}