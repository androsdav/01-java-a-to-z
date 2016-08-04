package adidyk;

import static java.lang.Math.*;

public class Triangle {
    public Point a;
    public Point b;
    public Point c;
    // Constructor
    public Triangle(Point a, Point b, Point c) {
    	this.a = a;
    	this.b = b;
    	this.c = c;
    }
    // validtriangle - test validation Triangle
    public boolean validTriangle() {
    	boolean flagValidTriangle = false;
    	double lineAB = this.a.distanceTo(b);
    	double lineBC = this.b.distanceTo(c);
    	double lineCA = this.c.distanceTo(a); 
    	if ((lineAB + lineBC) > lineCA & (lineBC + lineCA) > lineAB & (lineCA + lineAB) > lineBC) {
    		flagValidTriangle = true;
    	}
    	else {
    		System.out.println("Can`t create Triangle");
    		flagValidTriangle = false;
    	}
    	return flagValidTriangle;
    } 
    // area - calculate area Triangle
    public double area() {   
    	double perim = (this.a.distanceTo(b) + this.b.distanceTo(c) + this.c.distanceTo(a)) / 2;
    	return sqrt(perim * (perim - this.a.distanceTo(b)) * (perim - this.b.distanceTo(c)) * (perim - this.c.distanceTo(a)));
    }

}