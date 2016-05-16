package algos;


/**Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

Example: 
given array S = {-1 2 1 -4}, 
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

When the array is sorted, try to fix the least integer by looping over it.

Lets say the least integer in the solution is arr[i].

Now we need to find a pair of integers j and k, such that arr[j] + arr[k] is closest to (target - arr[i]).

To do that, let us try the 2 pointer approach.

If we fix the two pointers at the end ( that is, i+1 and end of array ), we look at the sum.

If the sum is smaller than the sum we need to get to, we increase the first pointer.
If the sum is bigger, we decrease the end pointer to reduce the sum.
 * 
 */

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumClosest {
	
	public int threeSumClosest(ArrayList<Integer> nums, int target) {
		
		int min = Integer.MAX_VALUE;
		int result = 0;
	 
		Collections.sort(nums);
	 
		for (int i = 0; i < nums.size(); i++) {
			int j = i + 1;
			int k = nums.size() - 1;
			while (j < k) {
				int sum = nums.get(i) + nums.get(j) + nums.get(k);
				
				int diff = Math.abs(sum - target);
	 
				if(diff == 0) return sum;
	 
				if (diff < min) {
					min = diff;
					result = sum;
				}
				if (sum <= target) {
					j++;
				} else {
					k--;
				}
			}
		}
	 
		return result;
		}

}
