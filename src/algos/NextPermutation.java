package algos;

import java.util.ArrayList;
import java.util.List;
/**
		 Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.
		
		 If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.
		
		 The replacement must be in-place, do not allocate extra memory.
		 1,2,3 ---->1,3,2
		 3,2,1----->1,2,3
		 1,1,5----->1,5,1
 * @author RAVI
 *
 */
public class NextPermutation {

	public void nextPermutation(ArrayList<Integer> a) {
	    
	    int partitionIdx = a.size()-2;
		while(partitionIdx>0 && a.get(partitionIdx)>a.get(partitionIdx+1))
			partitionIdx--;
		if(partitionIdx<0)
			partitionIdx=0;
		
		int swapIdx = a.size()-1;
		while(swapIdx>=0 && a.get(swapIdx)<a.get(partitionIdx))
				swapIdx--;
		
		if(swapIdx<0)
			swapIdx=0;
		
		if(partitionIdx==0 && swapIdx==0)
		{
			int left=0;
		    int right = a.size()-1;
			while(left<right) {
				swap(a,left,right);
				left++;
				right--;
			}
			return ;
		} 
		swap(a,partitionIdx,swapIdx);
		for(int i=partitionIdx+1,j=a.size()-1;j>i;i++,j--)
			swap(a,i,j);
		}
		
	private void swap(List<Integer> in , int from , int to) {
		int temp = in.get(from);
		in.set(from, in.get(to));
		in.set(to, temp);
		
	}
}
