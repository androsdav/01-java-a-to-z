package adidyk;

public class Sorting {
	int []bubble;
	
	//Constructor
	public Sorting(int []bubble) {
		this.bubble = bubble;
	}
	
	// Method babbleSort - sorting babble Array
	public int [] babbleSorting() {
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
	}
}