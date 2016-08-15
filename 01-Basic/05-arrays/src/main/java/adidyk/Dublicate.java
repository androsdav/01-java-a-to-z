package adidyk;

public class Dublicate {
	private String []args;
	
	// Constructor
	public Dublicate(String []args) {
		this.args = args;
	}
	
	// Searching dublicate, move left all array on one position - deleting dublicate,
	// and last element of array assigning "null", so, and return length new Array don`t have dublicate
	public int searchDublArray() {
		int shift = 0;
		for (int i = 0; i < this.args.length - 1; i++) {	
			for (int j = i + 1; j < this.args.length; j++) {
				if ((this.args[i].equals(this.args[j])) & (!this.args[i].equals("null"))) {
					for (int k = i; k < this.args.length - 1; k++) {
						this.args[k] = this.args[k + 1];
					}
					this.args[this.args.length - 1 - shift] = "null";
					shift = shift + 1;
					j = i;
				}
			}
			
		}
		return this.args.length - shift;
	}
	
	// Creating new array and don`t have dublicate 
	public String [] createNewArray() {
		String []argsNew = new String[searchDublArray()];
		System.arraycopy(this.args, 0, argsNew, 0, argsNew.length);
		return argsNew;
	}
}                                                           