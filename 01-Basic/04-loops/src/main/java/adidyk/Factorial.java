package adidyk;

public class Factorial {
	int numberN;	
	
	//Constructor
	public Factorial(int numberN) {
		this.numberN = numberN;
	}
	
	// method validFactorial - inspection valid factorial
	public boolean validFactorial() {
		boolean flagValidFactorial = false;
		if (this.numberN < 0) {
			flagValidFactorial = false;
			System.out.println("Can`t create factorial.");
		} else {
			flagValidFactorial = true;
		}
		return flagValidFactorial;
	}
	
	// method calculate - calculate factorial
	public int calculate() {
		int factorial = 1;
		if (this.numberN == 0) {
			factorial = 1;
		} else {
		for (int i = 2; i < this.numberN + 1; ++i) {
			factorial *= i;
			}	
		}
		return factorial;
 	}
}