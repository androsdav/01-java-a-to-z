package adidyk;

import java.util.ArrayList;

public class Square {
	double a;
	double b;
	double c;
	double x1;
	double x2;
	ArrayList y;
	
	//Constructor 
	public Square(double a, double b, double c, double x1, double x2, ArrayList y) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.x1 = x1;
		this.x2 = x2;
		this.y = y;
	}

	// calculate function on the interval x1 to x2, with a step
	public double calculate(double i) {
		return (this.a * i * i + this.b * i + this.c);
	}
	
	public ArrayList getYfuncArray(double step) {
		for (double i = this.x1; i < this.x2; i = i+step) {
			this.y.add(calculate(i));
		}
		return this.y;
	}
}