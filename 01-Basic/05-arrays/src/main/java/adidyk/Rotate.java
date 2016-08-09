package adidyk;

public class Rotate {
	// method rotate - Rotate Array tern right
	public int [][] rotate(int [][]args) {
		int temp;
		int step = 0; 
		int length = args.length - 1;  
		for (int  i = 0; i < length - i; i++) {
			for (int j = step; j < length - step; j++) {
				temp = args[i][j];
				args[i][j] = args[length - j][i];
				args[length - j][i] = args[length - i][length - j];
				args[length - i][length - j] = args[j][length - i];
				args[j][length - i] = temp;
			}
			step = step + 1;
		}
		return args; 
	}
}