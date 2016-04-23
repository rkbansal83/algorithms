package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
 * @author RAVI
 *
 */
public class MaxPositiveSubArray {
	public static ArrayList<Integer> findMaxPositiveSubArray(List<Integer> a) {
	    
	    ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> interimResult = new ArrayList<Integer>();
		int currSum=0;
		int maxSumSoFar =0;

		
		for(int i=0;i<a.size();i++) {
			
			if(a.get(i)>=0){
				currSum = currSum + a.get(i);
				if(currSum<0)
					currSum = Integer.MAX_VALUE;
				
				interimResult.add(a.get(i));
			}
			
			else{
				if(currSum>maxSumSoFar || (currSum==maxSumSoFar && interimResult.size()>result.size())) {
					maxSumSoFar = currSum;
					result= interimResult;
				}
				currSum=0;
				interimResult=new ArrayList<Integer>();
			}
			
			if(currSum>maxSumSoFar || (currSum==maxSumSoFar && interimResult.size()>result.size())) {
				result= interimResult;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		  Integer[] arr = new Integer[] {1, 2, 5, -7, 2, 3}; 
		  System.out.println(findMaxPositiveSubArray(Arrays.asList(arr)));
	}
}
