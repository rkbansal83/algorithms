package algos;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length in O(1) complexity.
 * For example, if the input array is {1, 2, 2, 3, 4}, the array will be changed to {1, 2, 3, 4, 3}.
 */

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] A) {
		if (A.length < 2)
			return A.length;
	 
		int j = 0;
		int i = 1;
	 
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
	 
		return j + 1;
	}
}
