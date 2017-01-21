package algos;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * max sliding window as [3,3,5,5,6,7].
 *
 */

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		
		int[]  nums={1,3,-1,-3,5,3,6,7};
		int k=3;
		
		int[] result = getMaxSlidingWindow(nums,k);
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+" ");
	}
	
	static int[] getMaxSlidingWindow(int[] input,int k) {
		Deque<Integer> queue= new ArrayDeque<>(k);
		int size = input.length;
		int[] result = new int[size-k+1];
		
		for(int i=0;i<k;i++){
			while(!queue.isEmpty() && input[i]>=input[queue.getLast()])
				queue.removeLast();
			queue.addLast(i);
		}
		result[0]=input[queue.getFirst()];
		
		for(int i=k;i<size;i++){
			while(queue.isEmpty() && queue.getFirst()<i-k+1)
				queue.removeFirst();
			while(!queue.isEmpty() && input[i]>=input[queue.getLast()])
				queue.removeLast();
			queue.addLast(i);
			result[i-k+1]=input[queue.getFirst()];
		}
		
		return result;
	}
}
