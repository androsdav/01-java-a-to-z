package adidyk;

public class Rotate {
	
	
	//Constructor
	//public Rotate(int [][]squareArray) {
	//	this.squareArray = squareArray;
	//}
	
	// Method babbleSort - sorting babble Array
	public int [][] rotateQuadroArray(int [][]squareArray) {
		int temp;
		int length1 = squareArray.length;  
		for (int  i = 0; i < length1; i++) {
			for (int j = 0; j < length1; j++) {
				temp = squareArray[i][j];
				squareArray[i][j] = squareArray[length1 - j][i];
				squareArray[length1 - j][i] = squareArray[length1 - i][length1 - j];
				squareArray[length1 - i][length1 - j] = squareArray[j][length1 - i];
				squareArray[j][length1 - i] = temp;
			
			//	squareArray[i][j] = squareArray[j][length - i];
			//	squareArray[j][length - i] = squareArray[length - i][length - j];
			//	squareArray[length - i][length - j] = squareArray[length - j][i];
			//	squareArray[length - j][i] = squareArray[i][j];
			}
		}
		return squareArray; 
	}
}