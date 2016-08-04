package adidyk;

import static java.lang.Math.*;

public class Maximum {
    // max - calculate length of line segment
    public double max(double lineAB, double lineBC, double lineCA) {
    	double maxLine;
    	maxLine = lineAB > lineBC ? lineAB : lineBC;
    	maxLine = maxLine > lineCA ? maxLine : lineCA;
    	return maxLine;
    }       
}