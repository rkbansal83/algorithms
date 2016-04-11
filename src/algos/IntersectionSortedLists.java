package algos;

import java.util.ArrayList;
import java.util.List;

public class IntersectionSortedLists {
	/** avoid binary search in this case as lists are of same size **/

	public static void main(String[] args) {
		int arr1[] = { 5, 10, 15, 20, 25, 30 };
		int arr2[] = { 10, 11, 12, 18, 19, 20 };

		List<Integer> result = findCommon(arr1, arr2);

		System.out.println(result);
	}

	public static List<Integer> findCommon(int[] arr1, int arr2[]) {

		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				result.add(arr1[i]);
				i++;
				j++;
			}

			else if (arr1[i] < arr2[j])
				i++;

			else
				j++;

		}

		return result;

	}
}
