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
	    
	    int curr_sum=0, max_sum=0;
	    ArrayList<Integer> interimList = new ArrayList<Integer>(); 
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    
	    for(int i=0;i<a.size();i++) {
	            
	        if(a.get(i)>=0) {
	            
	            curr_sum = curr_sum+a.get(i);
	            
	            if(curr_sum<0) {
	                curr_sum = Integer.MAX_VALUE;
	            
	            }
	            interimList.add(a.get(i));
	        }
	        
	         if(curr_sum>max_sum || (curr_sum==max_sum && res.size()<interimList.size() )) {
	                
	                max_sum = curr_sum;
	                res = interimList;
	            }
	        if(a.get(i)<0) {
	       
	            curr_sum=0;
	            interimList = new ArrayList<Integer>();
	        }
	    }
	    
	    return res;
	}
	
	public static void main(String[] args) {
		  Integer[] arr = new Integer[] {1, 2, 5, -7, 2, 3}; 
		  System.out.println(findMaxPositiveSubArray(Arrays.asList(arr)));
	}
}
