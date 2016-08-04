package adidyk;

import static java.lang.Math.*;

public class Point {
    public double x;
    public double y;
    // Constructor
    public Point(double x, double y) {
    	this.x = x;
    	this.y = y;
    }
    // distanceTo - calculate line segment    
    public double distanceTo(Point point) {
    	return sqrt(pow((this.x - point.x),2) + pow((this.y - point.y),2));
    }
}