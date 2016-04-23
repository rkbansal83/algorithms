package algos;

import java.util.Arrays;
import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

	For example:

	Given the array [-2,1,-3,4,-1,2,1,-5,4],

	the contiguous subarray [4,-1,2,1] has the largest sum = 6.

	For this problem, return the maximum sum.
 * @author RAVI
 *
 */
public class MaxSumSubArray {

	public static int maxSubArray(final List<Integer> a) {
	    
	    int current_max = a.get(0);
		int max_so_far = current_max;
		
		for(int j=1;j<a.size();j++){
			current_max = Math.max(a.get(j), current_max+a.get(j));
			max_so_far = Math.max(max_so_far, current_max);
		}
		return max_so_far;
		}
	
	public static void main(String[] args) {
	    Integer[] input = new Integer[] {2, -9, 5, 1, -4, 6, 0, -7, 8};
	    System.out.println("Maximum subarray sum is " + maxSubArray(Arrays.asList(input)));
	    
	}
	
}
