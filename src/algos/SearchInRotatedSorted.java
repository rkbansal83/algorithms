package algos;

public class SearchInRotatedSorted {

	
	public static void main(String[] arg) {
		int[] input = {4,5,6,7,8,1,2};
		int idx= search(input,1);
		System.out.println("key at ::"+idx);
	}
	
	
	public static int search(int[] a, int key) {
		
		int found = -1;
		int low = 0;
		int high = a.length-1;
		
		if(a == null || a.length == 0) {
            return found;
        }
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			
			if(a[mid]==key)
				return mid;
			
			//check if lower half is sorted
			if(a[low]<a[mid]) {
				
				if(a[low]<=key && key<=a[mid])
					high = mid-1;
				else low =mid+1;
				
			}
			
			else
			{
				
				if(a[mid]<=key && key<=a[high])
					low = mid+1;
				else
					high = mid-1;
			}
		}
			
		return found;
	}
	
}
