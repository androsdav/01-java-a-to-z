package adidyk;

import java.util.ArrayList;

public class Square {
	float paramA;
	float paramB;
	float paramC;
	float startX1;
	float finishX2;
		
	//Constructor 
	public Square(float paramA, float paramB, float paramC, float startX1, float finishX2) {
		this.paramA = paramA;
		this.paramB = paramB;
		this.paramC = paramC;
		this.startX1 = startX1;
		this.finishX2 = finishX2;
	}

	// calculate function on the point rootX
	public float calculate(float rootX) {
		return (this.paramA * rootX * rootX + this.paramB * rootX + this.paramC);
	}
	// calculate function on the interval x1 to x2, with a step
	public ArrayList<Float> getYfuncArray(float step, ArrayList<Float> functionY) {
		for (float i = this.startX1; i < this.finishX2; i = i + step) {
			functionY.add(calculate(i));
		}
		return functionY;
	}
}