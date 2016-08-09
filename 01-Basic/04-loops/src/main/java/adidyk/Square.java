package adidyk;

import java.util.ArrayList;

public class Square {
	final float paramA;
	final float paramB;
	final float paramC;
			
	//Constructor 
	public Square(float paramA, float paramB, float paramC) {
		this.paramA = paramA;
		this.paramB = paramB;
		this.paramC = paramC;
	}

	// calculate function on the point rootX
	public float calculate(float rootX) {
		return (this.paramA * rootX * rootX + this.paramB * rootX + this.paramC);
	}
	// calculate function on the interval x1 to x2, with a step
	public ArrayList<Float> range(float step, float startX1, float finishX2) {
		ArrayList<Float> functionY = new ArrayList<Float>();
		for (float i = startX1; i < finishX2; i = i + step) {
			functionY.add(calculate(i));
		}
		return functionY;
	}
}