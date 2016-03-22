package algos;

import java.util.ArrayList;

public class CommonElementsSortedArrays {

	public static void main(String[] args) {

		int[][] arrays = { { 23, 34, 67, 89, 123, 566, 1000 }, { 11, 22, 23, 24, 33, 37, 185, 566, 987, 1223, 1234 },
				{ 23, 43, 67, 98, 566, 678 }, { 1, 4, 5, 23, 34, 76, 87, 132, 566, 665 },
				{ 1, 2, 3, 23, 24, 344, 566 } };
		

		int len = arrays[0].length;
		int[] foundIndexes = new int[arrays.length - 1];
		
		ArrayList<Integer> results = new ArrayList<Integer>();

		for (int i = 0; i < len; i++) {
			int totalFound = 0;
			
			for (int j = 1; j < arrays.length; j++) {

				int idx = binarySearch(arrays[j], foundIndexes[j - 1], arrays[j].length - 1, arrays[0][i]);
				if (idx != -1) {

					foundIndexes[j - 1] = idx;
					totalFound++;
				}
				
				if(totalFound==arrays.length-1) {
					results.add(arrays[0][i]);
				}
			}

		}
		System.out.println(results);
	}
	
	private static int binarySearch(int[] input, int start, int end, int key) {

		while (start <= end) {
			int mid = (start + end) / 2;
			if (input[mid] == key) {
				return mid;
			} else if (input[mid] > key) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return -1;
	}
	
}
