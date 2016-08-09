//package adidyk;

public class Rotate {
	int [][]args;
	
	//Constructor
	public Rotate(int [][]args) {
		this.args = args;
	}
	
	// Method babbleSort - sorting babble Array
	
	public void rotate() {
        	int temp;
        	int step = 0;
			int length = this.args.length - 1;
			//for (int i = 0; i < this.args.length / 2; i++) {
			for (int i = 0; i < 1; i++) {
				//for (int j = 0; j < this.args.length; j++) {
				for (int j = 0; j < this.args.length; j++) {
					temp = this.args[i][j];
					this.args[i][j] = this.args[length - j][i];
					//this.args[length - j][i] = this.args[length - i][length - j];
					//this.args[length - i][length - j] = this.args[j][length - i];
					//this.args[j][length - i] = temp;
				}                 
                   // step = step + 1;
                }           
     }
     
     public void getArgs() {
     	 for (int i = 0; i < this.args.length; i++) {
     	 	 for (int j = 0; j < this.args.length; j++) {
     	 	 	 System.out.print(this.args[i][j] + " ");
             }
         	 System.out.println();           
         }
     }
}