package adidyk;

public class Dublicate {
	final String []args;
	final int []position;
	int unit = 0;
	
	// Constructor
	public Dublicate(String []args) {
		this.args = args;
		this.position = new int[args.length];
	}
	// method searchDubl - searching dublicate  
	public String []  searchDubl() {
		//int unit = 0;
		for (int i = 0; i < this.args.length - 1; i++) {
			for (int j = i + 1; j < this.args.length; j++) {
				if (this.args[i].equals(this.args[j])) {
					this.args[i] = "false";
				} else {
					//this.position[k] = i;
					this.unit = this.unit + 1;
				}
				
				//	this.position[i] =
					//sum = sum + 1;
				}
			}
		return this.args;	
	}
	
	public int getSize() {
		return this.unit;
	}
}


                                                                 