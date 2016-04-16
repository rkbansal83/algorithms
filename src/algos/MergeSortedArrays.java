package algos;

import java.util.ArrayList;
import java.util.List;

import ds.heaps.BinaryMinHeap;

public class MergeSortedArrays {
	
	public static void main(String[] args) {
		
		int[] a1 = {1,3,5,7};
		int[] a2 = {2,4,6,8};
		int[] a3 = {11,12};
		
		MergeSortedArrays msa = new MergeSortedArrays();
		List<Integer> result = msa.merge(new int[][] {a1,a2,a3});
		
		System.out.println(result);
	}
	
	class ArrayEntry implements Comparable<ArrayEntry> {
		Integer element;
		
		public Integer getElement() {
			return element;
		}

		public ArrayEntry(int element, int index) {
			this.element = element;
			this.index = index;
		}
		int index;

		public int getIndex() {
			return index;
		}

		@Override
		public int compareTo(ArrayEntry o) {
			// TODO Auto-generated method stub
			return  this.element.compareTo(o.element);
		}

		
	}
	
	public List<Integer> merge(int[][] arr) {
		List<Integer> result = new ArrayList<Integer>();
		BinaryMinHeap<ArrayEntry> minHeap = new BinaryMinHeap<ArrayEntry>(arr.length);
		int[] indexesProcessed = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			ArrayEntry entry = new ArrayEntry(arr[i][0],i);
			minHeap.insert(entry);
		}
		while(!minHeap.isEmpty()) {
			result.add(minHeap.getMinimum().getElement());
			int arrayIdx = minHeap.getMinimum().getIndex();
			minHeap.removeMin();
			indexesProcessed[arrayIdx] ++ ;
			
			if(indexesProcessed[arrayIdx]<arr[arrayIdx].length){
				ArrayEntry entry = new ArrayEntry(arr[arrayIdx][indexesProcessed[arrayIdx]],arrayIdx);
				minHeap.insert(entry);
			}
		}
		
		return result;

	}
}
