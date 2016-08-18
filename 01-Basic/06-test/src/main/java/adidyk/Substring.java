package adidyk;

public class Substring {
		
		// Splitting origin string and substring, search substring in origin
		// string: return "true" if hi`s, return "false" if hi isn`t 
		public boolean subSearch(String origin, String sub) {
			boolean validSub = false;
			char []originArray = origin.toCharArray();
			char []subArray = sub.toCharArray();
			int sumSub = 0;
			// search subArray in originArray
			for (int i = 0; i <= originArray.length - subArray.length; i++) {
				for (int j = 0; j < subArray.length; j++) {
					if (subArray[j] == originArray[i + j]) {
						sumSub = sumSub + 1;
					} else {
						j = subArray.length - 1;
					}
				}
				if (sumSub == subArray.length) {
					validSub = true;
				}
				sumSub = 0;
			}
			return validSub;
		} 
}