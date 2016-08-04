package adidyk;

import java.util.ArrayList;

public class Sorting {
	int min = 0;
	ArrayList<Integer> bubble;
	
	//Constructor
	public Sorting(ArrayList<Integer> bubble) {
		this.bubble = bubble;
	}
	
	// Method babbleSort - sorting babble Array
	public ArrayList babbleSort() {
		boolean flag = true;
		while (flag) {
			for (int j = bubble.size() - 1; j > 0; j--) {
				for (int i = 0; i < j; i++) {
					if (this.bubble.get(i) > this.bubble.get(i + 1)) {
						min = this.bubble.get(i + 1);
						this.bubble.set(i + 1, this.bubble.get(i));
						this.bubble.set(i, min);
					}	
					else {
						flag = false;
					}
				}
			}
			flag = false;
		}
		return this.bubble;
	}
}