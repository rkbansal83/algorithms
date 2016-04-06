package algos;

/**
 * 
 * @author RAVI
 *
 */
public class MaxHeapify {

	
	
	public static void heapify(int[] arr,int index) {
		
		int maxIndex = index;
		int left = maxIndex*2+1;
		int right = maxIndex*2+2;
		
		if(left<arr.length && arr[left]>arr[maxIndex])
			maxIndex=left;
		
		if(right<arr.length && arr[right]>arr[maxIndex])
			maxIndex=right;
		
		if(maxIndex!=index)
		{
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[index];
			arr[index] = temp;
			heapify(arr,maxIndex);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		int arr[] = {8,10,6,2,11,14,16,19,15};
		
		for(int i=(arr.length-1)/2;i>=0;i--)
			heapify(arr,i);
		
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	
}
