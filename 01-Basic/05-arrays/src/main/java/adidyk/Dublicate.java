package adidyk;

public class Dublicate {
	final String []args;
	final int []position; 
	
	// Constructor
	public Dublicate(String []args) {
		this.args = args;
		this.position = new int[args.length];
		
	}
	// method searchDubl - searching dublicate  
	public String []  searchDubl() {
		
		for (int i = 0; i < this.args.length - 1; i++) {
			for (int j = i + 1; j < this.args.length; j++) {
				if (this.args[i].equals(this.args[j])) {
					this.args[j] = "false";
				//	this.position[i] =
					//sum = sum + 1;
				}
			}
		}
		return this.args;
	}

}





	/*int []bubble;
	
	//Constructor
	public Sorting(int []bubble) {
		this.bubble = bubble;
	}
	
	// Method babbleSort - sorting babble Array
	/*public int [] babbleSorting() {
		boolean flag = true;
		int min;
		while (flag) {
			for (int j = bubble.length - 1; j > 0; j--) {
				for (int i = 0; i < j; i++) {
					if (this.bubble[i] > this.bubble[i + 1]) {
						min = this.bubble[i + 1];
						this.bubble[i + 1] = this.bubble[i];
						this.bubble[i] = min;
					}	
					else {
						flag = false;
					}
				}
			}
			flag = false;
		}
		return this.bubble;
	}*/
