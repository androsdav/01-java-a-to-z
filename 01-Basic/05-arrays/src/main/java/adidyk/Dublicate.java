package adidyk;

public class Dublicate {
	private String []args;
	
	// Constructor
	public Dublicate(String []args) {
		this.args = args;
	}
	
	// method searchDublArray - searching dublicate in String Array and
	// return length new Array don`t have dublicate
	public int searchDublArray() {
		int unitDubl = 0;
		for (int i = 0; i < this.args.length - 1; i++) {
			for (int j = i + 1; j < this.args.length; j++) {
				if (this.args[i].equals(this.args[j])) {
					this.args[i] = "----";
					unitDubl = unitDubl + 1;
				}
			}
		}
		return (this.args.length - unitDubl);	
	}
	
	// method createNewArray - Creating new array and don`t have dublicate 
	public String [] createNewArray() {
	String []argsNew = new String[searchDublArray()];
		int j = 0;
		for (int i = 0; i < this.args.length; i++) {
			if (!this.args[i].equals("----")) {
				argsNew[j] = this.args[i];
				j = j + 1;
			} 
		}
		return argsNew;
	}
}                                                           